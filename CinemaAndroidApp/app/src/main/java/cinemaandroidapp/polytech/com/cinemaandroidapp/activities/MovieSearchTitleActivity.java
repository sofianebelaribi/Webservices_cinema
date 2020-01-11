package cinemaandroidapp.polytech.com.cinemaandroidapp.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;

import cinemaandroidapp.polytech.com.cinemaandroidapp.R;
import cinemaandroidapp.polytech.com.cinemaandroidapp.adapters.MovieAdapter;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Category;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Director;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Movie;

/**
 * Created by franck on 26/01/18.
 */

public class MovieSearchTitleActivity extends ListActivity {

    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.movies = new ArrayList<>();
        listMovies();
    }

    public String getExtra(){
        Intent i = getIntent();
        String title = (String)i.getSerializableExtra("title");
        return title;
    }

    public void listMovies(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://5.51.148.35:8080/films";

        // Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //System.out.println(response.toString());
                        try {
                            JSONObject moviesJsonEmbed = response.getJSONObject("_embedded");
                            JSONArray moviesJson = moviesJsonEmbed.getJSONArray("films");

                            System.out.println(moviesJson);

                            for(int i = 0 ; i < moviesJson.length(); i++) {
                                JSONObject currentMovie = moviesJson.getJSONObject(i);

                                int id = Integer.parseInt(currentMovie.getString("noFilm"));
                                String title = currentMovie.getString("titre");
                                int length = Integer.parseInt(currentMovie.getString("duree"));
                                Date releaseDate = Date.valueOf(currentMovie.getString("dateSortie"));
                                int budget = Integer.parseInt(currentMovie.getString("budget"));
                                int benefits = Integer.parseInt(currentMovie.getString("montantRecette"));
                                int directorId = Integer.parseInt(currentMovie.getString("noRea"));

                                //Add category id to sent JSON
                                Category cat = new Category(1);
                                Director dir = new Director(directorId);

                                Movie m = new Movie(id, title, length, releaseDate, budget, benefits, cat, dir);
                                System.out.println(m.toString());
                                movies.add(m);
                            }

                            ArrayList<Movie> moviesTemp = new ArrayList<>();

                            for(Movie m : movies){
                                if(m.getTitle().contains(getExtra())){
                                    moviesTemp.add(m);
                                }
                            }

                            setListAdapter(new MovieAdapter(MovieSearchTitleActivity.this, moviesTemp));

                            MovieSearchTitleActivity.this.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent intent = new Intent(MovieSearchTitleActivity.this,MovieDetailsActivity.class);
                                    intent.putExtra("selectedMovie", movies.get(i));
                                    System.out.println("SelectedMovie = "+ movies.get(i));
                                    startActivity(intent);
                                    System.out.println("Activity changed.");
                                }
                            });

                            System.out.println(movies);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("That didn't work!");
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(request);
    }
}

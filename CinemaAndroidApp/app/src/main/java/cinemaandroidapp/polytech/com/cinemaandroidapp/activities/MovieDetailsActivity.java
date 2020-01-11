package cinemaandroidapp.polytech.com.cinemaandroidapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import cinemaandroidapp.polytech.com.cinemaandroidapp.R;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Movie;

/**
 * Created by franck on 25/01/18.
 */

public class MovieDetailsActivity extends AppCompatActivity{

    private Button editButton;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details_layout);

        this.printMovies(this.getMovie());

        this.editButton = findViewById(R.id.editButton);
        this.deleteButton = findViewById(R.id.deleteButton);
    }

    public Movie getMovie(){
        Intent i = getIntent();
        Movie m = (Movie)i.getSerializableExtra("selectedMovie");
        return m;
    }

    public void printMovies(Movie m){
        TextView movieTitle = (TextView) this.findViewById(R.id.movieTitle);
        TextView movieReleaseDate = (TextView) this.findViewById(R.id.movieReleaseDate);
        TextView movieLength = (TextView) this.findViewById(R.id.movieLength);
        TextView movieBudget = (TextView) this.findViewById(R.id.movieBudget);
        TextView movieBenefits = (TextView) this.findViewById(R.id.movieBenefits);
        TextView movieCategory = (TextView) this.findViewById(R.id.movieCategory);
        TextView movieDirector = (TextView) this.findViewById(R.id.movieDirector);

        movieTitle.setText(m.getTitle());
        movieReleaseDate.setText(String.valueOf(m.getReleaseDate()));
        movieLength.setText(String.valueOf(m.getLength()));
        movieBudget.setText(String.valueOf(m.getBudget()));
        movieBenefits.setText(String.valueOf(m.getBenefits()));
        movieCategory.setText(m.getCat().getName());
        movieDirector.setText(m.getDir().getName() + " " + m.getDir().getSurname());
    }


    public void editMovie(View view) {
        Intent i = new Intent(MovieDetailsActivity.this,MovieEditActivity.class);
        i.putExtra("selectedMovie", this.getMovie());
        startActivity(i);
        System.out.println("Activity changed.");
    }

    public void deleteMovie(View view) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://5.51.148.35:8080/films";
        StringRequest dr = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        System.out.println(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(String.valueOf(error));
                    }
                }
        );
        queue.add(dr);
    }
}

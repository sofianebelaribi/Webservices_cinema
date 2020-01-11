package cinemaandroidapp.polytech.com.cinemaandroidapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cinemaandroidapp.polytech.com.cinemaandroidapp.R;
import cinemaandroidapp.polytech.com.cinemaandroidapp.entities.Movie;

/**
 * Created by franck on 26/01/18.
 */

public class MovieAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(
                    R.layout.list_item, null);
        }

        TextView title = (TextView)convertView.findViewById(R.id.title);
        TextView date=(TextView)convertView.findViewById(R.id.date);

        title.setText(movies.get(position).getTitle());
        date.setText(String.valueOf(movies.get(position).getReleaseDate()).split("-")[0]);

        return convertView;
    }
}

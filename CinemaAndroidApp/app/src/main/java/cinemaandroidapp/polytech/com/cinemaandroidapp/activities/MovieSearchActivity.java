package cinemaandroidapp.polytech.com.cinemaandroidapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cinemaandroidapp.polytech.com.cinemaandroidapp.R;

/**
 * Created by franck on 26/01/18.
 */

public class MovieSearchActivity extends AppCompatActivity {

    private EditText inputTitle;
    private EditText inputDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_search);

        this.inputTitle = findViewById(R.id.inputTitle);
        this.inputDir = findViewById(R.id.inputDir);
    }

    public void searchTitle(View view) {
        Intent i = new Intent(MovieSearchActivity.this,MovieSearchTitleActivity.class);
        i.putExtra("title", this.inputTitle.toString());
        startActivity(i);
        System.out.println("Activity changed.");
    }

    public void searchDir(View view) {
        Intent i = new Intent(MovieSearchActivity.this,MovieSearchDirActivity.class);
        i.putExtra("name", this.inputDir.toString());
        startActivity(i);
        System.out.println("Activity changed.");
    }
}

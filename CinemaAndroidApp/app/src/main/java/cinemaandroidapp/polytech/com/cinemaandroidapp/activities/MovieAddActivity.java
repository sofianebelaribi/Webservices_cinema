package cinemaandroidapp.polytech.com.cinemaandroidapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import cinemaandroidapp.polytech.com.cinemaandroidapp.R;

/**
 * Created by franck on 25/01/18.
 */

public class MovieAddActivity extends AppCompatActivity {

    private EditText formTitle;
    private EditText formLength;
    private EditText formBudget;
    private EditText formBenefits;
    private EditText formReleaseDate;
    private Spinner formCategory;
    private Spinner formDirector;

    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_form);

        this.formTitle = findViewById(R.id.formTitle);
        this.formLength = findViewById(R.id.formLength);
        this.formReleaseDate = findViewById(R.id.formReleaseDate);
        this.formBudget = findViewById(R.id.formBudget);
        this.formBenefits = findViewById(R.id.formBenefits);

        this.formCategory = findViewById(R.id.formCategory);
        String[] items = new String[]{"Action", "Comedie", "Policier", "Western"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        this.formCategory.setAdapter(adapter);

        this.formDirector = findViewById(R.id.formDirector);
        String[] items2 = new String[]{"Oury", "Chabrol", "Besson", "Besnard"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        this.formDirector.setAdapter(adapter2);

        this.sendButton = findViewById(R.id.sendButton);
    }

    public void send(View v)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://5.51.148.35:8080/films";

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("noFilm", 21);
            jsonBody.put("titre", formTitle.toString());
            jsonBody.put("duree", formLength.toString());
            jsonBody.put("dateSortie", formReleaseDate.toString());
            jsonBody.put("budget", formBudget.toString());
            jsonBody.put("montantRecette", formBenefits.toString());
            jsonBody.put("noRea", String.valueOf(formDirector.getSelectedItemPosition()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String requestBody = jsonBody.toString();

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", String.valueOf(error));
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                return params;
            }

            @Override
            public byte[] getBody() {
                try {
                    return requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    // not supposed to happen
                    return null;
                }
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String,String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        queue.add(postRequest);
    }
}

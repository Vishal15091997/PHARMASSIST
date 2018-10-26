package com.example.pallabi.pharmiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    String id;

    TextView price,quantity,email,name;
    DetailsParse detailsParse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
       // final Bundle bundle = getIntent().getExtras().getBundle("DATA");
        id = getIntent().getStringExtra(Key.MED_ID);

        name = findViewById(R.id.textView);
        price = findViewById(R.id.textView7);
        quantity = findViewById(R.id.textView8);
        email = findViewById(R.id.textView9);

        getDetails();
    }
    private void getDetails() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url.URL_DETAILS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                detailsParse = new DetailsParse(response);
                detailsParse.getMedData();
                name.setText(detailsParse.name[0]);
                price.setText(detailsParse.price[0]);
                quantity.setText(detailsParse.quantity[0]);
                email.setText(detailsParse.supplier[0]);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailsActivity.this, "No Network Found", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new Hashtable<>();
                param.put(Key.MED_ID,id);
                return param;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
    }
}

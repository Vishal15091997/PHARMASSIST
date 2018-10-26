package com.example.pallabi.pharmiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public List<Medicine> mArrayList = new ArrayList<>();
    private DataAdapter mAdapter;
    Medicine version;
    RecyclerView.LayoutManager layoutManager;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getData();
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        mRecyclerView = findViewById(R.id.card_recycler_view);
        layoutManager = (new GridLayoutManager(this, 1));
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new DataAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(),new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View view = rv.findChildViewUnder(e.getX(), e.getY());
                if (view != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(view);
                    Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("ID", String.valueOf(mArrayList.get(position).getId()));
                    intent.putExtra(Key.MED_ID, String.valueOf(mArrayList.get(position).getId()));
                    startActivity(intent);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        final MenuItem item = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        search(searchView);
        return true;
    }

    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                //mRecyclerView.setAdapter(mAdapter);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuLogout) {
            editor.putString(Key.EMAIL,"");
            editor.commit();
            startActivity(new Intent(this,LoginActivity.class));
            this.finish();
        }
        return true;
    }

    private void getData() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Url.BASE_URL,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        version = new Medicine(jsonObject.getString("ID"),jsonObject.getString("Name"), jsonObject.getString("Price"), jsonObject.getString("Quantity"));
                        mArrayList.add(version);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "no network found", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(jsonArrayRequest);
    }
}

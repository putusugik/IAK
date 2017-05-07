package sugialmantara.iak;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sugialmantara.iak.Adapter.AdapterForecast;
import sugialmantara.iak.Model.DummyForecast;

public class MainActivity extends AppCompatActivity {

    private AdapterForecast adapter;
    private List<DummyForecast> list = new ArrayList<>();
    @BindView(R.id.rv_forecast)RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        setupRV();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupRV(){
        adapter = new AdapterForecast(list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        popuData();
    }

    private void  popuData(){
        for (int i  = 0; i < 10; i++){
            DummyForecast dummy = new DummyForecast("Sunday", "Rainy", 20, 23, 123);
            list.add(dummy);
        }
        adapter.notifyDataSetChanged();
        getDataWeather();
    }

    public void getDataWeather(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=-8.689513&lon=115.237762&cnt=16&appid=2141b349862ae4b0177ad8c1c3a6d5ab&units=metric";

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Sukses", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error!=null){
                            Log.d("Resp: ",error.toString());
                        } else {
                            Log.d("NULL: ", error.toString());
                        }
                    }
                }
        );
        requestQueue.add(stringRequest);
    }
}

package sugialmantara.iak;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
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
import com.google.gson.Gson;
import com.google.gson.internal.Excluder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sugialmantara.iak.Adapter.AdapterForecast;
import sugialmantara.iak.Adapter.OnClickListener;
import sugialmantara.iak.Database.ForecastDBHelper;
import sugialmantara.iak.Model.DailyForecast;
import sugialmantara.iak.Model.DummyForecast;
import sugialmantara.iak.Model.WeatherItem;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private AdapterForecast adapter;
    private Gson gson = new Gson();
    private List<WeatherItem> list = new ArrayList<>();
    private ForecastDBHelper dbHelper;
    private static final String cityTarget = "Madrid";
    private DailyForecast dailyForecast;

    @BindView(R.id.rv_forecast)RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setElevation(0);
        ButterKnife.bind(this);

        dbHelper = new ForecastDBHelper(this);

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
        getDataWeather();
    }

    public void getDataWeather(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url = "http://api.openweathermap.org/data/2.5/forecast/daily?cnt=" +
                "16&appid=2141b349862ae4b0177ad8c1c3a6d5ab&units=metric&q="+cityTarget;

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Sukses", response);
                        try{
                            DailyForecast dailyForecast = gson.fromJson(response, DailyForecast.class);
                            Log.d("Daily: ", dailyForecast.toString());
                            for (WeatherItem item : dailyForecast.getList()){
                                list.add(item);
                            }
                            adapter.notifyDataSetChanged();
                            adapter.setClickListener(MainActivity.this);
                            saveForecastDB(dailyForecast);

                        }  catch (Exception e){
                            Log.e("Daily: ", e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (dbHelper.isDataAlreadyExist(cityTarget)){
                            dailyForecast = dbHelper.getSavedForecast(cityTarget);
                            showDataFromDB(dailyForecast);
                        } else {
                            if (error != null){
                                Log.e("Error: ", error.getMessage());
                            } else {
                                Log.d("NULL: ", error.toString());
                            }

                        }
                    }
                }
        );
        requestQueue.add(stringRequest);
    }

    private void showDataFromDB(DailyForecast dailyForecast) {
        list.clear();
        for (WeatherItem item : dailyForecast.getList()){
            list.add(item);
        }
        adapter.notifyDataSetChanged();
        adapter.setClickListener(this);
    }

    private void saveForecastDB(DailyForecast data) {
        if (dbHelper.isDataAlreadyExist(cityTarget)){
            dbHelper.deleteForUpdate(cityTarget);
        }

        for (WeatherItem item : data.getList()){
            dbHelper.saveForecast(data.getCity(), item);
        }
    }

    @Override
    public void onItemClick (WeatherItem data, int pos) {
        Intent det = new Intent(MainActivity.this, DetailActivity.class);
        det.putExtra("data", gson.toJson(data));
        det.putExtra("position", pos);
        startActivity(det);

    }
}

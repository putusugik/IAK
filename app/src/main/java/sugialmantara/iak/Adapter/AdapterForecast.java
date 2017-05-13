package sugialmantara.iak.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sugialmantara.iak.Model.DummyForecast;
import sugialmantara.iak.Model.WeatherItem;
import sugialmantara.iak.R;

/**
 * Created by Sugik on 5/7/2017.
 */

public class AdapterForecast extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<WeatherItem> listDummy = new ArrayList<>();



    public AdapterForecast(List<WeatherItem> listDummy) {
        this.listDummy = listDummy;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForecastItemVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ForecastItemVH)holder).bind(listDummy.get(position));

    }

    @Override
    public int getItemCount() {
        return listDummy.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);


    }
}

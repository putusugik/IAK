package sugialmantara.iak.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
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

    private OnClickListener onClickListener;
    private List<WeatherItem> listDummy = new ArrayList<>();
    private static final int  VIEW_TODAY = 0;
    private static final int VIEW_OTHER = 1;


    public AdapterForecast(List<WeatherItem> listDummy) {
        this.listDummy = listDummy;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TODAY){
            return new BarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bar_main, parent, false));
        } else {
            return new ForecastItemVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int type = getItemViewType(position);
        if (type == VIEW_TODAY){
            ((BarViewHolder) holder).bind(listDummy.get(position), onClickListener);
        }else {
            ((ForecastItemVH)holder).bind(listDummy.get(position), position ,onClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return listDummy.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return VIEW_TODAY;
        }else {
            return VIEW_OTHER;
        }
    }

    public void setClickListener (OnClickListener clickListener){
        this.onClickListener = clickListener;
    }
}

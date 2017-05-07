package sugialmantara.iak.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sugialmantara.iak.Model.DummyForecast;
import sugialmantara.iak.R;

/**
 * Created by Sugik on 5/7/2017.
 */

public class ForecastItemVH extends RecyclerView.ViewHolder {

    @BindView(R.id.imgWea)ImageView img;
    @BindView(R.id.e_cuaca)TextView tCuaca;
    @BindView(R.id.e_hari)TextView tHari;
    @BindView(R.id.e_maxSuhu)TextView tMaxSuhu;
    @BindView(R.id.e_minSuhu)TextView tMinSuhu;

    public ForecastItemVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(DummyForecast data){
        tHari.setText(data.getDay());
        tCuaca.setText(data.getWeather());
        tMaxSuhu.setText(String.valueOf(data.getMaxTem())+"\u00b0");
        tMinSuhu.setText(String.valueOf(data.getMinTem())+"\u00b0");
    }

}

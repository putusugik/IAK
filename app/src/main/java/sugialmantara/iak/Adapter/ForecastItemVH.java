package sugialmantara.iak.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sugialmantara.iak.Model.DummyForecast;
import sugialmantara.iak.Model.WeatherItem;
import sugialmantara.iak.R;
import sugialmantara.iak.Utils.SunshineIconUtils;

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

    public void bind(final WeatherItem data, int position ,final OnClickListener clickListener){
        img.setImageResource(SunshineIconUtils.
                getSmallArtResourceIdForWeatherCondition(data.getWeather().get(0).getId()));
        tHari.setText(data.getReadTime(position));
        tCuaca.setText(data.getWeather().get(0).getMain());
        tMaxSuhu.setText(data.getTemp().getResolveTemp(data.getTemp().getMax()));
        tMinSuhu.setText(data.getTemp().getResolveTemp(data.getTemp().getMin()));
        /*tMaxSuhu.setText(String.valueOf(data.getMaxTem())+"\u00b0");
        tMinSuhu.setText(String.valueOf(data.getMinTem())+"\u00b0");*/

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(data, 0);
            }
        });
    }



}

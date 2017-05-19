package sugialmantara.iak.Adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sugialmantara.iak.Model.WeatherItem;
import sugialmantara.iak.R;
import sugialmantara.iak.Utils.SunshineIconUtils;

/**
 * Created by Sugik on 5/13/2017.
 */

public class BarViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.icon)ImageView img;
    @BindView(R.id.deskripsi)TextView deskrip;
    @BindView(R.id.maxsuhu)TextView mxSuhu;
    @BindView(R.id.minsuhu)TextView mnSuhu;
    @BindView(R.id.today)TextView tday;

    public BarViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final WeatherItem data, final OnClickListener clickListener){
        img.setImageResource(SunshineIconUtils.
                getSmallArtResourceIdForWeatherCondition(data.getWeather().get(0).getId()));
        mxSuhu.setText(data.getTemp().getResolveTemp(data.getTemp().getMax()));
        mnSuhu.setText(data.getTemp().getResolveTemp(data.getTemp().getMin()));
        deskrip.setText(data.getWeather().get(0).getDescription());
        tday.setText(data.getTodayReadTime());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(data, 0);
            }
        });
    }


}

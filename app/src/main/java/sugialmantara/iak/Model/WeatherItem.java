package sugialmantara.iak.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Sugik on 5/13/2017.
 */

public class WeatherItem {
    private long dt;
    private Temp temp;
    private List<Weather> weather;

    @Override
    public String toString() {
        return "WeatherItem{" +
                "dt=" + dt +
                ", temp=" + temp +
                ", weather=" + weather +
                '}';
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getReadTime(){
        Date date = new Date(dt*1000L);
        DateFormat format = new SimpleDateFormat("EEEE");
        return format.format(date);
    }
}

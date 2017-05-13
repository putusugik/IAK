package sugialmantara.iak.Model;

import java.util.List;

/**
 * Created by Sugik on 5/13/2017.
 */

public class DailyForecast {
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<WeatherItem> getList() {
        return list;
    }

    public void setList(List<WeatherItem> list) {
        this.list = list;
    }

    private List<WeatherItem> list;

    @Override
    public String toString() {
        return "DailyForecast{" +
                "city=" + city +
                ", list=" + list +
                '}';
    }
}

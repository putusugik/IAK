package sugialmantara.iak.Model;

/**
 * Created by Sugik on 5/7/2017.
 */

public class DummyForecast {

    private String day, weather;
    private int maxTem, minTem;
    private int weatherID;

    public DummyForecast(String day, String weather, int maxTem, int minTem, int weatherID) {
        this.day = day;
        this.weather = weather;
        this.maxTem = maxTem;
        this.minTem = minTem;
        this.weatherID = weatherID;
    }

    @Override
    public String toString() {
        return "DummyForecast{" +
                "day='" + day + '\'' +
                ", weather='" + weather + '\'' +
                ", maxTem=" + maxTem +
                ", minTem=" + minTem +
                ", weatherID=" + weatherID +
                '}';
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getMaxTem() {
        return maxTem;
    }

    public void setMaxTem(int maxTem) {
        this.maxTem = maxTem;
    }

    public int getMinTem() {
        return minTem;
    }

    public void setMinTem(int minTem) {
        this.minTem = minTem;
    }

    public int getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
    }
}

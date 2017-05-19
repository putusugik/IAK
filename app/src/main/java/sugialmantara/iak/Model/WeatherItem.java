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
    private int humidity;
    private double pressure, speed;

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

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

    public String getReadTime(int position){
        if (position == 0){
            return "Tomorrow";
        } else {
            Date date = new Date(dt*1000L);
            DateFormat format = new SimpleDateFormat("EEEE");
            return format.format(date);
        }
    }

    public String getTodayReadTime(){
        Date date = new Date(dt*1000L);
        DateFormat format = new SimpleDateFormat("MMM dd");
        return "Today, "+format.format(date);
    }

    public String getReadHumidity(){
        return humidity + " %";
    }

    public String getReadPressure(){
        return Math.round(pressure) + " hPa";
    }

    public String getReadSpeed(){
        return Math.round(speed) + " m/sec";
    }


}

package sugialmantara.iak.Model;

/**
 * Created by Sugik on 5/13/2017.
 */

public class Temp {
    private Double min, max;

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }

    public String getResolveTemp (double temp){
        int hasil = (int)temp;
        return hasil+"\u00b0";
    }
}

package sugialmantara.iak.Model;

/**
 * Created by Sugik on 5/13/2017.
 */

public class Weather {
    private int id;
    private String main, description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +

                ", description='" + description + '\'' +
                '}';
    }
}

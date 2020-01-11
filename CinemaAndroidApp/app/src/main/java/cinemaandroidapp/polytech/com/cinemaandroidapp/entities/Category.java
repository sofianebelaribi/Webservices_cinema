package cinemaandroidapp.polytech.com.cinemaandroidapp.entities;

import java.io.Serializable;

/**
 * Created by franck on 23/01/18.
 */

public class Category implements Serializable{

    private int id;
    private String name;

    public Category(int id) {

        //TODO affect name according to id
        this.id = id;
        this.name = "Action";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name=" + name +
                '}';
    }
}

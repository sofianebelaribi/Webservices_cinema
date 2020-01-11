package cinemaandroidapp.polytech.com.cinemaandroidapp.entities;

import java.io.Serializable;

/**
 * Created by franck on 26/01/18.
 */

public class Director implements Serializable {

    private int id;
    private String name;
    private String surname;

    public Director(int id) {
        this.id = id;
        if(id == 1){
            this.name = "Oury";
            this.surname = "Gerard";
        }
        if(id == 2){
            this.name = "Chabrol";
            this.surname = "Claude";
        }
        if(id == 3){
            this.name = "Besson";
            this.surname = "Luc";
        }
        if(id == 4){
            this.name = "Besnard";
            this.surname = "Eric";
        }
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

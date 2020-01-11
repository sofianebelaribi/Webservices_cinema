package cinemaandroidapp.polytech.com.cinemaandroidapp.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by franck on 23/01/18.
 */

public class Movie implements Serializable{

    private int id;
    private String title;
    private int length;
    private Date releaseDate;
    private int budget;
    private int benefits;
    private Category cat;
    private Director dir;

    public Movie(int id, String title, int length, Date releaseDate, int budget, int benefits, Category cat, Director dir) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.benefits = benefits;
        this.cat = cat;
        this.dir = dir;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setlength(int length) {
        this.length = length;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBenefits() {
        return benefits;
    }

    public void setBenefits(int benefits) {
        this.benefits = benefits;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Director getDir() {
        return dir;
    }

    public void setDir(Director dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", releaseDate=" + releaseDate +
                ", budget=" + budget +
                ", benefits=" + benefits +
                ", cat=" + cat +
                '}';
    }
}

package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Quentin on 26/10/2017.
 */
@Entity
public class Film {
    private int noFilm;
    private String titre;
    private int duree;
    private Date dateSortie;
    private int budget;
    private int montantRecette;
    private int noRea;
    private Categorie categorieByCodeCat;

    @Id
    @Column(name = "NoFilm")
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Basic
    @Column(name = "Titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "Duree")
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "DateSortie")
    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Basic
    @Column(name = "Budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "MontantRecette")
    public int getMontantRecette() {
        return montantRecette;
    }

    public void setMontantRecette(int montantRecette) {
        this.montantRecette = montantRecette;
    }

    @Basic
    @Column(name = "NoRea")
    public int getNoRea() {
        return noRea;
    }

    public void setNoRea(int noRea) {
        this.noRea = noRea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (noFilm != film.noFilm) return false;
        if (duree != film.duree) return false;
        if (budget != film.budget) return false;
        if (montantRecette != film.montantRecette) return false;
        if (titre != null ? !titre.equals(film.titre) : film.titre != null) return false;
        if (dateSortie != null ? !dateSortie.equals(film.dateSortie) : film.dateSortie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noFilm;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + duree;
        result = 31 * result + (dateSortie != null ? dateSortie.hashCode() : 0);
        result = 31 * result + budget;
        result = 31 * result + montantRecette;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CodeCat", referencedColumnName = "CodeCat", nullable = false)
    public Categorie getCategorieByCodeCat() {
        return categorieByCodeCat;
    }

    public void setCategorieByCodeCat(Categorie categorieByCodeCat) {
        this.categorieByCodeCat = categorieByCodeCat;
    }
}

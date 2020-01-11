package model;

import javax.persistence.*;

/**
 * Created by Quentin on 26/10/2017.
 */
@Entity
@IdClass(PersonnagePK.class)
public class Personnage {
    private int noFilm;
    private int noAct;
    private String nomPers;
    private Film filmByNoFilm;
    private Acteur acteurByNoAct;

    @Id
    @Column(name = "NoFilm")
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Id
    @Column(name = "NoAct")
    public int getNoAct() {
        return noAct;
    }

    public void setNoAct(int noAct) {
        this.noAct = noAct;
    }

    @Basic
    @Column(name = "NomPers")
    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personnage that = (Personnage) o;

        if (noFilm != that.noFilm) return false;
        if (noAct != that.noAct) return false;
        if (nomPers != null ? !nomPers.equals(that.nomPers) : that.nomPers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noFilm;
        result = 31 * result + noAct;
        result = 31 * result + (nomPers != null ? nomPers.hashCode() : 0);
        return result;
    }

//    @ManyToOne
//    @JoinColumn(name = "NoFilm", referencedColumnName = "NoFilm", nullable = false)
//    public Film getFilmByNoFilm() {
//        return filmByNoFilm;
//    }
//
//    public void setFilmByNoFilm(Film filmByNoFilm) {
//        this.filmByNoFilm = filmByNoFilm;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "NoAct", referencedColumnName = "NoAct", nullable = false)
//    public Acteur getActeurByNoAct() {
//        return acteurByNoAct;
//    }

    public void setActeurByNoAct(Acteur acteurByNoAct) {
        this.acteurByNoAct = acteurByNoAct;
    }
}

package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by Quentin on 26/10/2017.
 */
@Entity
public class Categorie {
    private String codeCat;
    private String libelleCat;
    private String image;

    @Id

    @Column(name = "CodeCat")
    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    @Basic
    @Column(name = "LibelleCat")
    public String getLibelleCat() {
        return libelleCat;
    }

    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(codeCat, categorie.codeCat) &&
                Objects.equals(libelleCat, categorie.libelleCat) &&
                Objects.equals(image, categorie.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeCat, libelleCat, image);
    }
}

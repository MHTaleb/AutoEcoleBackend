/**
 * This file was generated by the Jeddict
 */
package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.xml.bind.annotation.*;

/**
 * @author Taleb Mohammed Housseyn
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NamedQueries({
    @NamedQuery(name = "UserInfo.findAll", query = "Select e from UserInfo e")
    ,@NamedQuery(name = "UserInfo.findByDateNaissance", query = "Select e from UserInfo e where e.dateNaissance = :dateNaisance ")
    ,@NamedQuery(name = "UserInfo.findByFullNAme", query = "Select e from UserInfo e WHERE e.nom = :nom AND e.prenom = :prenom")
    ,@NamedQuery(name = "UserInfo.findByPhone", query = "Select e from UserInfo e WHERE e.telephones = :telephone")})
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    private String nom;

    @Basic(optional = false)
    private String prenom;

    @Basic(optional = false)
    private LocalDate dateNaissance;

    @ElementCollection
    @OrderBy("")
    private List<String> telephones;

    @OneToOne(optional = false, targetEntity = Image.class)
    private Image image;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<String> getTelephones() {
        return this.telephones;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!java.util.Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final UserInfo other = (UserInfo) obj;
        if (!java.util.Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "UserInfo{" + " nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", telephones=" + telephones + ", image=" + image + '}';
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.domain.models;

import cu.edu.unah.Proyectov1.model.Especieanimal;
import cu.edu.unah.Proyectov1.model.RazaPK;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "raza", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Raza.findAll", query = "SELECT r FROM Raza r"),
    @NamedQuery(name = "Raza.findByIdRaza", query = "SELECT r FROM Raza r WHERE r.razaPK.idRaza = :idRaza"),
    @NamedQuery(name = "Raza.findByNombreRaza", query = "SELECT r FROM Raza r WHERE r.nombreRaza = :nombreRaza"),
    @NamedQuery(name = "Raza.findByClasificionAlimentaria", query = "SELECT r FROM Raza r WHERE r.clasificionAlimentaria = :clasificionAlimentaria"),
    @NamedQuery(name = "Raza.findByEspecieanimalidEspecieAnimal", query = "SELECT r FROM Raza r WHERE r.razaPK.especieanimalidEspecieAnimal = :especieanimalidEspecieAnimal"),
    @NamedQuery(name = "Raza.findByEspecieanimalgrupoanimalidGrupoAnimal", query = "SELECT r FROM Raza r WHERE r.razaPK.especieanimalgrupoanimalidGrupoAnimal = :especieanimalgrupoanimalidGrupoAnimal")})
public class Raza implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected cu.edu.unah.Proyectov1.model.RazaPK razaPK;
    @Basic(optional = false)
    @Column(name = "nombre_raza")
    private String nombreRaza;
    @Basic(optional = false)
    @Column(name = "clasificion_alimentaria")
    private String clasificionAlimentaria;
    
   
    @JoinColumns({
        @JoinColumn(name = "especieanimalid_especie_animal", referencedColumnName = "id_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "especieanimalgrupoanimalid_grupo_animal", referencedColumnName = "grupoanimalid_grupo_animal", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private cu.edu.unah.Proyectov1.model.Especieanimal especieanimal;
   
    public Raza() {
    }

    public Raza(cu.edu.unah.Proyectov1.model.RazaPK razaPK) {
        this.razaPK = razaPK;
    }

    public Raza(cu.edu.unah.Proyectov1.model.RazaPK razaPK, String nombreRaza, String clasificionAlimentaria) {
        this.razaPK = razaPK;
        this.nombreRaza = nombreRaza;
        this.clasificionAlimentaria = clasificionAlimentaria;
    }

    public Raza(int idRaza, int especieanimalidEspecieAnimal, int especieanimalgrupoanimalidGrupoAnimal) {
        this.razaPK = new cu.edu.unah.Proyectov1.model.RazaPK(idRaza, especieanimalidEspecieAnimal, especieanimalgrupoanimalidGrupoAnimal);
    }

    public cu.edu.unah.Proyectov1.model.RazaPK getRazaPK() {
        return razaPK;
    }

    public void setRazaPK(RazaPK razaPK) {
        this.razaPK = razaPK;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public String getClasificionAlimentaria() {
        return clasificionAlimentaria;
    }

    public void setClasificionAlimentaria(String clasificionAlimentaria) {
        this.clasificionAlimentaria = clasificionAlimentaria;
    }

    

    public cu.edu.unah.Proyectov1.model.Especieanimal getEspecieanimal() {
        return especieanimal;
    }

    public void setEspecieanimal(Especieanimal especieanimal) {
        this.especieanimal = especieanimal;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (razaPK != null ? razaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Raza)) {
            return false;
        }
        Raza other = (Raza) object;
        if ((this.razaPK == null && other.razaPK != null) || (this.razaPK != null && !this.razaPK.equals(other.razaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Raza[ razaPK=" + razaPK + " ]";
    }
    
}

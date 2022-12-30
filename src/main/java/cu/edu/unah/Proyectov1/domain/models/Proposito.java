/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.domain.models;

import cu.edu.unah.Proyectov1.model.Raza;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "proposito", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proposito.findAll", query = "SELECT p FROM Proposito p"),
    @NamedQuery(name = "Proposito.findByIdProposito", query = "SELECT p FROM Proposito p WHERE p.idProposito = :idProposito"),
    @NamedQuery(name = "Proposito.findByTipoProposito", query = "SELECT p FROM Proposito p WHERE p.tipoProposito = :tipoProposito")})
public class Proposito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proposito")
    private Integer idProposito;
    @Basic(optional = false)
    @Column(name = "tipo_proposito")
    private String tipoProposito;
    @JoinTable(name = "raza_proposito", joinColumns = {
        @JoinColumn(name = "propositoid_proposito", referencedColumnName = "id_proposito")}, inverseJoinColumns = {
        @JoinColumn(name = "razaid_raza", referencedColumnName = "id_raza"),
        @JoinColumn(name = "razaespecieanimalid_especie_animal", referencedColumnName = "especieanimalid_especie_animal"),
        @JoinColumn(name = "razaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "especieanimalgrupoanimalid_grupo_animal")})
    @ManyToMany
    private List<Raza> razaList;

    public Proposito() {
    }

    public Proposito(Integer idProposito) {
        this.idProposito = idProposito;
    }

    public Proposito(Integer idProposito, String tipoProposito) {
        this.idProposito = idProposito;
        this.tipoProposito = tipoProposito;
    }

    public Integer getIdProposito() {
        return idProposito;
    }

    public void setIdProposito(Integer idProposito) {
        this.idProposito = idProposito;
    }

    public String getTipoProposito() {
        return tipoProposito;
    }

    public void setTipoProposito(String tipoProposito) {
        this.tipoProposito = tipoProposito;
    }

    @XmlTransient
    public List<Raza> getRazaList() {
        return razaList;
    }

    public void setRazaList(List<Raza> razaList) {
        this.razaList = razaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProposito != null ? idProposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proposito)) {
            return false;
        }
        Proposito other = (Proposito) object;
        if ((this.idProposito == null && other.idProposito != null) || (this.idProposito != null && !this.idProposito.equals(other.idProposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Proposito[ idProposito=" + idProposito + " ]";
    }
    
}

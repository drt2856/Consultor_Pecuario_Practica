/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "obreros", catalog = "Proyect_BD", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obreros.findAll", query = "SELECT o FROM Obreros o"),
    @NamedQuery(name = "Obreros.findByIdObrero", query = "SELECT o FROM Obreros o WHERE o.idObrero = :idObrero"),
    @NamedQuery(name = "Obreros.findByNombreYApellidos", query = "SELECT o FROM Obreros o WHERE o.nombreYApellidos = :nombreYApellidos"),
    @NamedQuery(name = "Obreros.findByFechaDeNacimiento", query = "SELECT o FROM Obreros o WHERE o.fechaDeNacimiento = :fechaDeNacimiento")})
public class Obreros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_obrero")
    private Integer idObrero;
    @Basic(optional = false)
    @Column(name = "nombre_y_apellidos")
    private String nombreYApellidos;
    @Basic(optional = false)
    @Column(name = "fecha_de_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    @JoinColumn(name = "areaid_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private Area areaidArea;

    public Obreros() {
    }

    public Obreros(Integer idObrero) {
        this.idObrero = idObrero;
    }

    public Obreros(Integer idObrero, String nombreYApellidos, Date fechaDeNacimiento) {
        this.idObrero = idObrero;
        this.nombreYApellidos = nombreYApellidos;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getIdObrero() {
        return idObrero;
    }

    public void setIdObrero(Integer idObrero) {
        this.idObrero = idObrero;
    }

    public String getNombreYApellidos() {
        return nombreYApellidos;
    }

    public void setNombreYApellidos(String nombreYApellidos) {
        this.nombreYApellidos = nombreYApellidos;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Area getAreaidArea() {
        return areaidArea;
    }

    public void setAreaidArea(Area areaidArea) {
        this.areaidArea = areaidArea;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObrero != null ? idObrero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obreros)) {
            return false;
        }
        Obreros other = (Obreros) object;
        if ((this.idObrero == null && other.idObrero != null) || (this.idObrero != null && !this.idObrero.equals(other.idObrero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pr.Obreros[ idObrero=" + idObrero + " ]";
    }
    
}

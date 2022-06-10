/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "prevencion", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prevencion.findAll", query = "SELECT p FROM Prevencion p"),
    @NamedQuery(name = "Prevencion.findByIdPrevencion", query = "SELECT p FROM Prevencion p WHERE p.idPrevencion = :idPrevencion"),
    @NamedQuery(name = "Prevencion.findByTratamientoPreventivos", query = "SELECT p FROM Prevencion p WHERE p.tratamientoPreventivos = :tratamientoPreventivos")})
public class Prevencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prevencion")
    private Integer idPrevencion;
    @Basic(optional = false)
    @Column(name = "tratamiento_preventivos")
    private String tratamientoPreventivos;
    @ManyToMany(mappedBy = "prevencionList")
    private List<Enfermedades> enfermedadesList;
    @ManyToMany(mappedBy = "prevencionList")
    private List<ConsejosPreventivos> consejosPreventivosList;

    public Prevencion() {
    }

    public Prevencion(Integer idPrevencion) {
        this.idPrevencion = idPrevencion;
    }

    public Prevencion(Integer idPrevencion, String tratamientoPreventivos) {
        this.idPrevencion = idPrevencion;
        this.tratamientoPreventivos = tratamientoPreventivos;
    }

    public Integer getIdPrevencion() {
        return idPrevencion;
    }

    public void setIdPrevencion(Integer idPrevencion) {
        this.idPrevencion = idPrevencion;
    }

    public String getTratamientoPreventivos() {
        return tratamientoPreventivos;
    }

    public void setTratamientoPreventivos(String tratamientoPreventivos) {
        this.tratamientoPreventivos = tratamientoPreventivos;
    }

    @XmlTransient
    public List<Enfermedades> getEnfermedadesList() {
        return enfermedadesList;
    }

    public void setEnfermedadesList(List<Enfermedades> enfermedadesList) {
        this.enfermedadesList = enfermedadesList;
    }

    @XmlTransient
    public List<ConsejosPreventivos> getConsejosPreventivosList() {
        return consejosPreventivosList;
    }

    public void setConsejosPreventivosList(List<ConsejosPreventivos> consejosPreventivosList) {
        this.consejosPreventivosList = consejosPreventivosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrevencion != null ? idPrevencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prevencion)) {
            return false;
        }
        Prevencion other = (Prevencion) object;
        if ((this.idPrevencion == null && other.idPrevencion != null) || (this.idPrevencion != null && !this.idPrevencion.equals(other.idPrevencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Prevencion[ idPrevencion=" + idPrevencion + " ]";
    }
    
}

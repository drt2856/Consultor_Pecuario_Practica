/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "tratamientos", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamientos.findAll", query = "SELECT t FROM Tratamientos t"),
    @NamedQuery(name = "Tratamientos.findByIdTratamiento", query = "SELECT t FROM Tratamientos t WHERE t.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "Tratamientos.findByDescripcionTraatamiento", query = "SELECT t FROM Tratamientos t WHERE t.descripcionTraatamiento = :descripcionTraatamiento")})
public class Tratamientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tratamiento")
    private Integer idTratamiento;
    @Basic(optional = false)
    @Column(name = "descripcion_traatamiento")
    private String descripcionTraatamiento;
    @ManyToMany(mappedBy = "tratamientosList")
    private List<Enfermedades> enfermedadesList;
    @ManyToMany(mappedBy = "tratamientosList")
    private List<Medicamentos> medicamentosList;
  

    public Tratamientos() {
    }

    public Tratamientos(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Tratamientos(Integer idTratamiento, String descripcionTraatamiento) {
        this.idTratamiento = idTratamiento;
        this.descripcionTraatamiento = descripcionTraatamiento;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getDescripcionTraatamiento() {
        return descripcionTraatamiento;
    }

    public void setDescripcionTraatamiento(String descripcionTraatamiento) {
        this.descripcionTraatamiento = descripcionTraatamiento;
    }

    @XmlTransient
    public List<Enfermedades> getEnfermedadesList() {
        return enfermedadesList;
    }

    public void setEnfermedadesList(List<Enfermedades> enfermedadesList) {
        this.enfermedadesList = enfermedadesList;
    }

    @XmlTransient
    public List<Medicamentos> getMedicamentosList() {
        return medicamentosList;
    }

    public void setMedicamientosList(List<Medicamentos> medicamentosList) {
        this.medicamentosList = medicamentosList;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamientos)) {
            return false;
        }
        Tratamientos other = (Tratamientos) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Tratamientos[ idTratamiento=" + idTratamiento + " ]";
    }
    
}

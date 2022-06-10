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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "medicamentos", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m"),
    @NamedQuery(name = "Medicamentos.findByIdMedicamentos", query = "SELECT m FROM Medicamentos m WHERE m.idMedicamentos = :idMedicamentos"),
    @NamedQuery(name = "Medicamentos.findByNombreMedicamentos", query = "SELECT m FROM Medicamentos m WHERE m.nombreMedicamentos = :nombreMedicamentos"),
    @NamedQuery(name = "Medicamentos.findByFormaDePresentacion", query = "SELECT m FROM Medicamentos m WHERE m.formaDePresentacion = :formaDePresentacion")})
public class Medicamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medicamentos")
    private Integer idMedicamentos;
    @Basic(optional = false)
    @Column(name = "nombre_medicamentos")
    private String nombreMedicamentos;
    @Basic(optional = false)
    @Column(name = "forma_de_presentacion")
    private String formaDePresentacion;
    @JoinTable(name = "tratamientos_medicamentos", joinColumns = {
        @JoinColumn(name = "medicamentosid_medicamentos", referencedColumnName = "id_medicamentos")}, inverseJoinColumns = {
        @JoinColumn(name = "tratamientosid_tratamiento", referencedColumnName = "id_tratamiento")})
    @ManyToMany
    private List<Tratamientos> tratamientosList;
    

    public Medicamentos() {
    }

    public Medicamentos(Integer idMedicamentos) {
        this.idMedicamentos = idMedicamentos;
    }

    public Medicamentos(Integer idMedicamentos, String nombreMedicamentos, String formaDePresentacion) {
        this.idMedicamentos = idMedicamentos;
        this.nombreMedicamentos = nombreMedicamentos;
        this.formaDePresentacion = formaDePresentacion;
    }

    public Integer getIdMedicamentos() {
        return idMedicamentos;
    }

    public void setIdMedicamentos(Integer idMedicamentos) {
        this.idMedicamentos = idMedicamentos;
    }

    public String getNombreMedicamentos() {
        return nombreMedicamentos;
    }

    public void setNombreMedicamentos(String nombreMedicamentos) {
        this.nombreMedicamentos = nombreMedicamentos;
    }

    public String getFormaDePresentacion() {
        return formaDePresentacion;
    }

    public void setFormaDePresentacion(String formaDePresentacion) {
        this.formaDePresentacion = formaDePresentacion;
    }

    @XmlTransient
    public List<Tratamientos> getTratamientosList() {
        return tratamientosList;
    }

    public void setTratamientosList(List<Tratamientos> tratamientosList) {
        this.tratamientosList = tratamientosList;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamentos != null ? idMedicamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.idMedicamentos == null && other.idMedicamentos != null) || (this.idMedicamentos != null && !this.idMedicamentos.equals(other.idMedicamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Medicamentos[ idMedicamentos=" + idMedicamentos + " ]";
    }
    
}

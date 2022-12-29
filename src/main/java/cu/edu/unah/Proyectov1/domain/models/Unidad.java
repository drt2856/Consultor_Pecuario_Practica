/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.domain.models;

import cu.edu.unah.Proyectov1.model.Medicamentos;
import cu.edu.unah.Proyectov1.model.UnidadPK;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "unidad", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByIdUnidades", query = "SELECT u FROM Unidad u WHERE u.unidadPK.idUnidades = :idUnidades"),
    @NamedQuery(name = "Unidad.findByUnidades", query = "SELECT u FROM Unidad u WHERE u.unidades = :unidades"),
    @NamedQuery(name = "Unidad.findByMedicamentosidMedicamentos", query = "SELECT u FROM Unidad u WHERE u.unidadPK.medicamentosidMedicamentos = :medicamentosidMedicamentos")})
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected cu.edu.unah.Proyectov1.model.UnidadPK unidadPK;
    @Basic(optional = false)
    @Column(name = "unidades")
    private String unidades;
    @JoinColumn(name = "medicamentosid_medicamentos", referencedColumnName = "id_medicamentos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private cu.edu.unah.Proyectov1.model.Medicamentos medicamentos;

    public Unidad() {
    }

    public Unidad(cu.edu.unah.Proyectov1.model.UnidadPK unidadPK) {
        this.unidadPK = unidadPK;
    }

    public Unidad(cu.edu.unah.Proyectov1.model.UnidadPK unidadPK, String unidades) {
        this.unidadPK = unidadPK;
        this.unidades = unidades;
    }

    public Unidad(int idUnidades, int medicamientosidMedicamentos) {
        this.unidadPK = new cu.edu.unah.Proyectov1.model.UnidadPK(idUnidades, medicamientosidMedicamentos);
    }

    public cu.edu.unah.Proyectov1.model.UnidadPK getUnidadPK() {
        return unidadPK;
    }

    public void setUnidadPK(UnidadPK unidadPK) {
        this.unidadPK = unidadPK;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public cu.edu.unah.Proyectov1.model.Medicamentos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamientos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadPK != null ? unidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.unidadPK == null && other.unidadPK != null) || (this.unidadPK != null && !this.unidadPK.equals(other.unidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Unidad[ unidadPK=" + unidadPK + " ]";
    }
    
}

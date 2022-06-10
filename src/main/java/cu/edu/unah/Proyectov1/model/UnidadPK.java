/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class UnidadPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_unidades")
    private int idUnidades;
    @Basic(optional = false)
    @Column(name = "medicamentosid_medicamentos")
    private int medicamentosidMedicamentos;

    public UnidadPK() {
    }

    public UnidadPK(int idUnidades, int medicamentosidMedicamentos) {
        this.idUnidades = idUnidades;
        this.medicamentosidMedicamentos = medicamentosidMedicamentos;
    }

    public int getIdUnidades() {
        return idUnidades;
    }

    public void setIdUnidades(int idUnidades) {
        this.idUnidades = idUnidades;
    }

    public int getMedicamientosidMedicamentos() {
        return medicamentosidMedicamentos;
    }

    public void setMedicamentosidMedicamentos(int medicamentosidMedicamentos) {
        this.medicamentosidMedicamentos = medicamentosidMedicamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUnidades;
        hash += (int) medicamentosidMedicamentos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadPK)) {
            return false;
        }
        UnidadPK other = (UnidadPK) object;
        if (this.idUnidades != other.idUnidades) {
            return false;
        }
        if (this.medicamentosidMedicamentos != other.medicamentosidMedicamentos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.UnidadPK[ idUnidades=" + idUnidades + ", medicamentosidMedicamentos=" + medicamentosidMedicamentos + " ]";
    }
    
}

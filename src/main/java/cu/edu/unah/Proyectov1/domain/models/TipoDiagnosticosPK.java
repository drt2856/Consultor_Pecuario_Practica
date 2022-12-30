/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.domain.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashi
 */
@Embeddable
public class TipoDiagnosticosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "diagnosticoid_diagnostico")
    private int diagnosticoidDiagnostico;
    @Basic(optional = false)
    @Column(name = "diagnosticoenfermedadesid_enfermedades")
    private int diagnosticoenfermedadesidEnfermedades;
    @Basic(optional = false)
    @Column(name = "id_tipo_diagnosticos")
    private int idTipoDiagnosticos;

    public TipoDiagnosticosPK() {
    }

    public TipoDiagnosticosPK(int diagnosticoidDiagnostico, int diagnosticoenfermedadesidEnfermedades, int idTipoDiagnosticos) {
        this.diagnosticoidDiagnostico = diagnosticoidDiagnostico;
        this.diagnosticoenfermedadesidEnfermedades = diagnosticoenfermedadesidEnfermedades;
        this.idTipoDiagnosticos = idTipoDiagnosticos;
    }

    public int getDiagnosticoidDiagnostico() {
        return diagnosticoidDiagnostico;
    }

    public void setDiagnosticoidDiagnostico(int diagnosticoidDiagnostico) {
        this.diagnosticoidDiagnostico = diagnosticoidDiagnostico;
    }

    public int getDiagnosticoenfermedadesidEnfermedades() {
        return diagnosticoenfermedadesidEnfermedades;
    }

    public void setDiagnosticoenfermedadesidEnfermedades(int diagnosticoenfermedadesidEnfermedades) {
        this.diagnosticoenfermedadesidEnfermedades = diagnosticoenfermedadesidEnfermedades;
    }

    public int getIdTipoDiagnosticos() {
        return idTipoDiagnosticos;
    }

    public void setIdTipoDiagnosticos(int idTipoDiagnosticos) {
        this.idTipoDiagnosticos = idTipoDiagnosticos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) diagnosticoidDiagnostico;
        hash += (int) diagnosticoenfermedadesidEnfermedades;
        hash += (int) idTipoDiagnosticos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDiagnosticosPK)) {
            return false;
        }
        TipoDiagnosticosPK other = (TipoDiagnosticosPK) object;
        if (this.diagnosticoidDiagnostico != other.diagnosticoidDiagnostico) {
            return false;
        }
        if (this.diagnosticoenfermedadesidEnfermedades != other.diagnosticoenfermedadesidEnfermedades) {
            return false;
        }
        if (this.idTipoDiagnosticos != other.idTipoDiagnosticos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.TipoDiagnosticosPK[ diagnosticoidDiagnostico=" + diagnosticoidDiagnostico + ", diagnosticoenfermedadesidEnfermedades=" + diagnosticoenfermedadesidEnfermedades + ", idTipoDiagnosticos=" + idTipoDiagnosticos + " ]";
    }
    
}

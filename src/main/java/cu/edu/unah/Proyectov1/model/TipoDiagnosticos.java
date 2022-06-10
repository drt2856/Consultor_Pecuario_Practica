/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  cu.edu.unah.Proyectov1.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "tipo_diagnosticos", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDiagnosticos.findAll", query = "SELECT t FROM TipoDiagnosticos t"),
    @NamedQuery(name = "TipoDiagnosticos.findByDiagnosticoidDiagnostico", query = "SELECT t FROM TipoDiagnosticos t WHERE t.tipoDiagnosticosPK.diagnosticoidDiagnostico = :diagnosticoidDiagnostico"),
    @NamedQuery(name = "TipoDiagnosticos.findByDiagnosticoenfermedadesidEnfermedades", query = "SELECT t FROM TipoDiagnosticos t WHERE t.tipoDiagnosticosPK.diagnosticoenfermedadesidEnfermedades = :diagnosticoenfermedadesidEnfermedades"),
    @NamedQuery(name = "TipoDiagnosticos.findByIdTipoDiagnosticos", query = "SELECT t FROM TipoDiagnosticos t WHERE t.tipoDiagnosticosPK.idTipoDiagnosticos = :idTipoDiagnosticos"),
    @NamedQuery(name = "TipoDiagnosticos.findByNombreTipoDiagnosticos", query = "SELECT t FROM TipoDiagnosticos t WHERE t.nombreTipoDiagnosticos = :nombreTipoDiagnosticos")})
public class TipoDiagnosticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoDiagnosticosPK tipoDiagnosticosPK;
    @Basic(optional = false)
    @Column(name = "nombre_tipo_diagnosticos")
    private String nombreTipoDiagnosticos;
    @JoinColumns({
        @JoinColumn(name = "diagnosticoid_diagnostico", referencedColumnName = "id_diagnostico", insertable = false, updatable = false),
        @JoinColumn(name = "diagnosticoenfermedadesid_enfermedades", referencedColumnName = "enfermedadesid_enfermedades", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Diagnostico diagnostico;

    public TipoDiagnosticos() {
    }

    public TipoDiagnosticos(TipoDiagnosticosPK tipoDiagnosticosPK) {
        this.tipoDiagnosticosPK = tipoDiagnosticosPK;
    }

    public TipoDiagnosticos(TipoDiagnosticosPK tipoDiagnosticosPK, String nombreTipoDiagnosticos) {
        this.tipoDiagnosticosPK = tipoDiagnosticosPK;
        this.nombreTipoDiagnosticos = nombreTipoDiagnosticos;
    }

    public TipoDiagnosticos(int diagnosticoidDiagnostico, int diagnosticoenfermedadesidEnfermedades, int idTipoDiagnosticos) {
        this.tipoDiagnosticosPK = new TipoDiagnosticosPK(diagnosticoidDiagnostico, diagnosticoenfermedadesidEnfermedades, idTipoDiagnosticos);
    }

    public TipoDiagnosticosPK getTipoDiagnosticosPK() {
        return tipoDiagnosticosPK;
    }

    public void setTipoDiagnosticosPK(TipoDiagnosticosPK tipoDiagnosticosPK) {
        this.tipoDiagnosticosPK = tipoDiagnosticosPK;
    }

    public String getNombreTipoDiagnosticos() {
        return nombreTipoDiagnosticos;
    }

    public void setNombreTipoDiagnosticos(String nombreTipoDiagnosticos) {
        this.nombreTipoDiagnosticos = nombreTipoDiagnosticos;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDiagnosticosPK != null ? tipoDiagnosticosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDiagnosticos)) {
            return false;
        }
        TipoDiagnosticos other = (TipoDiagnosticos) object;
        if ((this.tipoDiagnosticosPK == null && other.tipoDiagnosticosPK != null) || (this.tipoDiagnosticosPK != null && !this.tipoDiagnosticosPK.equals(other.tipoDiagnosticosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.TipoDiagnosticos[ tipoDiagnosticosPK=" + tipoDiagnosticosPK + " ]";
    }
    
}

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
@Table(name = "tratamientos_medicion_y_peso", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TratamientosMedicionYPeso.findAll", query = "SELECT t FROM TratamientosMedicionYPeso t"),
    @NamedQuery(name = "TratamientosMedicionYPeso.findByTratamientosidTratamiento", query = "SELECT t FROM TratamientosMedicionYPeso t WHERE t.tratamientosMedicionYPesoPK.tratamientosidTratamiento = :tratamientosidTratamiento"),
    @NamedQuery(name = "TratamientosMedicionYPeso.findByMedicionYPesoidMedicionYPeso", query = "SELECT t FROM TratamientosMedicionYPeso t WHERE t.tratamientosMedicionYPesoPK.medicionYPesoidMedicionYPeso = :medicionYPesoidMedicionYPeso"),
    @NamedQuery(name = "TratamientosMedicionYPeso.findByMedicionYPesoetapaCrianzarazaidRaza", query = "SELECT t FROM TratamientosMedicionYPeso t WHERE t.tratamientosMedicionYPesoPK.medicionYPesoetapaCrianzarazaidRaza = :medicionYPesoetapaCrianzarazaidRaza"),
    @NamedQuery(name = "TratamientosMedicionYPeso.findByMedicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal", query = "SELECT t FROM TratamientosMedicionYPeso t WHERE t.tratamientosMedicionYPesoPK.medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal = :medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "TratamientosMedicionYPeso.findByMedicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup", query = "SELECT t FROM TratamientosMedicionYPeso t WHERE t.tratamientosMedicionYPesoPK.medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup = :medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup"),
    @NamedQuery(name = "TratamientosMedicionYPeso.findByMedicionYPesoetapaCrianzaidEtapaCrianza", query = "SELECT t FROM TratamientosMedicionYPeso t WHERE t.tratamientosMedicionYPesoPK.medicionYPesoetapaCrianzaidEtapaCrianza = :medicionYPesoetapaCrianzaidEtapaCrianza"),
    @NamedQuery(name = "TratamientosMedicionYPeso.findByDosis", query = "SELECT t FROM TratamientosMedicionYPeso t WHERE t.dosis = :dosis")})
public class TratamientosMedicionYPeso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TratamientosMedicionYPesoPK tratamientosMedicionYPesoPK;
    @Basic(optional = false)
    @Column(name = "dosis")
    private float dosis;
    @JoinColumns({
        @JoinColumn(name = "medicion_y_pesoid_medicion_y_peso", referencedColumnName = "id_medicion_y_peso", insertable = false, updatable = false),
        @JoinColumn(name = "medicion_y_pesoetapa_crianzarazaid_raza", referencedColumnName = "etapa_crianzarazaid_raza", insertable = false, updatable = false),
        @JoinColumn(name = "medicion_y_pesoetapa_crianzarazaespecieanimalid_especie_animal", referencedColumnName = "etapa_crianzarazaespecieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "medicion_y_pesoetapa_crianzarazaespecieanimalgrupoanimalid_grup", referencedColumnName = "etapa_crianzarazaespecieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false),
        @JoinColumn(name = "medicion_y_pesoetapa_crianzaid_etapa_crianza", referencedColumnName = "etapa_crianzaid_etapa_crianza", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MedicionYPeso medicionYPeso;
    @JoinColumn(name = "tratamientosid_tratamiento", referencedColumnName = "id_tratamiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamientos tratamientos;

    public TratamientosMedicionYPeso() {
    }

    public TratamientosMedicionYPeso(TratamientosMedicionYPesoPK tratamientosMedicionYPesoPK) {
        this.tratamientosMedicionYPesoPK = tratamientosMedicionYPesoPK;
    }

    public TratamientosMedicionYPeso(TratamientosMedicionYPesoPK tratamientosMedicionYPesoPK, float dosis) {
        this.tratamientosMedicionYPesoPK = tratamientosMedicionYPesoPK;
        this.dosis = dosis;
    }

    public TratamientosMedicionYPeso(int tratamientosidTratamiento, int medicionYPesoidMedicionYPeso, int medicionYPesoetapaCrianzarazaidRaza, int medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal, int medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup, int medicionYPesoetapaCrianzaidEtapaCrianza) {
        this.tratamientosMedicionYPesoPK = new TratamientosMedicionYPesoPK(tratamientosidTratamiento, medicionYPesoidMedicionYPeso, medicionYPesoetapaCrianzarazaidRaza, medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal, medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup, medicionYPesoetapaCrianzaidEtapaCrianza);
    }

    public TratamientosMedicionYPesoPK getTratamientosMedicionYPesoPK() {
        return tratamientosMedicionYPesoPK;
    }

    public void setTratamientosMedicionYPesoPK(TratamientosMedicionYPesoPK tratamientosMedicionYPesoPK) {
        this.tratamientosMedicionYPesoPK = tratamientosMedicionYPesoPK;
    }

    public float getDosis() {
        return dosis;
    }

    public void setDosis(float dosis) {
        this.dosis = dosis;
    }

    public MedicionYPeso getMedicionYPeso() {
        return medicionYPeso;
    }

    public void setMedicionYPeso(MedicionYPeso medicionYPeso) {
        this.medicionYPeso = medicionYPeso;
    }

    public Tratamientos getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Tratamientos tratamientos) {
        this.tratamientos = tratamientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tratamientosMedicionYPesoPK != null ? tratamientosMedicionYPesoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TratamientosMedicionYPeso)) {
            return false;
        }
        TratamientosMedicionYPeso other = (TratamientosMedicionYPeso) object;
        if ((this.tratamientosMedicionYPesoPK == null && other.tratamientosMedicionYPesoPK != null) || (this.tratamientosMedicionYPesoPK != null && !this.tratamientosMedicionYPesoPK.equals(other.tratamientosMedicionYPesoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.TratamientosMedicionYPeso[ tratamientosMedicionYPesoPK=" + tratamientosMedicionYPesoPK + " ]";
    }
    
}

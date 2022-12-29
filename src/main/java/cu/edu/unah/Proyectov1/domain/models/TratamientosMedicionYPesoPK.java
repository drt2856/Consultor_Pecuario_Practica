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
public class TratamientosMedicionYPesoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "tratamientosid_tratamiento")
    private int tratamientosidTratamiento;
    @Basic(optional = false)
    @Column(name = "medicion_y_pesoid_medicion_y_peso")
    private int medicionYPesoidMedicionYPeso;
    @Basic(optional = false)
    @Column(name = "medicion_y_pesoetapa_crianzarazaid_raza")
    private int medicionYPesoetapaCrianzarazaidRaza;
    @Basic(optional = false)
    @Column(name = "medicion_y_pesoetapa_crianzarazaespecieanimalid_especie_animal")
    private int medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "medicion_y_pesoetapa_crianzarazaespecieanimalgrupoanimalid_grup")
    private int medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup;
    @Basic(optional = false)
    @Column(name = "medicion_y_pesoetapa_crianzaid_etapa_crianza")
    private int medicionYPesoetapaCrianzaidEtapaCrianza;

    public TratamientosMedicionYPesoPK() {
    }

    public TratamientosMedicionYPesoPK(int tratamientosidTratamiento, int medicionYPesoidMedicionYPeso, int medicionYPesoetapaCrianzarazaidRaza, int medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal, int medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup, int medicionYPesoetapaCrianzaidEtapaCrianza) {
        this.tratamientosidTratamiento = tratamientosidTratamiento;
        this.medicionYPesoidMedicionYPeso = medicionYPesoidMedicionYPeso;
        this.medicionYPesoetapaCrianzarazaidRaza = medicionYPesoetapaCrianzarazaidRaza;
        this.medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal = medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal;
        this.medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup = medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup;
        this.medicionYPesoetapaCrianzaidEtapaCrianza = medicionYPesoetapaCrianzaidEtapaCrianza;
    }

    public int getTratamientosidTratamiento() {
        return tratamientosidTratamiento;
    }

    public void setTratamientosidTratamiento(int tratamientosidTratamiento) {
        this.tratamientosidTratamiento = tratamientosidTratamiento;
    }

    public int getMedicionYPesoidMedicionYPeso() {
        return medicionYPesoidMedicionYPeso;
    }

    public void setMedicionYPesoidMedicionYPeso(int medicionYPesoidMedicionYPeso) {
        this.medicionYPesoidMedicionYPeso = medicionYPesoidMedicionYPeso;
    }

    public int getMedicionYPesoetapaCrianzarazaidRaza() {
        return medicionYPesoetapaCrianzarazaidRaza;
    }

    public void setMedicionYPesoetapaCrianzarazaidRaza(int medicionYPesoetapaCrianzarazaidRaza) {
        this.medicionYPesoetapaCrianzarazaidRaza = medicionYPesoetapaCrianzarazaidRaza;
    }

    public int getMedicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal() {
        return medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal;
    }

    public void setMedicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal(int medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal) {
        this.medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal = medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal;
    }

    public int getMedicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup() {
        return medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup;
    }

    public void setMedicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup(int medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup) {
        this.medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup = medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup;
    }

    public int getMedicionYPesoetapaCrianzaidEtapaCrianza() {
        return medicionYPesoetapaCrianzaidEtapaCrianza;
    }

    public void setMedicionYPesoetapaCrianzaidEtapaCrianza(int medicionYPesoetapaCrianzaidEtapaCrianza) {
        this.medicionYPesoetapaCrianzaidEtapaCrianza = medicionYPesoetapaCrianzaidEtapaCrianza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tratamientosidTratamiento;
        hash += (int) medicionYPesoidMedicionYPeso;
        hash += (int) medicionYPesoetapaCrianzarazaidRaza;
        hash += (int) medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal;
        hash += (int) medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup;
        hash += (int) medicionYPesoetapaCrianzaidEtapaCrianza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TratamientosMedicionYPesoPK)) {
            return false;
        }
        TratamientosMedicionYPesoPK other = (TratamientosMedicionYPesoPK) object;
        if (this.tratamientosidTratamiento != other.tratamientosidTratamiento) {
            return false;
        }
        if (this.medicionYPesoidMedicionYPeso != other.medicionYPesoidMedicionYPeso) {
            return false;
        }
        if (this.medicionYPesoetapaCrianzarazaidRaza != other.medicionYPesoetapaCrianzarazaidRaza) {
            return false;
        }
        if (this.medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal != other.medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal) {
            return false;
        }
        if (this.medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup != other.medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup) {
            return false;
        }
        if (this.medicionYPesoetapaCrianzaidEtapaCrianza != other.medicionYPesoetapaCrianzaidEtapaCrianza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.TratamientosMedicionYPesoPK[ tratamientosidTratamiento=" + tratamientosidTratamiento + ", medicionYPesoidMedicionYPeso=" + medicionYPesoidMedicionYPeso + ", medicionYPesoetapaCrianzarazaidRaza=" + medicionYPesoetapaCrianzarazaidRaza + ", medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal=" + medicionYPesoetapaCrianzarazaespecieanimalidEspecieAnimal + ", medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup=" + medicionYPesoetapaCrianzarazaespecieanimalgrupoanimalidGrup + ", medicionYPesoetapaCrianzaidEtapaCrianza=" + medicionYPesoetapaCrianzaidEtapaCrianza + " ]";
    }
    
}

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
public class PracticaDeCrianzaEtapaCrianzaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "practica_de_crianzaid_practica_crianza")
    private int practicaDeCrianzaidPracticaCrianza;
    @Basic(optional = false)
    @Column(name = "practica_de_crianzarazaid_raza")
    private int practicaDeCrianzarazaidRaza;
    @Basic(optional = false)
    @Column(name = "practica_de_crianzarazaespecieanimalid_especie_animal")
    private int practicaDeCrianzarazaespecieanimalidEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "practica_de_crianzarazaespecieanimalgrupoanimalid_grupo_animal")
    private int practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    @Basic(optional = false)
    @Column(name = "etapa_crianzarazaid_raza")
    private int etapaCrianzarazaidRaza;
    @Basic(optional = false)
    @Column(name = "etapa_crianzarazaespecieanimalid_especie_animal")
    private int etapaCrianzarazaespecieanimalidEspecieAnimal;
    @Basic(optional = false)
    @Column(name = "etapa_crianzarazaespecieanimalgrupoanimalid_grupo_animal")
    private int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    @Basic(optional = false)
    @Column(name = "etapa_crianzaid_etapa_crianza")
    private int etapaCrianzaidEtapaCrianza;

    public PracticaDeCrianzaEtapaCrianzaPK() {
    }

    public PracticaDeCrianzaEtapaCrianzaPK(int practicaDeCrianzaidPracticaCrianza, int practicaDeCrianzarazaidRaza, int practicaDeCrianzarazaespecieanimalidEspecieAnimal, int practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, int etapaCrianzarazaidRaza, int etapaCrianzarazaespecieanimalidEspecieAnimal, int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, int etapaCrianzaidEtapaCrianza) {
        this.practicaDeCrianzaidPracticaCrianza = practicaDeCrianzaidPracticaCrianza;
        this.practicaDeCrianzarazaidRaza = practicaDeCrianzarazaidRaza;
        this.practicaDeCrianzarazaespecieanimalidEspecieAnimal = practicaDeCrianzarazaespecieanimalidEspecieAnimal;
        this.practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
        this.etapaCrianzarazaidRaza = etapaCrianzarazaidRaza;
        this.etapaCrianzarazaespecieanimalidEspecieAnimal = etapaCrianzarazaespecieanimalidEspecieAnimal;
        this.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
        this.etapaCrianzaidEtapaCrianza = etapaCrianzaidEtapaCrianza;
    }

    public int getPracticaDeCrianzaidPracticaCrianza() {
        return practicaDeCrianzaidPracticaCrianza;
    }

    public void setPracticaDeCrianzaidPracticaCrianza(int practicaDeCrianzaidPracticaCrianza) {
        this.practicaDeCrianzaidPracticaCrianza = practicaDeCrianzaidPracticaCrianza;
    }

    public int getPracticaDeCrianzarazaidRaza() {
        return practicaDeCrianzarazaidRaza;
    }

    public void setPracticaDeCrianzarazaidRaza(int practicaDeCrianzarazaidRaza) {
        this.practicaDeCrianzarazaidRaza = practicaDeCrianzarazaidRaza;
    }

    public int getPracticaDeCrianzarazaespecieanimalidEspecieAnimal() {
        return practicaDeCrianzarazaespecieanimalidEspecieAnimal;
    }

    public void setPracticaDeCrianzarazaespecieanimalidEspecieAnimal(int practicaDeCrianzarazaespecieanimalidEspecieAnimal) {
        this.practicaDeCrianzarazaespecieanimalidEspecieAnimal = practicaDeCrianzarazaespecieanimalidEspecieAnimal;
    }

    public int getPracticaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal() {
        return practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    }

    public void setPracticaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal(int practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal) {
        this.practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    }

    public int getEtapaCrianzarazaidRaza() {
        return etapaCrianzarazaidRaza;
    }

    public void setEtapaCrianzarazaidRaza(int etapaCrianzarazaidRaza) {
        this.etapaCrianzarazaidRaza = etapaCrianzarazaidRaza;
    }

    public int getEtapaCrianzarazaespecieanimalidEspecieAnimal() {
        return etapaCrianzarazaespecieanimalidEspecieAnimal;
    }

    public void setEtapaCrianzarazaespecieanimalidEspecieAnimal(int etapaCrianzarazaespecieanimalidEspecieAnimal) {
        this.etapaCrianzarazaespecieanimalidEspecieAnimal = etapaCrianzarazaespecieanimalidEspecieAnimal;
    }

    public int getEtapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal() {
        return etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    }

    public void setEtapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal(int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal) {
        this.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
    }

    public int getEtapaCrianzaidEtapaCrianza() {
        return etapaCrianzaidEtapaCrianza;
    }

    public void setEtapaCrianzaidEtapaCrianza(int etapaCrianzaidEtapaCrianza) {
        this.etapaCrianzaidEtapaCrianza = etapaCrianzaidEtapaCrianza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) practicaDeCrianzaidPracticaCrianza;
        hash += (int) practicaDeCrianzarazaidRaza;
        hash += (int) practicaDeCrianzarazaespecieanimalidEspecieAnimal;
        hash += (int) practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
        hash += (int) etapaCrianzarazaidRaza;
        hash += (int) etapaCrianzarazaespecieanimalidEspecieAnimal;
        hash += (int) etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal;
        hash += (int) etapaCrianzaidEtapaCrianza;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PracticaDeCrianzaEtapaCrianzaPK)) {
            return false;
        }
        PracticaDeCrianzaEtapaCrianzaPK other = (PracticaDeCrianzaEtapaCrianzaPK) object;
        if (this.practicaDeCrianzaidPracticaCrianza != other.practicaDeCrianzaidPracticaCrianza) {
            return false;
        }
        if (this.practicaDeCrianzarazaidRaza != other.practicaDeCrianzarazaidRaza) {
            return false;
        }
        if (this.practicaDeCrianzarazaespecieanimalidEspecieAnimal != other.practicaDeCrianzarazaespecieanimalidEspecieAnimal) {
            return false;
        }
        if (this.practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal != other.practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal) {
            return false;
        }
        if (this.etapaCrianzarazaidRaza != other.etapaCrianzarazaidRaza) {
            return false;
        }
        if (this.etapaCrianzarazaespecieanimalidEspecieAnimal != other.etapaCrianzarazaespecieanimalidEspecieAnimal) {
            return false;
        }
        if (this.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal != other.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal) {
            return false;
        }
        if (this.etapaCrianzaidEtapaCrianza != other.etapaCrianzaidEtapaCrianza) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.PracticaDeCrianzaEtapaCrianzaPK[ practicaDeCrianzaidPracticaCrianza=" + practicaDeCrianzaidPracticaCrianza + ", practicaDeCrianzarazaidRaza=" + practicaDeCrianzarazaidRaza + ", practicaDeCrianzarazaespecieanimalidEspecieAnimal=" + practicaDeCrianzarazaespecieanimalidEspecieAnimal + ", practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal=" + practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal + ", etapaCrianzarazaidRaza=" + etapaCrianzarazaidRaza + ", etapaCrianzarazaespecieanimalidEspecieAnimal=" + etapaCrianzarazaespecieanimalidEspecieAnimal + ", etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal=" + etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal + ", etapaCrianzaidEtapaCrianza=" + etapaCrianzaidEtapaCrianza + " ]";
    }
    
}

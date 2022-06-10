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
@Table(name = "practica_de_crianza_etapa_crianza", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findAll", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByPracticaDeCrianzaidPracticaCrianza", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.practicaDeCrianzaEtapaCrianzaPK.practicaDeCrianzaidPracticaCrianza = :practicaDeCrianzaidPracticaCrianza"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByPracticaDeCrianzarazaidRaza", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.practicaDeCrianzaEtapaCrianzaPK.practicaDeCrianzarazaidRaza = :practicaDeCrianzarazaidRaza"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByPracticaDeCrianzarazaespecieanimalidEspecieAnimal", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.practicaDeCrianzaEtapaCrianzaPK.practicaDeCrianzarazaespecieanimalidEspecieAnimal = :practicaDeCrianzarazaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByPracticaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.practicaDeCrianzaEtapaCrianzaPK.practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = :practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByEtapaCrianzarazaidRaza", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.practicaDeCrianzaEtapaCrianzaPK.etapaCrianzarazaidRaza = :etapaCrianzarazaidRaza"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByEtapaCrianzarazaespecieanimalidEspecieAnimal", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.practicaDeCrianzaEtapaCrianzaPK.etapaCrianzarazaespecieanimalidEspecieAnimal = :etapaCrianzarazaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByEtapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.practicaDeCrianzaEtapaCrianzaPK.etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal = :etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByEtapaCrianzaidEtapaCrianza", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.practicaDeCrianzaEtapaCrianzaPK.etapaCrianzaidEtapaCrianza = :etapaCrianzaidEtapaCrianza"),
    @NamedQuery(name = "PracticaDeCrianzaEtapaCrianza.findByPlanificacionAlimentaria", query = "SELECT p FROM PracticaDeCrianzaEtapaCrianza p WHERE p.planificacionAlimentaria = :planificacionAlimentaria")})
public class PracticaDeCrianzaEtapaCrianza implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PracticaDeCrianzaEtapaCrianzaPK practicaDeCrianzaEtapaCrianzaPK;
    @Basic(optional = false)
    @Column(name = "planificacion_alimentaria")
    private String planificacionAlimentaria;
    @JoinColumns({
        @JoinColumn(name = "etapa_crianzarazaid_raza", referencedColumnName = "razaid_raza", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzarazaespecieanimalid_especie_animal", referencedColumnName = "razaespecieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzarazaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "razaespecieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false),
        @JoinColumn(name = "etapa_crianzaid_etapa_crianza", referencedColumnName = "id_etapa_crianza", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EtapaCrianza etapaCrianza;
    @JoinColumns({
        @JoinColumn(name = "practica_de_crianzaid_practica_crianza", referencedColumnName = "id_practica_crianza", insertable = false, updatable = false),
        @JoinColumn(name = "practica_de_crianzarazaid_raza", referencedColumnName = "razaid_raza", insertable = false, updatable = false),
        @JoinColumn(name = "practica_de_crianzarazaespecieanimalid_especie_animal", referencedColumnName = "razaespecieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "practica_de_crianzarazaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "razaespecieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PracticaDeCrianza practicaDeCrianza;

    public PracticaDeCrianzaEtapaCrianza() {
    }

    public PracticaDeCrianzaEtapaCrianza(PracticaDeCrianzaEtapaCrianzaPK practicaDeCrianzaEtapaCrianzaPK) {
        this.practicaDeCrianzaEtapaCrianzaPK = practicaDeCrianzaEtapaCrianzaPK;
    }

    public PracticaDeCrianzaEtapaCrianza(PracticaDeCrianzaEtapaCrianzaPK practicaDeCrianzaEtapaCrianzaPK, String planificacionAlimentaria) {
        this.practicaDeCrianzaEtapaCrianzaPK = practicaDeCrianzaEtapaCrianzaPK;
        this.planificacionAlimentaria = planificacionAlimentaria;
    }

    public PracticaDeCrianzaEtapaCrianza(int practicaDeCrianzaidPracticaCrianza, int practicaDeCrianzarazaidRaza, int practicaDeCrianzarazaespecieanimalidEspecieAnimal, int practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, int etapaCrianzarazaidRaza, int etapaCrianzarazaespecieanimalidEspecieAnimal, int etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, int etapaCrianzaidEtapaCrianza) {
        this.practicaDeCrianzaEtapaCrianzaPK = new PracticaDeCrianzaEtapaCrianzaPK(practicaDeCrianzaidPracticaCrianza, practicaDeCrianzarazaidRaza, practicaDeCrianzarazaespecieanimalidEspecieAnimal, practicaDeCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, etapaCrianzarazaidRaza, etapaCrianzarazaespecieanimalidEspecieAnimal, etapaCrianzarazaespecieanimalgrupoanimalidGrupoAnimal, etapaCrianzaidEtapaCrianza);
    }

    public PracticaDeCrianzaEtapaCrianzaPK getPracticaDeCrianzaEtapaCrianzaPK() {
        return practicaDeCrianzaEtapaCrianzaPK;
    }

    public void setPracticaDeCrianzaEtapaCrianzaPK(PracticaDeCrianzaEtapaCrianzaPK practicaDeCrianzaEtapaCrianzaPK) {
        this.practicaDeCrianzaEtapaCrianzaPK = practicaDeCrianzaEtapaCrianzaPK;
    }

    public String getPlanificacionAlimentaria() {
        return planificacionAlimentaria;
    }

    public void setPlanificacionAlimentaria(String planificacionAlimentaria) {
        this.planificacionAlimentaria = planificacionAlimentaria;
    }

    public EtapaCrianza getEtapaCrianza() {
        return etapaCrianza;
    }

    public void setEtapaCrianza(EtapaCrianza etapaCrianza) {
        this.etapaCrianza = etapaCrianza;
    }

    public PracticaDeCrianza getPracticaDeCrianza() {
        return practicaDeCrianza;
    }

    public void setPracticaDeCrianza(PracticaDeCrianza practicaDeCrianza) {
        this.practicaDeCrianza = practicaDeCrianza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (practicaDeCrianzaEtapaCrianzaPK != null ? practicaDeCrianzaEtapaCrianzaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PracticaDeCrianzaEtapaCrianza)) {
            return false;
        }
        PracticaDeCrianzaEtapaCrianza other = (PracticaDeCrianzaEtapaCrianza) object;
        if ((this.practicaDeCrianzaEtapaCrianzaPK == null && other.practicaDeCrianzaEtapaCrianzaPK != null) || (this.practicaDeCrianzaEtapaCrianzaPK != null && !this.practicaDeCrianzaEtapaCrianzaPK.equals(other.practicaDeCrianzaEtapaCrianzaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.PracticaDeCrianzaEtapaCrianza[ practicaDeCrianzaEtapaCrianzaPK=" + practicaDeCrianzaEtapaCrianzaPK + " ]";
    }
    
}

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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "practica_de_crianza", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PracticaDeCrianza.findAll", query = "SELECT p FROM PracticaDeCrianza p"),
    @NamedQuery(name = "PracticaDeCrianza.findByIdPracticaCrianza", query = "SELECT p FROM PracticaDeCrianza p WHERE p.practicaDeCrianzaPK.idPracticaCrianza = :idPracticaCrianza"),
    @NamedQuery(name = "PracticaDeCrianza.findByNombrePractica", query = "SELECT p FROM PracticaDeCrianza p WHERE p.nombrePractica = :nombrePractica"),
    @NamedQuery(name = "PracticaDeCrianza.findByManejoZootecnico", query = "SELECT p FROM PracticaDeCrianza p WHERE p.manejoZootecnico = :manejoZootecnico"),
    @NamedQuery(name = "PracticaDeCrianza.findByRazaidRaza", query = "SELECT p FROM PracticaDeCrianza p WHERE p.practicaDeCrianzaPK.razaidRaza = :razaidRaza"),
    @NamedQuery(name = "PracticaDeCrianza.findByRazaespecieanimalidEspecieAnimal", query = "SELECT p FROM PracticaDeCrianza p WHERE p.practicaDeCrianzaPK.razaespecieanimalidEspecieAnimal = :razaespecieanimalidEspecieAnimal"),
    @NamedQuery(name = "PracticaDeCrianza.findByRazaespecieanimalgrupoanimalidGrupoAnimal", query = "SELECT p FROM PracticaDeCrianza p WHERE p.practicaDeCrianzaPK.razaespecieanimalgrupoanimalidGrupoAnimal = :razaespecieanimalgrupoanimalidGrupoAnimal")})
public class PracticaDeCrianza implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PracticaDeCrianzaPK practicaDeCrianzaPK;
    @Basic(optional = false)
    @Column(name = "nombre_practica")
    private String nombrePractica;
    @Basic(optional = false)
    @Column(name = "manejo_zootecnico")
    private String manejoZootecnico;
    @JoinTable(name = "practica_de_crianza_consejos_practicas_crianza", joinColumns = {
        @JoinColumn(name = "practica_de_crianzaid_practica_crianza", referencedColumnName = "id_practica_crianza"),
        @JoinColumn(name = "practica_de_crianzarazaid_raza", referencedColumnName = "razaid_raza"),
        @JoinColumn(name = "practica_de_crianzarazaespecieanimalid_especie_animal", referencedColumnName = "razaespecieanimalid_especie_animal"),
        @JoinColumn(name = "practica_de_crianzarazaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "razaespecieanimalgrupoanimalid_grupo_animal")}, inverseJoinColumns = {
        @JoinColumn(name = "consejos_practicas_crianzaid_consejo_practica_crianza", referencedColumnName = "id_consejo_practica_crianza")})
    @ManyToMany
    private List<ConsejosPracticasCrianza> consejosPracticasCrianzaList;
    
    @JoinColumns({
        @JoinColumn(name = "razaid_raza", referencedColumnName = "id_raza", insertable = false, updatable = false),
        @JoinColumn(name = "razaespecieanimalid_especie_animal", referencedColumnName = "especieanimalid_especie_animal", insertable = false, updatable = false),
        @JoinColumn(name = "razaespecieanimalgrupoanimalid_grupo_animal", referencedColumnName = "especieanimalgrupoanimalid_grupo_animal", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Raza raza;

    public PracticaDeCrianza() {
    }

    public PracticaDeCrianza(PracticaDeCrianzaPK practicaDeCrianzaPK) {
        this.practicaDeCrianzaPK = practicaDeCrianzaPK;
    }

    public PracticaDeCrianza(PracticaDeCrianzaPK practicaDeCrianzaPK, String nombrePractica, String manejoZootecnico) {
        this.practicaDeCrianzaPK = practicaDeCrianzaPK;
        this.nombrePractica = nombrePractica;
        this.manejoZootecnico = manejoZootecnico;
    }

    public PracticaDeCrianza(int idPracticaCrianza, int razaidRaza, int razaespecieanimalidEspecieAnimal, int razaespecieanimalgrupoanimalidGrupoAnimal) {
        this.practicaDeCrianzaPK = new PracticaDeCrianzaPK(idPracticaCrianza, razaidRaza, razaespecieanimalidEspecieAnimal, razaespecieanimalgrupoanimalidGrupoAnimal);
    }

    public PracticaDeCrianzaPK getPracticaDeCrianzaPK() {
        return practicaDeCrianzaPK;
    }

    public void setPracticaDeCrianzaPK(PracticaDeCrianzaPK practicaDeCrianzaPK) {
        this.practicaDeCrianzaPK = practicaDeCrianzaPK;
    }

    public String getNombrePractica() {
        return nombrePractica;
    }

    public void setNombrePractica(String nombrePractica) {
        this.nombrePractica = nombrePractica;
    }

    public String getManejoZootecnico() {
        return manejoZootecnico;
    }

    public void setManejoZootecnico(String manejoZootecnico) {
        this.manejoZootecnico = manejoZootecnico;
    }

    @XmlTransient
    public List<ConsejosPracticasCrianza> getConsejosPracticasCrianzaList() {
        return consejosPracticasCrianzaList;
    }

    public void setConsejosPracticasCrianzaList(List<ConsejosPracticasCrianza> consejosPracticasCrianzaList) {
        this.consejosPracticasCrianzaList = consejosPracticasCrianzaList;
    }

   

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (practicaDeCrianzaPK != null ? practicaDeCrianzaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PracticaDeCrianza)) {
            return false;
        }
        PracticaDeCrianza other = (PracticaDeCrianza) object;
        if ((this.practicaDeCrianzaPK == null && other.practicaDeCrianzaPK != null) || (this.practicaDeCrianzaPK != null && !this.practicaDeCrianzaPK.equals(other.practicaDeCrianzaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.PracticaDeCrianza[ practicaDeCrianzaPK=" + practicaDeCrianzaPK + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.model;

import java.io.Serializable;
import java.util.Date;
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
 * @author Carrillo
 */
@Entity
@Table(name = "minutos", catalog = "Proyect_BD", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Minutos.findAll", query = "SELECT m FROM Minutos m"),
    @NamedQuery(name = "Minutos.findByObrerosidObrero", query = "SELECT m FROM Minutos m WHERE m.minutosPK.obrerosidObrero = :obrerosidObrero"),
    @NamedQuery(name = "Minutos.findByFecha", query = "SELECT m FROM Minutos m WHERE m.minutosPK.fecha = :fecha"),
    @NamedQuery(name = "Minutos.findByMinutosTrabajados", query = "SELECT m FROM Minutos m WHERE m.minutosTrabajados = :minutosTrabajados"),
    @NamedQuery(name = "Minutos.findByMinutosTarde", query = "SELECT m FROM Minutos m WHERE m.minutosTarde = :minutosTarde")})
public class Minutos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MinutosPK minutosPK;
    @Basic(optional = false)
    @Column(name = "minutos_trabajados")
    private int minutosTrabajados;
    @Basic(optional = false)
    @Column(name = "minutos_tarde")
    private int minutosTarde;
    @JoinColumn(name = "obrerosid_obrero", referencedColumnName = "id_obrero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Obreros obreros;

    public Minutos() {
    }

    public Minutos(MinutosPK minutosPK) {
        this.minutosPK = minutosPK;
    }

    public Minutos(MinutosPK minutosPK, int minutosTrabajados, int minutosTarde) {
        this.minutosPK = minutosPK;
        this.minutosTrabajados = minutosTrabajados;
        this.minutosTarde = minutosTarde;
    }

    public Minutos(int obrerosidObrero, Date fecha) {
        this.minutosPK = new MinutosPK(obrerosidObrero, fecha);
    }

    public MinutosPK getMinutosPK() {
        return minutosPK;
    }

    public void setMinutosPK(MinutosPK minutosPK) {
        this.minutosPK = minutosPK;
    }

    public int getMinutosTrabajados() {
        return minutosTrabajados;
    }

    public void setMinutosTrabajados(int minutosTrabajados) {
        this.minutosTrabajados = minutosTrabajados;
    }

    public int getMinutosTarde() {
        return minutosTarde;
    }

    public void setMinutosTarde(int minutosTarde) {
        this.minutosTarde = minutosTarde;
    }

    public Obreros getObreros() {
        return obreros;
    }

    public void setObreros(Obreros obreros) {
        this.obreros = obreros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (minutosPK != null ? minutosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Minutos)) {
            return false;
        }
        Minutos other = (Minutos) object;
        if ((this.minutosPK == null && other.minutosPK != null) || (this.minutosPK != null && !this.minutosPK.equals(other.minutosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pr.Minutos[ minutosPK=" + minutosPK + " ]";
    }
    
}

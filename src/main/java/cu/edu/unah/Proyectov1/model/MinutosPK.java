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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carrillo
 */
@Embeddable
public class MinutosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "obrerosid_obrero")
    private int obrerosidObrero;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public MinutosPK() {
    }

    public MinutosPK(int obrerosidObrero, Date fecha) {
        this.obrerosidObrero = obrerosidObrero;
        this.fecha = fecha;
    }

    public int getObrerosidObrero() {
        return obrerosidObrero;
    }

    public void setObrerosidObrero(int obrerosidObrero) {
        this.obrerosidObrero = obrerosidObrero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) obrerosidObrero;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MinutosPK)) {
            return false;
        }
        MinutosPK other = (MinutosPK) object;
        if (this.obrerosidObrero != other.obrerosidObrero) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pr.MinutosPK[ obrerosidObrero=" + obrerosidObrero + ", fecha=" + fecha + " ]";
    }
    
}

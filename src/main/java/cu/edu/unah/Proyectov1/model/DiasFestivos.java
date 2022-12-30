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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carrillo
 */
@Entity
@Table(name = "dias_festivos", catalog = "Proyect_BD", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiasFestivos.findAll", query = "SELECT d FROM DiasFestivos d"),
    @NamedQuery(name = "DiasFestivos.findByFecha", query = "SELECT d FROM DiasFestivos d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DiasFestivos.findByIdentificador", query = "SELECT d FROM DiasFestivos d WHERE d.identificador = :identificador")})
public class DiasFestivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "identificador")
    private boolean identificador;

    public DiasFestivos() {
    }

    public DiasFestivos(Date fecha) {
        this.fecha = fecha;
    }

    public DiasFestivos(Date fecha, boolean identificador) {
        this.fecha = fecha;
        this.identificador = identificador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getIdentificador() {
        return identificador;
    }

    public void setIdentificador(boolean identificador) {
        this.identificador = identificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiasFestivos)) {
            return false;
        }
        DiasFestivos other = (DiasFestivos) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pr.DiasFestivos[ fecha=" + fecha + " ]";
    }
    
}

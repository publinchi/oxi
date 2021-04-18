package com.oxi.persistence.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.oxi.persistence.deser.MultiDateDeserializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "producto")
public class Producto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String lote;
    private String serie;
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @Column(name = "fecha_expiracion")
    private Date fechaExpiracion;
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @Column(name = "fecha_salida")
    private Date fechaSalida;
    @Column(name = "registro_sanitario")
    private String registroSanitario;
    private String observacion;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "forma_farmaceutica")
    private String formaFarmaceutica;
    private String concentracion;
    private String presentacion;
    private String proveedor;
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @Column(name = "fecha_elaboracion")
    private Date fechaElaboracion;
    @Column(name = "entregado_por")
    private String entregadoPor;
    @Column(name = "recibido_por")
    private String recibidoPor;
    private String cliente;

    public Producto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaCaducidad) {
        this.fechaExpiracion = fechaCaducidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getRegistroSanitario() {
        return registroSanitario;
    }

    public void setRegistroSanitario(String registroSanitario) {
        this.registroSanitario = registroSanitario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String descripcion) {
        this.observacion = descripcion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public String getEntregadoPor() {
        return entregadoPor;
    }

    public void setEntregadoPor(String entregadoPor) {
        this.entregadoPor = entregadoPor;
    }

    public String getRecibidoPor() {
        return recibidoPor;
    }

    public void setRecibidoPor(String recibidoPor) {
        this.recibidoPor = recibidoPor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == 0) ? 0 : Long.valueOf(id).hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (id == 0) {
            return other.id == 0;
        } else return id == other.id;
    }
}

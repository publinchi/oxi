package org.primefaces.showcase.view.data.datatable;

import com.oxi.persistence.model.Producto;
import org.primefaces.showcase.service.ProductoService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Named
@ViewScoped
public class ProductoCrudView implements Serializable {

    private List<Producto> productos;

    private Producto selectedProducto;

    private List<Producto> selectedProductos;

    @Inject
    private ProductoService productoService;

    @PostConstruct
    public void init() {
        this.productos = this.productoService.getProductos();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Producto getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }

    public List<Producto> getSelectedProductos() {
        return selectedProductos;
    }

    public void setSelectedProductos(List<Producto> selectedProductos) {
        this.selectedProductos = selectedProductos;
    }

    public void openNew() {
        this.selectedProducto = new Producto();
    }

    public void save() {
        if (Objects.nonNull(this.selectedProducto) && this.selectedProducto.getId() <= 0) {
            this.selectedProducto.setFechaIngreso(Calendar.getInstance().getTime());
            Producto producto = this.productoService.save(this.selectedProducto);
            if(Objects.nonNull(producto)) {
                this.productos.add(producto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Agregado"));
            }
        }
        else {
            try {
                this.productoService.save(this.selectedProducto);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Actualizado"));
            } catch(BadRequestException badRequestException){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error al actualizar",
                        "Producto no pudo ser actualizado!!!"));
            }
        }

        this.selectedProducto = null;

        PrimeFaces.current().executeScript("PF('manageProductoDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-Productos");
    }

    public void delete() {
        this.productoService.delete(this.selectedProducto);
        this.productos.remove(this.selectedProducto);
        if(Objects.nonNull(this.selectedProductos))
            this.selectedProductos.remove(this.selectedProducto);
        this.selectedProducto = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto Removido"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-Productos");
    }

    public void findAll() {
        this.productoService.findAll();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProductos()) {
            int size = this.selectedProductos.size();
            return size > 1 ? size + " Productos Seleccionados" : "1 Producto Seleccionado";
        }

        return "Borrar";
    }

    public boolean hasSelectedProductos() {
        return this.selectedProductos != null && !this.selectedProductos.isEmpty();
    }

    public void deleteSelectedProductos() {
        for (Producto Producto : this.selectedProductos) {
            this.productoService.delete(Producto);
        }

        this.productos.removeAll(this.selectedProductos);
        this.selectedProductos = null;

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Productos removidos"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-Productos");
        PrimeFaces.current().executeScript("PF('dtProductos').clearFilters()");
    }

}
package org.primefaces.showcase.service;

import com.oxi.persistence.model.Producto;
import org.primefaces.showcase.common.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Named
@ApplicationScoped
public class ProductoService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    List<Producto> productos;

    @Inject
    private RestClient restClient;

    @PostConstruct
    public void init() {
        productos = findAll();
    }

    public List<Producto> getProductos() {
        return findAll();
    }

    public List<Producto> getProducts(int size) {

        if (size > productos.size()) {
            Random rand = new Random();

            List<Producto> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(productos.size());
                randomList.add(productos.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(productos).subList(0, size);
        }

    }

    public Producto save(Producto producto) throws BadRequestException {
        Producto clientResponse = null;

        if(producto.getId() <=0) {
            WebTarget webTarget = restClient.getWebTarget("productos");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            clientResponse = invocationBuilder.post(Entity.entity(producto, MediaType.APPLICATION_JSON), Producto.class);
        } else {
            WebTarget webTarget = restClient.getWebTarget("productos/" + producto.getId());
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            invocationBuilder.put(Entity.entity(producto, MediaType.APPLICATION_JSON), Producto.class);
        }

        return clientResponse;
    }

    public void delete(Producto producto) {
        WebTarget webTarget = restClient.getWebTarget("productos/" + producto.getId());
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        invocationBuilder.delete();
    }

    public Producto find(long id) {
        return null;
    }

    public List<Producto> findAll() {
        WebTarget webTarget = restClient.getWebTarget("productos");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        return invocationBuilder.get(new GenericType<List<Producto>>() {});
    }

}

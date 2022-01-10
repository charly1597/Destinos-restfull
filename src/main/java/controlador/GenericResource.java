/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package controlador;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Crud;
import modelo.Destinos;

/**
 * REST Web Service
 *
 * @author Carlos Talavera
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @GET
    @Path("/destinos/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Destinos> getDestinos(){
        List<Destinos> misDestinos = Crud.getDestinos();
        return misDestinos;
    }
    
    @GET
    @Path("/destino/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Destinos getDestino(@PathParam("id") int id){
        Destinos miDestino = Crud.getDestino(id);
        return miDestino;
    }
    
    @PUT
    @Path("/destino/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Destinos updateDestino(Destinos d){
        Crud.actualizaDestino(d);
        return d;
    }
    
    @DELETE
    @Path("/destino/{id}")
    public void borrarDestino(@PathParam("id") int id){
        Crud.destroyDestino(id);
    }
    
    @POST
    @Path("/destino/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void setDestino(Destinos d){
        Crud.insertaDestino(d);
    }
}

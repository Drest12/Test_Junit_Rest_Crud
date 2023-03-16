/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Servicio;

import Clases.Apoderado;
import Clases.Service_operaciones;
import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("generic")
public class Main {

    @Context
    private UriInfo context;


    public Main() {
    }

    Apoderado apo =new Apoderado();
     Service_operaciones ser =new Service_operaciones();
    
     
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Apoderado> mostrar_apoderado() {
    return ser.listar_apoderado();
        
    }
    
    
    @Path("update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
    public Response actualizacion(Apoderado a){
    
    ser.ActualizarApoderado(a);
    return Response.ok().entity(a).build();
    }
    
    
    
    @Path("delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void eliminar(@QueryParam("id")int id)
    {
        ser.Eliminar(id);
    }

   
    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response guardar(Apoderado a)
    {
        ser.InsertarApoderado(a);
          return Response.ok().entity(a).build();
        
    }
}

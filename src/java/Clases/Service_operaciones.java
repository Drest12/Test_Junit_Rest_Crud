package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

public class Service_operaciones {

    private Connection conect;
    private PreparedStatement sql;
    Apoderado apo = new Apoderado();
    //insertar apoderado

    public void InsertarApoderado(Apoderado apo) {
        try {
            conect = Conexion.conex();
            sql = conect.prepareStatement("insert into apoderada(idapoderado, nombre, apellido, dni) values (?,?,?,?) ");
            sql.setInt(1, apo.getIdapoderado());
            sql.setString(2, apo.getNombre());
            sql.setString(3, apo.getApellido());
            sql.setString(4, apo.getDni());

            int rpta = sql.executeUpdate();
            if (rpta > 0) {
                System.err.println("El Apoderado se Guardo Con Exito");
            } else {
                System.out.println("Ocurrio un error en la insercion");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    
    //listar apoderado
    public List<Apoderado> listar_apoderado() {

        List<Apoderado> listar = new ArrayList<Apoderado>();
        
        try 
        {
           conect=Conexion.conex();
            Statement st= conect.createStatement();
            ResultSet resultado =st.executeQuery("Select * from apoderado");
            while(resultado.next())
            {
                Apoderado apo = new Apoderado();
                
                apo.setApellido( resultado.getString("apellido"));
                apo.setNombre(resultado.getString("nombre"));
                apo.setIdapoderado(resultado.getInt("idapoderado"));
                apo.setDni(resultado.getString("dni"));
                 listar.add(apo);
            }
           
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return listar;
    }
    public void Eliminar(int id)
    {
        try {
           conect= Conexion.conex();
           sql = conect.prepareStatement("delete from apoderada where idapoderado =?");
           sql.setInt(1,id);
           int rpta= sql.executeUpdate();
           if(rpta>0)
           {
               System.out.println("EL REGISTRO HA SIDO ELIMINADO");
           }
           else{
               System.out.println(" error");
           }
               
               
               
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void  ActualizarApoderado(Apoderado a)
    {
        try {
            conect=Conexion.conex();
            sql=conect.prepareStatement("update apoderada set nombre=?,apellido=?,dni=? where idapoderado=?");
            sql.setString(1, a.getNombre());
            sql.setString(2, a.getApellido());
            sql.setString(3, a.getDni());
            sql.setInt(4, a.getIdapoderado());
            int rpta=sql.executeUpdate();
            if(rpta>0)
            {
                System.out.println("Actualizado correctamente");
            }
            else{
                System.out.println("error");
            }
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

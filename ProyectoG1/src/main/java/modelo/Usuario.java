/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public abstract class Usuario implements Serializable {

    protected String usuario;
    protected String contrasena;
    protected String nombre;
    protected TipoUsuario TipoUsuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }



    public Usuario(String usuario, String contrasena, String nombre, TipoUsuario TipoUsuario) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.TipoUsuario = TipoUsuario;
    }
   
@Override
   public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null &&  obj instanceof Usuario) {
        //if (obj != null &&  getClass() == obj.getClass()) {
       
        
            Usuario other = (Usuario) obj;
            return (contrasena.equals(other.contrasena)&& usuario.equals(other.usuario));
        }
       
        
        return false;
    }
   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.usuario);
        hash = 53 * hash + Objects.hashCode(this.contrasena);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.TipoUsuario);
        return hash;
    }
    
   public static ArrayList<Usuario> cargarUsuarios(String ruta) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx Cargando Usuarios xxxxxxxxxxxxxxxx");
       //leer la lista de personas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            usuarios = (ArrayList<Usuario>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return usuarios;
    }
    
   }

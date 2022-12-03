/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.modelo;

import com.mycompany.proyecto.enums.TipoUsuario;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public abstract class Usuario {

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
   }

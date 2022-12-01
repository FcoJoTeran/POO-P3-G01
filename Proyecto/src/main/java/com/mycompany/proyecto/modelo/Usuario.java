/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.modelo;

import com.mycompany.proyecto.enums.TipoUsuario;

/**
 *
 * @author LENOVO
 */
public abstract class Usuario {
    protected String usuario;
    protected String contraseña;
    protected String nombre;
    protected TipoUsuario TipoUsuario;
}

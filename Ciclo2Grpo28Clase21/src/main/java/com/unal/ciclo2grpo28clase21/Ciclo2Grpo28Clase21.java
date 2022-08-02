package com.unal.ciclo2grpo28clase21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Ciclo2Grpo28Clase21 {

    public static void main(String[] args) {
        
        JDBC conectarConLibreria = new JDBC();
        //conectarConLibreria.conectar();
        //conectarConLibreria.desconectar();
        //conectarConLibreria.insertarPelicula("The Terminator","Robot asesinos del futuro","Acción",1984,108,20,3);
        conectarConLibreria.actualizarPelicula();
        conectarConLibreria.leerPeliculas();
        
        
    }
}

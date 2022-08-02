/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unal.ciclo2grpo28clase21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class JDBC {

    Connection conn;

    JDBC() {
    }

    public void conectar() {
        String dbURL = "jdbc:mysql://127.0.0.1:3306/pelisplus";
        String username = "root";
        String password = "Admin123#";
        // conectar
        try {
            this.conn = DriverManager.getConnection(
                    dbURL, username, password);
            if (conn != null) {
                System.out.println(" Conectado ");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    //-------------------------------------------
    public void desconectar() {
        try {
            if (!conn.isClosed()) {
                conn.close();
                System.out.println("Desconectado");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //--------------------------------------------------
    public boolean insertarPelicula() {
        boolean resultado = false;
        this.conectar();
        try {

            String sql = " INSERT INTO peliculas (titulo , tema , "
                    + "genero ,anio ,duracion , calificacion,id_director )"
                    + "VALUES ( ?, ?,  ?,  ?,  ?,  ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "Jhon Wick");
            statement.setString(2, "Asesino que busca venganza");
            statement.setString(3, "Acción");
            statement.setInt(4, 2014);
            statement.setInt(5, 114);
            statement.setInt(6, 5);
            statement.setInt(7, 4);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Inserción exitosa !");
                resultado = true;
            }
            this.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    //--------------------------------------------------------
    public boolean insertarPelicula(String titulo, String tema, String genero,
            int anio, int duracion, int calificacion, int id_director) {
        boolean resultado = false;
        this.conectar();
        try {

            String sql = " INSERT INTO peliculas (titulo , tema , "
                    + "genero ,anio ,duracion , calificacion,id_director )"
                    + "VALUES ( ?, ?,  ?,  ?,  ?,  ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, titulo);
            statement.setString(2, tema);
            statement.setString(3, genero);
            statement.setInt(4, anio);
            statement.setInt(5, duracion);
            statement.setInt(6, calificacion);
            statement.setInt(7, id_director);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Inserción exitosa !");
                resultado = true;
            }
            this.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    //--------------------------------------------------------
    public void leerPeliculas() {
        this.conectar();
        try {

            String sql = "SELECT * FROM peliculas";
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
            while (result.next()) {

                String titulo = result.getString(2);
                String tema = result.getString(3);
                String genero = result.getString(4);

                int anio = result.getInt(5);
                int duracion = result.getInt(6);
                int calificacion = result.getInt(7);

                System.out.print("Título : " + titulo
                        + " Tema: " + tema
                        + " Genero : " + genero
                        + " Año : " + anio
                        + " Duracion: " + duracion + "min ");
                if (calificacion > 5) {
                    System.out.println(" Calificacion : " + calificacion + "/5 y GOD");
                } else {
                    System.out.println(" Calificacion : " + calificacion + "/5");
                }

            }
            this.desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //--------------------------------------------------------
    public boolean actualizarPelicula() {
        boolean resultado = false;
        this.conectar();
        try {

            String sql = " UPDATE peliculas SET calificacion = ?, duracion =  ?"
                    + " WHERE  id =  ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 5);
            statement.setInt(2, 115);
            statement.setInt(3, 2);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("El registro fue "
                        + " actualizado exitosamente !");
            }
        
        this.desconectar();
    }
    catch (SQLException ex ) {
            ex.printStackTrace();
    }
    return resultado ;
}

}

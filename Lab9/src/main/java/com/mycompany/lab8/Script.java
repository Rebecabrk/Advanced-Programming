/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rebec
 */
public class Script {
    public static void createBooksTable() throws SQLException{
        StringBuilder command = new StringBuilder("create table books(");
        command.append("id number(5,0),");
        command.append("genre_id number(5,0),");
        command.append("author_id number(5,0),");
        command.append("title varchar2(50),");
        command.append("language varchar2(10),");
        command.append("publication_date date,");
        command.append("number_of_pages number(5,0)");
        command.append(");");
     
        try(Statement stmt = Database.getConnection().createStatement()){
            stmt.executeUpdate(command.toString());
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public static void createAuthorsTable() throws SQLException{
        StringBuilder command = new StringBuilder("create table authors(");
        command.append("id number(5,0),");
        command.append("name varchar2(50),");
        command.append("book_id number(5,0)");
        command.append(");");
     
        try(Statement stmt = Database.getConnection().createStatement()){
            stmt.executeUpdate(command.toString());
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public static void createGenreTable() throws SQLException{
        StringBuilder command = new StringBuilder("create table genre(");
        command.append("id number(5,0),");
        command.append("type varchar2(20)");
        command.append(");");
     
        try(Statement stmt = Database.getConnection().createStatement()){
            stmt.executeUpdate(command.toString());
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab8;

import java.sql.SQLException;

/**
 *
 * @author rebec
 */
public class Lab8 {

    public static void main(String[] args) {
        try {
            Database.createConnection();
            
            var authors = new AuthorDAO();
            authors.create("William Shakespeare");
            var genres = new GenreDAO();
            genres.create("Tragedy");
            Database.getConnection().commit();
            var books = new BookDAO(); //findByName
            books.create("Romeo and Juliet", "William Shakespeare", "Tragedy");
            books.create("The Hitchhiker's Guide to the Galaxy",
                    "Douglas Adams", "Science");
            Database.getConnection().commit();
            
            books.findAll();
            
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        } finally{
            //Database.rollback();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rebec
 */
public class BookDAO implements DAO {
    private static int id;
    
    public BookDAO(){
        id++;
    }

    @Override
    public void create(String... names) {
        Connection con = Database.getConnection();

        int author_id = -1;
        int genre_id = -1;

        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from authors where name='" + names[1] + "'")) {
            while (rs.next()) {
                author_id = rs.getInt("id");
            }
            if(author_id == -1){
                var new_author = new AuthorDAO();
                new_author.create(names[1]);
                author_id = new_author.getId();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from genre where type='" + names[2] + "'")) {
            while (rs.next()) {
                genre_id = rs.getInt("id");
            }
            if(genre_id == -1){
                var new_genre = new GenreDAO();
                new_genre.create(names[2]);
                genre_id = new_genre.getId();
            }
        } catch (SQLException e1) {
            System.err.println(e1);
        }

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into books (title, author_id, genre_id, id) values (?, ?, ?)")) {
            pstmt.setString(1, names[0]);
            pstmt.setInt(2, author_id);
            pstmt.setInt(3, genre_id);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e2) {
            System.err.println(e2);
        }

    }

    @Override
    public int findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from books where title='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            return -1;
        }
    }

    @Override
    public String findById(int id) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select title from books where id='" + id + "'")) {
            return rs.next() ? rs.getNString("title") : null;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            return "";
        }
    }

    @Override
    public void findAll() {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select * from books")) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int colnum = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= colnum; i++) {
                    String colValue = rs.getString(i);
                    System.out.println(colValue + " " + rsmd.getColumnName(i));
                    
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}

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
public class GenreDAO implements DAO {
    private static int id;
    
    public GenreDAO(){
        id++;
    }

    @Override
    public void create(String... names) {
        Connection con = Database.getConnection();
        for (int i = 0; i < names.length; i++) {
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into genre (id, type) values (?, ?)")) {
                pstmt.setInt(1, id);
                pstmt.setString(2, names[i]);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    @Override
    public int findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from genre where type='" + name + "'")) {
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
                "select name from genre where id='" + id + "'")) {
            return rs.next() ? rs.getNString("type") : null;
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
                "select * from genre")) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int colnum = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= colnum; i++) {
                    System.out.println("");
                    String colValue = rs.getString(i);
                    System.out.println(colValue + " " + rsmd.getColumnName(i));
                    System.out.println("");
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static int getId() {
        return id;
    }

}

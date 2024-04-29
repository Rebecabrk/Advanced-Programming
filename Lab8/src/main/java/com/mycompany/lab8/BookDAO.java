/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public BookDAO() {
        id++;
    }

    @Override
    public void create(String... names) {
        Connection con = null;
        try {
            con = Database.getConnection();
        } catch (SQLException e) {
            System.err.println(e);
        }

        int author_id = -1;
        int genre_id = -1;

        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select id from authors where name='" + names[1] + "'")) {
            if (rs.next()) {
                author_id = rs.getInt("id");
            }
            if (author_id == -1) {
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
            if (genre_id == -1) {
                var new_genre = new GenreDAO();
                new_genre.create(names[2]);
                genre_id = new_genre.getId();
            }
        } catch (SQLException e1) {
            System.err.println(e1);
        }

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into books_initial (title, author_id, genre_id, id) values (?, ?, ?, ?)")) {
            pstmt.setString(1, names[0]);
            pstmt.setInt(2, author_id);
            pstmt.setInt(3, genre_id);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            id++;
        } catch (SQLException e2) {
            System.err.println(e2);
        }

    }

    @Override
    public int findByName(String name) {
        Connection con = null;
        try {
            con = Database.getConnection();
        } catch (SQLException e) {
            System.err.println(e);
        }
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
        Connection con = null;
        try {
            con = Database.getConnection();
        } catch (SQLException e) {
            System.err.println(e);
        }
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
        Connection con = null;
        try {
            con = Database.getConnection();
        } catch (SQLException e) {
            System.err.println(e);
        }
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select * from books_initial")) {
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {

                int col1Value = rs.getInt("id");
                int col2Value = rs.getInt("genre_id");
                int col3Value = rs.getInt("author_id");
                String col4Value = rs.getString("title");
                System.out.println(col1Value + " " + "id");
                System.out.println(col2Value + " " + "genre_id");
                System.out.println(col3Value + " " + "author_id");
                System.out.println(col4Value + " " + "title");

                System.out.println("");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void importData() {
        String csvFile = "C:\\Users\\rebec\\OneDrive\\Desktop\\Advanced-Programming-\\Lab8\\books.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));) {
            Connection conn = null;
            try {
                conn = Database.getConnection();
            } catch (SQLException e) {
                System.err.println(e);
            }
            String insertSQL = "INSERT INTO books (bookID, title, authors, average_rating, isbn, isbn13, language_code, num_pages, ratings_count, text_reviews_count, publication_date, publisher) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);

            String line;
            //while ((line = br.readLine()) != null) {
            for(int i=1; i<= 100 ; i++){
                line = br.readLine();
                // split on comma(',')
                String[] books = line.split(",");

                pstmt.setString(1, books[0]);
                pstmt.setString(2, books[1]);
                pstmt.setString(3, books[2]);
                pstmt.setString(4, books[3]);
                pstmt.setString(5, books[4]);
                pstmt.setString(6, books[5]);
                pstmt.setString(7, books[6]);
                pstmt.setString(8, books[7]);
                pstmt.setString(9, books[8]);
                pstmt.setString(10, books[9]);
                pstmt.setString(11, books[10]);
                pstmt.setString(12, books[11]);

                pstmt.executeUpdate();
            }

            System.out.println("Data imported successfully.");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

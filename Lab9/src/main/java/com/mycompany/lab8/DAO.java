/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.lab8;

import java.util.List;

/**
 *
 * @author rebec
 */
public interface DAO {
    public void create(String... names);
    public int findByName(String name);
    public String findById(int id);
    public void findAll();
}

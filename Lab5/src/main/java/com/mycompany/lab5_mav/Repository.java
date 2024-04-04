/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_mav;

import java.util.HashSet;

/**
 *
 * @author rebec
 */
public class Repository {
    private String name; //name of the sub-directory of every person 
    private HashSet<Document> content;

    public String getName() {
        return name;
    }
    
    public Repository(Person p){
        content = new HashSet<>();
        name = new String("#");
        this.name = name + Integer.toString(p.id());
    }
    
    public void add(Document d){
        if(content.contains(d)){
            System.out.println("Document " + d.file().getName() + "already exists!");
        }else{
            content.add(d);
        }
    }
    
    public String ls(){
        StringBuilder result = new StringBuilder();
        if(content.isEmpty()){
            result.append("This directory is empty.");
        }else{
            for(Document d : content){
                result.append(d.file().getName() + "\n");
                System.out.println(d.file().getName());
            }
        }
        return result.toString();
    }
}

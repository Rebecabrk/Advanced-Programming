/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab5;

import java.util.HashSet;

/**
 *
 * @author rebec
 */
public class Repository{ 
    private String name; //name of the sub-directory of every person 
    HashSet<Document> content;
    
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
    
    public void ls(){
        if(content.isEmpty()){
            System.out.println(name + " is empty.");
        }else{
            System.out.println("The content of " + name + ":");
            for(Document d : content){
                System.out.println(d.file().getName());
            }
        }
    }
}

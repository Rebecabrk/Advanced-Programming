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
    
    public Repository(int id){
        content = new HashSet<>();
        this.name = Integer.toString(id);
    }
    
    public void add(Document d){
        if(content.contains(d)){
            System.out.println("Document " + d.name() + "already exists!");
        }else{
            String[] words = d.name().split("\\s+");
            StringBuilder new_d_name = new StringBuilder();
            int i=words.length;
            for(String word : words){
                new_d_name.append(word);
                if(i > 1){
                    new_d_name.append("_");
                }
                i--;
            }
            new_d_name.append(".").append(d.format());
            
            Document new_d = new Document(new_d_name.toString(), d.format());
            content.add(new_d);
        }
    }
    
    public void ls(){
        if(content.isEmpty()){
            System.out.println(name + " is empty.");
        }else{
            System.out.println("The content of " + name + ":");
            for(Document d : content){
                System.out.println(d.name());
            }
        }
    }
}

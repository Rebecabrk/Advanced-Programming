/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab5;

import static lab5.Format.jpg;

/**
 *
 * @author rebec
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Repository r = new Repository(1);
        
        Document d = new Document("rebeca's photo", jpg);
        r.add(d);
        
        r.ls();
    }
    
}

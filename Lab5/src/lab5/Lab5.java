/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab5;

import java.io.File;
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
        Person rebeca = new Person(1,"Rebeca Costache");
        Repository r = new Repository(rebeca);
        File f = new File("rebeca.txt");
        Document d = new Document(f);
        
        r.ls();
        r.add(d);
        r.ls();
    }
    
}

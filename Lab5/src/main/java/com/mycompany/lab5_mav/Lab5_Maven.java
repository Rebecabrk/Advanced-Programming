/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab5_mav;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author rebec
 */
public class Lab5_Maven {

    public static void main(String[] args) throws Exception {
        Person rebeca = new Person(1, "Rebeca Costache");
        Repository r = new Repository(rebeca);
        Document d = new Document(new File("C:/Users/rebec/OneDrive/Desktop/ex_cpp_bit/test.cpp"));
        r.add(d);

        Scanner scanner = new Scanner(System.in);

        String command = new String();
        System.out.println("-> view (one doc from your repo)");
        System.out.println("-> report (HTML with repo contents)");
        System.out.println("-> export (JSON with repo contents)");
        System.out.println("-> quit (to end shell)");
        do {
            System.out.println("Enter something:");
            command = scanner.nextLine();
            try{
                if(command == null){
                    throw(new MyException("command is null"));
                }
            }catch(MyException e){
                
            }
            if (command.equals("view")) {
                System.out.println("Enter the file you want to view:");
                String file = new String();
                file = scanner.nextLine();
                File f = new File("C:\\Users\\rebec\\OneDrive\\Desktop\\Advanced-Programming-\\Lab5_Maven\\repositories\\#1\\" + file.trim());
                view.view(f);
            } else if (command.equals("report")) {
               report.report(r);
            } else if (command.equals("export")){
                
            }
        } while (!command.equals("quit"));

    }
}

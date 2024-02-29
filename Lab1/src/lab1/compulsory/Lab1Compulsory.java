/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1.compulsory;

import java.util.Arrays;

/**
 *
 * @author rebec
 */
public class Lab1Compulsory {
    
    public static int sum(int x){
        int result = 0;
        while(x > 9){
            result += x % 10;
            x /= 10;
        }
        result += x;
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(Arrays.toString(languages));
        System.out.println(n);
        
        int m = n * 3;
        System.out.println(m);
        
        int b = m + 0b10101;
        System.out.println(b);
        
        int h = b + 0XFF;
        System.out.println(h);
        
        int r = h * 6;
        System.out.println(r);
        
        int result = sum(r);
        while (result > 9){
            result = sum(result);
        }
        
        System.out.println(result);
        
        StringBuilder sb = new StringBuilder("Willy-nilly, this semester I will learn ");
        sb.append(languages[result]);
        
        System.out.println(sb);
    }
    
}

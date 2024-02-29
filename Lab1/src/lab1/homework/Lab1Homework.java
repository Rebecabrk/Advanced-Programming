/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1.homework;

/**
 *
 * @author rebec
 */
public class Lab1Homework {
    public static int multipliedSum(int x){
        int result = 0;
        while(x > 9){
            result += (x % 10) * (x % 10);
            x /= 10;
        }
        result += x * x;
        return result;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
         if(args.length < 3 || args.length > 3){
            System.out.println("Usage: <a> (start index) <b> (finish index) <k> (k-reductible) ");
            return;
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        System.out.print("a=");
        System.out.print(a);
        System.out.println();
        System.out.print("b=");
        System.out.print(b);
        System.out.println();
        System.out.print("k=");
        System.out.print(k);
        System.out.println();
        StringBuilder numbers = new StringBuilder("");
        for(int i = a; i<=b; i++){
            int result = multipliedSum(i);
            while(result > 9){
                result = multipliedSum(result);
            }
            if (result == k){
                numbers.append(i);
                numbers.append(" ");
            }
        }
        System.out.println(numbers);
        
        
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Running time (milliseconds): " + elapsedTime);

    }
    
}

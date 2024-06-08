/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package streams_examples.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author rebec
 */
public class Streams_examplesTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList();
        Integer reduced = numbers
                .stream()
                .reduce(10, (a, b) -> a + b);
        System.out.println("Sum of numbers: " + reduced);
        
        Person person1 = new Person("Alice");
        Person person2 = new Person("Bob");
        Person person3 = new Person("Charlie");
        Person person4 = new Person("Rebeca");

        // Add them to a list
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        // Convert the list to a comma-separated string
        String result = persons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Sample persons: " + result);
        
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your name:");
        String userName = myObj.nextLine(); // Read a line of text
        int age = myObj.nextInt();
        System.out.println("Hello, " + userName + "!");

    }
    
    List<Pet> pets = new ArrayList<>();
        Pet pet1 = new Pet("Azorel");
        pets.add(pet1);
        pets.add(new Pet("Azorel"));
        pets.add(new Pet("Azorel"));


}

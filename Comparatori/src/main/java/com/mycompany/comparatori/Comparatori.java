/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.comparatori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rebec
 */
public class Comparatori {

    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(17));
        pets.add(new Pet(5));
        pets.add(new Pet(34));
        
//        metoda 1
        List<Pet> sortedPets = pets.stream()
                .sorted(Comparator.comparing(Pet::getAge))
                .collect(Collectors.toList());
        
        System.out.println(sortedPets);
        
        Pet pet1 = new Pet(1);
        Pet pet2 = new Pet(10);
        Pet pet3 = new Pet(5);
        
        Pet[] pets2 = {pet1, pet2, pet3};
        
        Arrays.sort(pets2);
        System.out.println(pets2);
        
    }
}

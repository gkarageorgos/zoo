package com.unipi.postgraduate_JKarageorgos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)throws java.io.IOException, ClassNotFoundException{
        String[][] AnimalsArray = {{"Cougar", "Dolphin", "Elephant", "Giraffe", "Hippo", "Kangaroo", "Lion", "Monkey",
                "Tiger", "Zebra", "Marlin", "Piranha", "Stingray", "Shark", "BalaenicepsRex", "Parrot","Penguin","Upapa",
                "Crocodile", "Iguana", "KomodoDragon", "Snake"}, {"70", "150", "4000", "550", "1800", "50", "190", "12",
                "170", "200", "100", "2", "500", "700", "5", "4", "35", "1", "700", "9", "80", "100"},
                {"13", "60", "48", "30", "50", "18", "15", "15", "18", "20", "15", "20", "20", "30", "20", "60", "15",
                        "80", "70", "20", "50", "10"}};
        ArrayList<ZooAnimal> AnimalsArrayList = deserialize("animalsData.ser");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            ZooAnimal.setI(Integer.parseInt(reader.readLine()));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Display all zoo animals");
            System.out.println("2. Add new animal");
            System.out.println("3. Search by animal's name");
            System.out.println("4. Search by animal's ID");
            System.out.println("5. Delete by animal's ID");
            System.out.println("6. Animal feeding");
            System.out.println("7. Exit");
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                for (ZooAnimal animal : AnimalsArrayList)
                    System.out.println(animal);
            }
            else if (userInput == 2){
                System.out.println("The available animal's categories are:");
                for (int i = 0; i < AnimalsArray[0].length; i++)
                    System.out.println((i+1)+ ". " + AnimalsArray[0][i]);
                int choice = scanner.nextInt();
                if (choice < 11)
                    AnimalsArrayList.add(new ZooAnimal(AnimalsArray[0][choice - 1], Integer.parseInt(AnimalsArray[1][choice - 1]), Integer.parseInt(AnimalsArray[2][choice - 1]), "vertebrate", "mammal"));
                else if(choice < 15)
                    AnimalsArrayList.add(new ZooAnimal(AnimalsArray[0][choice - 1], Integer.parseInt(AnimalsArray[1][choice - 1]), Integer.parseInt(AnimalsArray[2][choice - 1]), "vertebrate", "fish"));
                else if(choice < 19)
                    AnimalsArrayList.add(new ZooAnimal(AnimalsArray[0][choice - 1], Integer.parseInt(AnimalsArray[1][choice - 1]), Integer.parseInt(AnimalsArray[2][choice - 1]), "vertebrate", "bird"));
                else if(choice < 23)
                    AnimalsArrayList.add(new ZooAnimal(AnimalsArray[0][choice - 1], Integer.parseInt(AnimalsArray[1][choice - 1]), Integer.parseInt(AnimalsArray[2][choice - 1]), "vertebrate", "reptile"));
                else
                    System.out.println("Please give a number between 0 and 23");
            }
            else if (userInput == 3){
                System.out.println("Please give name");
                String name = scanner.next();
                for (ZooAnimal animal : AnimalsArrayList){
                    if (name.equals(animal.getName()))
                        System.out.println(animal);
                }
            }
            else if (userInput == 4){
                System.out.println("Please give ID");
                String ID = scanner.next();
                for (ZooAnimal animal : AnimalsArrayList){
                    if (ID.equals(animal.getID())) {
                        System.out.println(animal);
                        break;
                    }
                }
            }
            else if (userInput == 5){
                System.out.println("Please give ID");
                String ID = scanner.next();
                for (ZooAnimal animal : AnimalsArrayList){
                    if (ID.equals(animal.getID())){
                        AnimalsArrayList.remove(animal);
                        break;
                    }
                }
            }
            else if (userInput == 6){
                for (ZooAnimal animal : AnimalsArrayList) {
                    animal.eating();
                }
            }
            else if (userInput == 7){
                serialize(AnimalsArrayList);
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
                    writer.write(Integer.toString(ZooAnimal.getI()));
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }
            else{
                System.out.println("Please give a number between 1 and 7");
            }
        }
    }
    static void serialize(ArrayList<ZooAnimal> animals){
        try {
            FileOutputStream fos = new FileOutputStream("animalsData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animals);
            oos.close();
            fos.close();
            System.out.println("List has been serialized");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static ArrayList<ZooAnimal> deserialize(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<ZooAnimal> animals = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            return animals;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

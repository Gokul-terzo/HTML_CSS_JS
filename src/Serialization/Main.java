package Serialization;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the house state:");
        System.out.println("Enter the number of chairs present:");
        int chairs=sc.nextInt();

        System.out.println("Enter the wall paint colour:");
        String wallColour=sc.next();
        System.out.println("Enter the sofa state(new/old):");
        String sofaState=sc.next();
        System.out.println("Enter TV Model:");
        String tvModel=sc.next();
        System.out.println("Number of window glass broken(if any):");
        int windowBroken=sc.nextInt();
        HomeState homeState=new HomeState(chairs,wallColour,sofaState,windowBroken,tvModel);

        FileOutputStream file=new FileOutputStream("homestate.txt");
        ObjectOutputStream out=new ObjectOutputStream(file);

        out.writeObject(homeState);
        out.close();
        file.close();


        System.out.println("Home state after deserialization:");
        FileInputStream file1=new FileInputStream("homestate.txt");
        ObjectInputStream in=new ObjectInputStream(file1);
        homeState=(HomeState)in.readObject();
        System.out.println(homeState);


    }
}

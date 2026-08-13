package org.example;

import java.util.Scanner;

public class Main{
    public static void main(String args[]){

        Activity activity = new Activity();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Diga o nome de usuario: ");
        String user = scanner.nextLine();
        System.out.println(); // pular uma linha
        activity.getActivity(user);
        activity.showActivity();
    }
}
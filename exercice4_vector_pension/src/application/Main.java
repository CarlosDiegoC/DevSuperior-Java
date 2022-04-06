package application;

import entites.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        Student[] studentsRooms = new Student[10];
        System.out.print("How many rooms will be rented? ");
        int numberOfRents = input.nextInt();
        for (int i = 0; i < numberOfRents; i++){
            System.out.println("Rent #" + i);
            System.out.print("Student name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Student email: ");
            String email = input.nextLine();
            System.out.print("Room: ");
            int roomChoosed = input.nextInt();
            studentsRooms[roomChoosed] = new Student(name, email);
        }
        System.out.println("Busy rooms:");
        for (int i = 0; i < studentsRooms.length; i++){
            if(studentsRooms[i] != null){
                System.out.printf("%d: %s, %s%n",i, studentsRooms[i].getName(), studentsRooms[i].getEmail());
            }
        }
    }
}

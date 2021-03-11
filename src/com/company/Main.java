package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input, input2;
        ArrayList<Member> members = new ArrayList<Member>();

        for(int i=0;;i++){
            Member one = new Member();
            System.out.println("Welcome to  XYZ Club. Add a New Member? (Y/N)");
            input = scan.nextLine();
            switch (input) {
                case "Y", "y":
                    System.out.println("Enter Name");
                    one.setName(scan.nextLine());
                    System.out.println("Enter Age");
                    one.setAge(one.ageValidate());
                    System.out.println("Enter gender(M/F)");
                    one.setGender(one.genderValidate());
                    System.out.println("Enter donation");
                    one.setDonation(one.donationValidate());
                    members.add(one);
                    System.out.println("Member added Succesfully");
                    break;
                case "N", "n":
                    System.out.println("Welcome to  XYZ Club. Display club member details? (Y/N)");
                    input2 = scan.nextLine();
                    if (input2.equals("Y") || input2.equals("y")) {
                        Iterator itr = members.iterator();
                        one.memberRuleList(itr);
                        one.memberShow();
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
    }
}

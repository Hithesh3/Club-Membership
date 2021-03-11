package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Member {
    private  String name,gender;
    private int age;
    private long donation;
    private boolean check;
    Scanner scan = new Scanner(System.in);
    ArrayList<Member> guest = new ArrayList<Member>();
    ArrayList<Member> platinum = new ArrayList<Member>();
    ArrayList<Member> premium = new ArrayList<Member>();
    ArrayList<Member> basic = new ArrayList<Member>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getDonation() {
        return donation;
    }

    public void setDonation(long donation) {
        this.donation = donation;
    }

    String genderValidate() {
        String g=null;
        check=false;
        while(!check) {
            String s=scan.nextLine();
            if (s.equals("M") || s.equals("m")) {
                g = "M";
                check=true;
            }
            else if(s.equals("F") || s.equals("f")){
                g="F";
                check=true;
            }
            else{
                System.out.println("Enter valid gender(M/F)");
            }
        }
        return g;
    }

    int ageValidate() {
        int input=0;
        check=false;
        while (!check) {
            try {
                input= Integer.parseInt(scan.nextLine());
                if (input <= 150) {
                    check = true;
                    return input;
                } else {
                    System.out.println("Enter valid Age");
                }
            }catch(Exception e){
                System.out.println("Enter valid age");
            }
        }
        return input;
    }

    long donationValidate() {
        long input=0;
        check=false;
        while (!check) {
            try {
                input= Long.parseLong(scan.nextLine());
                check = true;
                return input;
            }catch(Exception e){
                System.out.println("Enter valid donation");
            }
        }
        return input;
    }

    int memberRuleList(Iterator itr) {
        while (itr.hasNext()) {
            Member two = (Member) itr.next();
            if (two.age < 18) {
                guest.add(two);
            } else if (two.donation == 0 && two.gender.equals("M")) {
                guest.add(two);
            } else if (two.donation == 0 && two.gender.equals("F")) {
                premium.add(two);
            } else if (two.donation <= 1000) {
                basic.add(two);
            } else if (two.donation >= 1001 && two.donation <= 49999) {
                premium.add(two);
            } else if (two.donation >= 50000) {
                platinum.add(two);
            } else {
                System.out.println("no rule matched");
                return 0;
            }
        }
        return 0;
    }

    void memberShow() {
        Iterator itr1=guest.iterator();
        Iterator itr2=basic.iterator();
        Iterator itr3=premium.iterator();
        Iterator itr4=platinum.iterator();
        System.out.println("******XYZ Club******");
        System.out.print("Guest:");
        while(itr1.hasNext()){
            Member two=(Member) itr1.next();
            System.out.println(two.name);
        }
        System.out.print("\nBasic:");
        while(itr2.hasNext()){
            Member two=(Member) itr2.next();
            System.out.println(two.name);
        }
        System.out.print("\nPremium:");
        while(itr3.hasNext()){
            Member two=(Member) itr3.next();
            System.out.println(two.name);
        }
        System.out.print("\nPlatinum:");
        while(itr4.hasNext()){
            Member two=(Member) itr4.next();
            System.out.println(two.name);
        }
        System.out.println("\n");
    }
}

package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ir.ac.kntu.Calibre.FIVE;
import static ir.ac.kntu.Calibre.SEVEN;

public class Main {
    public static void main(String[] args) {
        List <Soldier> deadList=new ArrayList<>();
        List <Soldier> redTeam=new ArrayList<>();
        List <Soldier> orangeTeam=new ArrayList<>();
        Weapon s1=new Weapon.AssaultRifle(FIVE);
        Weapon s2=new Weapon.AssaultRifle(SEVEN);
        Weapon s3=new Weapon.SniperRifle(true,FIVE);
        Weapon s4=new Weapon.SniperRifle(false, FIVE);
        Weapon s5=new Weapon.SniperRifle(true,SEVEN);
        Weapon s6=new Weapon.SniperRifle(false, SEVEN);
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter the number of members of each team:");
        int numberOfMembers=scan.nextInt();
        scan.close();
        for(int i=0;i<numberOfMembers;i++){
            Soldier soldier=new Soldier(i+1);
            redTeam.add(soldier);
        }
        for(int i=0;i<numberOfMembers;i++){
            Soldier soldier=new Soldier(i+1);
            orangeTeam.add(soldier);
        }
    }
}

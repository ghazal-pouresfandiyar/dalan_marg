package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        List <Soldier> deadList=new ArrayList<>();
        List <Soldier> redTeam=new ArrayList<>();
        List <Soldier> orangeTeam=new ArrayList<>();
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
        int roundCounter=0;
        while(redTeam.size()==0 || orangeTeam.size()==0){
            System.out.println("############# Round "+roundCounter+"#############");
            for (int i=0;i<redTeam.size();i++){
                System.out.print("[R"+redTeam.get(i).getNumber()+"$"+redTeam.get(i).getLife()+"@"+redTeam.get(i).getWeapon().getName()+"@"+redTeam.get(i).getWeapon().getCaliber()+"]");
            }
            System.out.println();
            for (int i=0;i<orangeTeam.size();i++){
                System.out.print("[O"+orangeTeam.get(i).getNumber()+"$"+orangeTeam.get(i).getLife()+"@"+orangeTeam.get(i).getWeapon().getName()+"@"+orangeTeam.get(i).getWeapon().getCaliber()+"]");
            }
            System.out.println();
            System.out.println("Number of alive red soldiers:"+redTeam.size());
            System.out.println("Number of alive orange soldiers:"+orangeTeam.size());
            System.out.println("############# End Round "+roundCounter+"#############");
            roundCounter++;
        }
    }
}

package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        List <Soldier> deadList=new ArrayList<>();
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter the number of members of each team:");
        int numberOfMembers=scan.nextInt();
        scan.close();
        List <Soldier> redTeam=creatTeam(numberOfMembers);
        List <Soldier> orangeTeam=creatTeam(numberOfMembers);
        int roundCounter=0;
        while(redTeam.size()!=0 && orangeTeam.size()!=0){
            System.out.println("############# Round "+roundCounter+"#############");
            for (int i=0;i<redTeam.size();i++){
                System.out.print("[R"+redTeam.get(i).getNumber()+"$"+redTeam.get(i).getLife()+"@"+redTeam.get(i).getWeapon().getName()+"@"+redTeam.get(i).getWeapon().getCaliber()+"]");
            }
            System.out.println();
            for (int i=0;i<orangeTeam.size();i++){
                System.out.print("[O"+orangeTeam.get(i).getNumber()+"$"+orangeTeam.get(i).getLife()+"@"+orangeTeam.get(i).getWeapon().getName()+"@"+orangeTeam.get(i).getWeapon().getCaliber()+"]");
            }
            System.out.println();
            if(roundCounter>0){
                game(redTeam,orangeTeam,deadList);
            }
            System.out.println("Number of alive red soldiers for the next round:"+redTeam.size());
            System.out.println("Number of alive orange soldiers for the next round:"+orangeTeam.size());
            System.out.println("############# End Round "+roundCounter+"#############");
            roundCounter++;
        }
        System.out.println("________________________________________________________________");
        if(redTeam.size()==0){
            System.out.println("            The Orange team win the game!");
        }else{
            System.out.println("            The Red team win the game!");
        }
    }
    public static List<Soldier> creatTeam(int numberOfMembers){
        List <Soldier> team =new ArrayList<>();
        for(int i=0;i<numberOfMembers;i++){
            Soldier soldier=new Soldier(i+1);
            team.add(soldier);
        }
        return team;
    }
    public static void game(List<Soldier> redTeam,List<Soldier> orangeTeam,List<Soldier> deadList){
        boolean randomBoolean=RandomHelper.nextBoolean();
        if(randomBoolean==true) {    //red soldier will start
            fight(redTeam.get(0),orangeTeam.get(0));
            if(orangeTeam.get(0).getLife()>0){
                fight(orangeTeam.get(0),redTeam.get(0));
            }
            Soldier.shiftSoldiers(orangeTeam,orangeTeam.get(0),deadList);
            Soldier.shiftSoldiers(redTeam,redTeam.get(0),deadList);
        }else { // orange soldier will start
            fight(orangeTeam.get(0),redTeam.get(0));
            if(redTeam.get(0).getLife()>0){
                fight(redTeam.get(0),orangeTeam.get(0));
            }
            Soldier.shiftSoldiers(redTeam,redTeam.get(0),deadList);
            Soldier.shiftSoldiers(orangeTeam,orangeTeam.get(0),deadList);
        }
    }
    public static void fight(Soldier first,Soldier second){
        int percent=RandomHelper.nextInt(101);
        if(percent<=first.getWeapon().getAccuracyRate()){
            second.setLife(second.getLife()-first.getWeapon().getDamageRate());
        }
    }
}

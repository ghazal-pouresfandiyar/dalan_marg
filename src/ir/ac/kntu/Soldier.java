package ir.ac.kntu;

import java.util.List;

public class Soldier {
    private int life=100;
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public Soldier(int number) {
        this.number = number;
    }

    public static void shiftSoldiers(List<Soldier> soldierList, Soldier soldier, List<Soldier> deadList){
        if(soldier.life>0) {//the soldier is still alive
            Soldier temp = soldierList.get(0);
            for (int i = 0; i < soldierList.size() - 1; i++) {
                soldierList.set(i, soldierList.get(i + 1));
            }
            soldierList.set(soldierList.size(),temp);
        }
        else{
            deadList.add(soldier);
            for (int i = 0; i < soldierList.size() - 1; i++) {
                soldierList.set(i, soldierList.get(i + 1));
            }
        }
    }
}

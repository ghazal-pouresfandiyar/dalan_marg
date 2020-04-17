package ir.ac.kntu;

import java.util.List;

import static ir.ac.kntu.Caliber.CALIBER5MM;
import static ir.ac.kntu.Caliber.CALIBER7MM;

public class Soldier {
    private int life=100;
    private int number;
    private Weapon weapon;
    public Soldier(int number) {
        this.number = number;
        int kindOfWeapon=RandomHelper.nextInt()%6;
        switch (kindOfWeapon){
            case 0:
                this.weapon=new Weapon.AssaultRifle(CALIBER5MM);
                break;
            case 1:
                this.weapon=new Weapon.AssaultRifle(CALIBER7MM);
            case 2:
                this.weapon=new Weapon.SniperRifle(true,CALIBER5MM);
                break;
            case 3:
                this.weapon=new Weapon.SniperRifle(false, CALIBER5MM);
                break;
            case 4:
                this.weapon=new Weapon.SniperRifle(true,CALIBER7MM);
                break;
            case 5:
                this.weapon=new Weapon.SniperRifle(false, CALIBER7MM);
                break;
        }
    }

    public int getLife() {
        return life;
    }

    public int getNumber() {
        return number;
    }

    public Weapon getWeapon() {
        return weapon;
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
            soldierList.remove(soldier);
            for (int i = 0; i < soldierList.size() - 1; i++) {
                soldierList.set(i, soldierList.get(i + 1));
            }
        }
    }
}

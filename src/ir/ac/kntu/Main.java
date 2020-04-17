package ir.ac.kntu;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Soldier> deadList=new ArrayList<>();
        List <Soldier> firstTeam=new ArrayList<>();
        List <Soldier> secondTeam=new ArrayList<>();
        Weapon AssaultRifle=new Weapon(0.5,10);
        Weapon SniperRifle=new Weapon(0.6,20);
        Weapon SniperRifleWithZoom=new Weapon(0.6,20,true);
    }
}

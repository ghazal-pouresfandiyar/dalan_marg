package ir.ac.kntu;

public class Weapon {
    private double accuracyRate;
    private double faultRate;  //1-accuracyRate;
    private int damageRate;
    private boolean zoomOn;

    class AssaultRifle extends Weapon{

    }
    class SniperRifle extends Weapon{

    }
    
//    }double accuracyRate,int damageRate){
//        this.accuracyRate=accuracyRate;
//        this.faultRate=1-accuracyRate;
//        this.damageRate=damageRate;
//    }
//    class Weapon(double accuracyRate,int damageRate,boolean zoom){
//        this.damageRate=damageRate;
//        int zoomRate = (RandomHelper.nextInt()%11)+5;
//        this.accuracyRate = accuracyRate + (accuracyRate * (zoomRate / 100));
//        this.faultRate=1-accuracyRate;
//    }
}

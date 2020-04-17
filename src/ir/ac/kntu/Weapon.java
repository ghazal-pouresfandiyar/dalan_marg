package ir.ac.kntu;

public class Weapon {
    private double accuracyRate;
    private double faultRate;  //1-accuracyRate;
    private int damageRate;
    static class AssaultRifle extends Weapon{
        public AssaultRifle(Calibre calibre) {
            super.damageRate = 10;
            super.accuracyRate = 0.5;
            if(calibre==Calibre.FIVE){
                super.accuracyRate= (super.accuracyRate) + (super.accuracyRate*(15/100));
            } else if(calibre==Calibre.SEVEN){
                super.accuracyRate= (super.accuracyRate) - (super.accuracyRate*(10/100));
                super.damageRate=super.damageRate + 10;
            } else{
                System.out.println("The calibre is not valid.");
            }

            super.faultRate = 1 - super.accuracyRate;
        }
    }

    static class SniperRifle extends Weapon{
        public SniperRifle(boolean zoom,Calibre calibre){
            super.damageRate = 20;
            super.accuracyRate = 0.6;

            if(zoom==true) {
                int zoomRate = (RandomHelper.nextInt() % 11) + 5;
                super.accuracyRate = super.accuracyRate + (super.accuracyRate * (zoomRate / 100));
            }

            if(calibre==Calibre.FIVE){
                super.accuracyRate= super.accuracyRate + (super.accuracyRate*(15/100));
            }else if(calibre==Calibre.SEVEN){
                super.accuracyRate= (super.accuracyRate) - (super.accuracyRate*(10/100));
                super.damageRate=super.damageRate + 10;
            }else{
                System.out.println("The calibre is not valid.");
            }

            super.faultRate = 1 - super.accuracyRate;
        }
    }
}

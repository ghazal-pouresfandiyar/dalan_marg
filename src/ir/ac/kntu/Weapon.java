package ir.ac.kntu;

public class Weapon {
    private String name;
    private double accuracyRate;
    private double faultRate;  //1-accuracyRate;
    private int damageRate;
    private Caliber caliber;
    public String getName() {
        return name;
    }

    public Caliber getCaliber() {
        return caliber;
    }

    static class AssaultRifle extends Weapon{
        public AssaultRifle(Caliber caliber) {
            super.name="AssaultRifle";
            super.caliber=caliber;
            super.damageRate = 10;
            super.accuracyRate = 0.5;
            if(caliber==Caliber.CALIBER5MM){
                super.accuracyRate= (super.accuracyRate) + (super.accuracyRate*(15/100));
            } else if(caliber==Caliber.CALIBER7MM){
                super.accuracyRate= (super.accuracyRate) - (super.accuracyRate*(10/100));
                super.damageRate=super.damageRate + 10;
            } else{
                System.out.println("The caliber is not valid.");
            }

            super.faultRate = 1 - super.accuracyRate;
        }
    }

    static class SniperRifle extends Weapon{
        public SniperRifle(boolean zoom,Caliber caliber){
            super.name="SniperRifle";
            super.caliber=caliber;
            super.damageRate = 20;
            super.accuracyRate = 0.6;

            if(zoom==true) {
                int zoomRate = (RandomHelper.nextInt() % 11) + 5;
                super.accuracyRate = super.accuracyRate + (super.accuracyRate * (zoomRate / 100));
            }

            if(caliber==Caliber.CALIBER5MM){
                super.accuracyRate= super.accuracyRate + (super.accuracyRate*(15/100));
            }else if(caliber==Caliber.CALIBER7MM){
                super.accuracyRate= (super.accuracyRate) - (super.accuracyRate*(10/100));
                super.damageRate=super.damageRate + 10;
            }else{
                System.out.println("The caliber is not valid.");
            }

            super.faultRate = 1 - super.accuracyRate;
        }
    }
}

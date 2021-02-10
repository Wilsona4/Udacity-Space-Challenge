import java.util.Random;

public class U2 extends Rocket {

    public U2() {
        cost = 120;
        rocketWeight = 18000;
        maxWeight = 29000;
        cargoLimit = 11000;
    }

    @Override
    public boolean launch() {
        double launchExplosion = 0.04*(getCurrentCargoWeight()/getCargoLimit());
        Random random = new Random();
        double crashAbility = random.nextDouble();
        return crashAbility >= launchExplosion;
    }

    @Override
    public boolean land() {
        double landExplosion = 0.08*(getCurrentCargoWeight()/getCargoLimit());
        Random random = new Random();
        double crashAbility = random.nextDouble();
        return crashAbility >= landExplosion;
    }

}

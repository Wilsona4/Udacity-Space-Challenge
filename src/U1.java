import java.util.Random;

public class U1 extends Rocket {

    public U1() {
        cost = 100;
        rocketWeight = 10000;
        maxWeight = 18000;
        cargoLimit = 8000;
    }

    @Override
    public boolean launch() {
        double launchExplosion = 0.05*(getCurrentCargoWeight()/getCargoLimit());
        Random random = new Random();
        double crashAbility = random.nextDouble();
        return crashAbility >= launchExplosion;
    }

    @Override
    public boolean land() {
        double landExplosion = 0.01*(getCurrentCargoWeight()/getCargoLimit());
        Random random = new Random();
        double crashAbility = random.nextDouble();
        return crashAbility >= landExplosion;
    }
}

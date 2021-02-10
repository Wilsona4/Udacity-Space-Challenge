public class Rocket implements SpaceShip {

    public int cost;
    public double rocketWeight;
    public double currentCargoWeight;
    public double maxWeight;
    public double cargoLimit;


    public Rocket() {
        this.currentCargoWeight = 0;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public final boolean canCarry(Item item) {
//        Check this out, in respect to the currentCargoWeight;
        return getCargoLimit() >= getCurrentCargoWeight() + item.getWeight();
    }

    @Override
    public final void carry(Item item) {
        this.currentCargoWeight = getCurrentCargoWeight() + item.getWeight();
    }

    public int getCost() {
        return cost;
    }

    public double getRocketWeight() {
        return rocketWeight;
    }

    public double getCurrentCargoWeight() {
        return currentCargoWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getCargoLimit() {
        return cargoLimit;
    }
}

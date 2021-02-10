import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList loadItems(String fileName) {
        ArrayList<Item> itemArrayList = new ArrayList<>();

        File file = new File("C:\\Users\\Sophia\\Documents\\Decagon\\Android Dev\\W1\\" + fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (line.contains("=")) {
                    String[] lineArr = line.split("=", 2);
                    String name = lineArr[0];
                    int weight = Integer.parseInt(lineArr[1]);
                    Item item = new Item(name, weight);
                    itemArrayList.add(item);
                } else {
                    throw new IllegalArgumentException("String " + line + " does not contain '='");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return itemArrayList;
    }

    public ArrayList loadU1(ArrayList<Item> itemArrayList) {
        ArrayList<Rocket> u1ArrayList = new ArrayList<>();

        int i = 0;
        while (i < itemArrayList.size()) {
//        for (int i = 0; i < itemArrayList.size(); i++){
            U1 u1 = new U1();
            while (u1.getCurrentCargoWeight() <= u1.getCargoLimit()) {
                if (u1.canCarry(itemArrayList.get(i))) {
                    u1.carry(itemArrayList.get(i));
                    i++;
                    if (i >= itemArrayList.size()) {
                        u1ArrayList.add(u1);
                        break;
                    }
                } else {
                    u1ArrayList.add(u1);
                    break;
                }
            }

        }
        return u1ArrayList;
    }

    public ArrayList loadU2(ArrayList<Item> itemArrayList) {
        ArrayList<Rocket> u2ArrayList = new ArrayList<>();

        int i = 0;
        while (i < itemArrayList.size()) {
//        for (int i = 0; i < itemArrayList.size(); i++){
            U2 u2 = new U2();
            while (u2.getCurrentCargoWeight() <= u2.getCargoLimit()) {
                if (u2.canCarry(itemArrayList.get(i))) {
                    u2.carry(itemArrayList.get(i));
                    i++;
                    if (i >= itemArrayList.size()) {
                        u2ArrayList.add(u2);
                        break;
                    }
                } else {
                    u2ArrayList.add(u2);
                    break;
                }
            }
        }
        return u2ArrayList;
    }

    public int runSimulation(ArrayList<Rocket> rocketArrayList) {
        Rocket rocket = new Rocket();
        int totalBudget;

//        int i = 0;
//        while (i < rocketArrayList.size()) {
        for (int i = 0; i < rocketArrayList.size(); i++) {
            rocket = rocketArrayList.get(i);
            if (rocket.launch()) {
                System.out.println("Rocket Launched Successfully");
                {
                    if (rocket.land()) {
                        System.out.println("Rocket Launched and Landed Successfully");
                        break;
                    } else {
                        System.out.println("Rocket Launched Successfully but crashed while Landing");
                        rocketArrayList.add(rocket);
                    }
                }
            } else {
                System.out.println("Rocket Launched crashed while Launching");
                rocketArrayList.add(rocket);
            }
//            i++;
        }
        totalBudget = rocket.getCost() * rocketArrayList.size();
        return totalBudget;
    }
}

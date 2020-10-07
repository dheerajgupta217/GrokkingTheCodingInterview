package business;

import interfaces.HotDrink;

public class Tea implements HotDrink {
    @Override
    public void prepareHotDrink() {
        System.out.println("Preparing Tea");
        System.out.println("Adding Spices");
    }
}

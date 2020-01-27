package business;

import interfaces.HotDrink;

public class ExpressTea implements HotDrink {
    @Override
    public void prepareHotDrink() {
        System.out.println("preparing Express Tea");
    }
}

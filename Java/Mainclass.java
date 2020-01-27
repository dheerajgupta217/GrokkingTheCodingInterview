package business;

import interfaces.HotDrink;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainclass {
    public static void main(String[] args) {
   ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tea_bean.xml");
        Restaurant restaurant = applicationContext.getBean("restaurant3",Restaurant.class);
        System.out.println(restaurant.getHotDrink());
        HotDrink hotDrink= restaurant.getHotDrink();
        hotDrink.prepareHotDrink();

    }
}

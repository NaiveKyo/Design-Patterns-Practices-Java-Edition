package io.naivekyo.creational.Builder.product;

import io.naivekyo.creational.Builder.item.Drink;
import io.naivekyo.creational.Builder.item.MainItem;

/**
 * ChildrenMeal 就是最终的成果
 */
public class ChildrenMeal {
    
    private MainItem main;
    
    private Drink drink;
    
    public void desc() {
        System.out.printf("children meal: [%s, %s]%n", this.main.getName(), this.drink.getName());
    }

    public MainItem getMain() {
        return main;
    }

    public void setMain(MainItem main) {
        this.main = main;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}

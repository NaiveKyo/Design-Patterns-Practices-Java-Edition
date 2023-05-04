package io.naivekyo.creational.Builder.builder.impl;

import io.naivekyo.creational.Builder.builder.ChildrenMealBuilder;
import io.naivekyo.creational.Builder.item.Drink;
import io.naivekyo.creational.Builder.item.MainItem;
import io.naivekyo.creational.Builder.product.ChildrenMeal;

/**
 * 简单套餐 Builder
 */
public class SimpleMealBuilder implements ChildrenMealBuilder {
    
    private ChildrenMeal meal;

    public SimpleMealBuilder() {
        this.meal = new ChildrenMeal();
    }

    @Override
    public ChildrenMealBuilder setMainItem(MainItem main) {
        this.meal.setMain(main);
        return this;
    }

    @Override
    public ChildrenMealBuilder setDrink(Drink drink) {
        this.meal.setDrink(drink);
        return this;
    }

    @Override
    public ChildrenMeal getMeal() {
        return this.meal;
    }
    
}

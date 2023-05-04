package io.naivekyo.creational.Builder.builder;

import io.naivekyo.creational.Builder.item.Drink;
import io.naivekyo.creational.Builder.item.MainItem;
import io.naivekyo.creational.Builder.product.ChildrenMeal;

/**
 * 儿童套餐的通用制作步骤 <br/>
 * 这里为了做简单的演示, 在套餐中只定义了两种食物。
 */
public interface ChildrenMealBuilder {
    
    ChildrenMealBuilder setMainItem(MainItem main);
    
    ChildrenMealBuilder setDrink(Drink drink);
    
    ChildrenMeal getMeal();
    
}

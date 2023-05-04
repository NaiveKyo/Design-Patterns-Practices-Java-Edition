package io.naivekyo.creational.Builder;

import io.naivekyo.creational.Builder.builder.ChildrenMealBuilder;
import io.naivekyo.creational.Builder.builder.impl.SimpleMealBuilder;
import io.naivekyo.creational.Builder.director.Director;
import io.naivekyo.creational.Builder.item.impl.SimpleDrink;
import io.naivekyo.creational.Builder.item.impl.SpecialMainItem;
import io.naivekyo.creational.Builder.product.ChildrenMeal;

public class BuildTestClient {
    public static void main(String[] args) {
        Director director = new Director();
        
        // 使用 Director 组装 SimpleMealBuilder
        ChildrenMealBuilder builder1 = new SimpleMealBuilder();
        director.instructMakeSimpleMeal(builder1);
        ChildrenMeal simpleMeal = builder1.getMeal();
        
        simpleMeal.desc();
        
        // 使用 Director 组装 SpecialMealBuilder
        ChildrenMealBuilder builder2 = new SimpleMealBuilder();
        director.instructMakeSpecialMeal(builder2);
        ChildrenMeal specialMeal = builder2.getMeal();
        
        specialMeal.desc();
        
        // 直接使用 Builder 根据需要组装套餐
        SimpleMealBuilder builder3 = new SimpleMealBuilder();
        builder3.setMainItem(new SpecialMainItem())
                .setDrink(new SimpleDrink());
        ChildrenMeal customizedMeal = builder3.getMeal();
        
        customizedMeal.desc();
    }
}

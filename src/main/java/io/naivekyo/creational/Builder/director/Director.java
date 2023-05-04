package io.naivekyo.creational.Builder.director;

import io.naivekyo.creational.Builder.builder.ChildrenMealBuilder;
import io.naivekyo.creational.Builder.item.impl.SimpleDrink;
import io.naivekyo.creational.Builder.item.impl.SimpleMainItem;
import io.naivekyo.creational.Builder.item.impl.SpecialDrink;
import io.naivekyo.creational.Builder.item.impl.SpecialMainItem;

/**
 * Director 中封装了一些常用的构造复杂对象的模板, 注意 Director 不是必须的 <br/>
 * 如果需要高度定制化, Client 可以直接调用对应的 Builder 来构建自己需要的产品
 */
public class Director {

    /**
     * 制作 simple 套餐
     * @param builder
     */
    public void instructMakeSimpleMeal(ChildrenMealBuilder builder) {
        builder.setMainItem(new SimpleMainItem())
                .setDrink(new SimpleDrink());
    }

    /**
     * 制作 special 套餐
     * @param builder
     */
    public void instructMakeSpecialMeal(ChildrenMealBuilder builder) {
        builder.setMainItem(new SpecialMainItem())
                .setDrink(new SpecialDrink());
    }
}

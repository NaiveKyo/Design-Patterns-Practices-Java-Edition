package io.naivekyo.structural.Composite.component;

import java.util.ArrayList;
import java.util.List;

/**
 * 学院属于 Composite, 可以拥有多个 Leaf 或其他 Composite
 */
public class Academy implements Introduce {
    
    private String name;
    
    private List<Introduce> majors;

    public Academy(String name) {
        this.name = name;
        this.majors = new ArrayList<>();
    }

    public Academy(String name, List<Introduce> majors) {
        this.name = name;
        this.majors = majors;
    }

    @Override
    public void add(Introduce component) {
        this.majors.add(component);
    }
    
    @Override
    public boolean remove(Introduce component) {
        return this.majors.remove(component);
    }

    @Override
    public int total() {
        return this.majors.stream().mapToInt(Introduce::total).sum();
    }

    @Override
    public void intro() {
        System.out.printf("******** %s 总人数: %d *********%n", this.name, this.total());
        this.majors.forEach(Introduce::intro);
    }
    
}

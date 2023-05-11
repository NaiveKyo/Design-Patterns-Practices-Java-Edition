package io.naivekyo.structural.Composite.component;

import java.util.ArrayList;
import java.util.List;

/**
 * 学校是一个 Composite, 包含多个 Leaf 或其他 Composite
 */
public class College implements Introduce {
    
    private String name;
    
    private List<Introduce> academies;

    public College(String name) {
        this.name = name;
        this.academies = new ArrayList<>();
    }

    public College(String name, List<Introduce> academies) {
        this.name = name;
        this.academies = academies;
    }
    
    @Override
    public void add(Introduce component) {
        this.academies.add(component);
    }

    @Override
    public boolean remove(Introduce component) {
        return this.academies.remove(component);
    }

    @Override
    public int total() {
        return this.academies.stream().mapToInt(Introduce::total).sum();
    }

    @Override
    public void intro() {
        System.out.printf("====================== %s 总人数: %d =====================%n", this.name, this.total());
        this.academies.forEach(Introduce::intro);
    }
    
}

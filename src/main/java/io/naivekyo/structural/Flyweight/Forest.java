package io.naivekyo.structural.Flyweight;

import io.naivekyo.structural.Flyweight.context.Tree;
import io.naivekyo.structural.Flyweight.factory.TreeFactory;
import io.naivekyo.structural.Flyweight.flyweight.TreeType;

import java.util.ArrayList;
import java.util.List;

/**
 * Client: 在本例中 Tree 和 Forest 类都是享元的客户端
 */
public class Forest {
    
    private List<Tree> trees;

    public Forest() {
        this.trees = new ArrayList<>();
    }

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        this.trees.add(tree);
    }
    
    public void draw(Object canvas) {
        this.trees.forEach(t -> t.draw(canvas));
    }
    
    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree(1, 1, "type1", "red", "aaa");
        forest.plantTree(2, 2, "type2", "yellow", "bbb");
        forest.plantTree(3, 3, "type3", "green", "ccc");

        forest.plantTree(4, 4, "type2", "yellow", "bbb");
        
        forest.draw(new Object());
        
        // insight into flyweight cached pool
        TreeFactory.getFlyweight().forEach(System.out::println);
    }
}

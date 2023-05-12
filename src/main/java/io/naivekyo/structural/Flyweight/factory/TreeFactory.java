package io.naivekyo.structural.Flyweight.factory;

import io.naivekyo.structural.Flyweight.flyweight.TreeType;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 享元工厂: 复用或创建一个新的享元
 */
public class TreeFactory {
    
    private static List<TreeType> flyweight = new CopyOnWriteArrayList<>();
    
    public static TreeType getTreeType(String type, String color, String texture) {
        TreeType find = flyweight.stream().filter(tree ->
                // do search ...
                type.equals(tree.getType())
                        && color.equals(tree.getColor())
                        && texture.equals(tree.getTexture())).findFirst().orElse(null);
        
        if (find == null) {
            // concurrency support
            TreeType treeType = new TreeType(type, color, texture);
            flyweight.add(treeType);
            return treeType;
        } else 
            return find;
    }

    /**
     * 获取享元缓存池, 测试使用
     * @return 缓存池
     */
    public static List<TreeType> getFlyweight() {
        return flyweight;
    }
}

package io.naivekyo.structural.Flyweight.context;

import io.naivekyo.structural.Flyweight.flyweight.TreeType;

/**
 * 情景类: 包含原始树对象的外在状态以及一个对享元对象的引用 <br/>
 * 程序中可以创建无限量的情景对象, 因为它们占用内存空间很小
 */
public class Tree {

    /**
     * x-axis
     */
    private int x;

    /**
     * y-axis
     */
    private int y;

    /**
     * 包含内部状态的享元对象的引用
     */
    private TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw(Object canvas) {
        this.treeType.draw(canvas, this.x, this.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TreeType getTreeType() {
        return treeType;
    }

    public void setTreeType(TreeType treeType) {
        this.treeType = treeType;
    }
}

package io.naivekyo.structural.Composite.component;

/**
 * 专业属于 Leaf, 是树状结构的最底层, 是工作的实际执行者
 */
public class Major implements Introduce {
    
    private int studentNumber;
    
    private String name;

    public Major(int studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    @Override
    public int total() {
        return this.studentNumber;
    }

    @Override
    public void intro() {
        System.out.println(this.name + " 总人数: " + this.total());
    }

    @Override
    public void add(Introduce component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Introduce component) {
        throw new UnsupportedOperationException();
    }

}

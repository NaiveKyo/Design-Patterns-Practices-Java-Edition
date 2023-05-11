package io.naivekyo.structural.Composite.component;

/**
 * 定义所有组件的通用行为
 */
public interface Introduce {

    /**
     * 获得总数量
     * @return
     */
    int total();

    /**
     * 打印相关信息
     * @return
     */
    void intro();
    
    void add(Introduce component);
    
    boolean remove(Introduce component);
    
}

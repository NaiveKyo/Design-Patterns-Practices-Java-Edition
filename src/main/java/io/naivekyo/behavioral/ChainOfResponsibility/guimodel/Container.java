package io.naivekyo.behavioral.ChainOfResponsibility.guimodel;

import java.util.List;

/**
 * 容器可以将简单组件或者其他容器作为子项目. 链关系将在这里建立, 且该类从父类继承 showHelp 行为
 */
public abstract class Container extends Component {
    
    protected List<Component> children;
    
    public void add(Component child) {
        this.children.add(child);
        child.container = this;
    }
    
}

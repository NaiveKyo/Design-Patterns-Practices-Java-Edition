package io.naivekyo.behavioral.Mediator.components;

import io.naivekyo.behavioral.Mediator.mediator.Mediator;

/**
 * 公共的组件接口
 */
public interface Component {
    
    void setMediator(Mediator mediator);
    
    String getName();
    
}

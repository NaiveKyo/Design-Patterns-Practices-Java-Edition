package io.naivekyo.creational.FactoryMethod.ui.factory;

import io.naivekyo.creational.FactoryMethod.ui.product.Button;

public abstract class Dialog {

    /**
     * 通常 Creator 的职责不仅仅是创建产品, 同时还包括核心业务逻辑, 这些业务逻辑依赖于具体的产品
     */
    public void render() {
        // 调用此方法渲染出一个 Dialog, 假设此对话框中存在一个按钮用于关闭该 Dialog
        Button button = this.createButton();
        // 假设点击按钮就会关闭对话框, 此处应传入点击事件回调
        button.onClick();
        button.render();
    }
    
    public abstract Button createButton();
    
}

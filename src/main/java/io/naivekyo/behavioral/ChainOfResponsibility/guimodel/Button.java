package io.naivekyo.behavioral.ChainOfResponsibility.guimodel;

/**
 * 普通按钮组件可以使用帮助操作的默认实现
 */
public class Button extends Component {
    
    private int x, y, width, height;
    
    private String text;

    public Button(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }
    
}

package io.naivekyo.behavioral.ChainOfResponsibility.guimodel;

/**
 * 复杂组件有可能会重写默认实现, 但是如果无法以新的方式来提供帮助文字, 那么组件总是还能调用基础实现
 */
public class Panel extends Container {
    
    private String modalHelpText;
    
    private int x, y, width, height;

    public Panel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setModalHelpText(String modalHelpText) {
        this.modalHelpText = modalHelpText;
    }

    @Override
    public void showHelp() {
        if (this.modalHelpText != null && !"".equals(this.modalHelpText)) {
            // 显示包含帮助文字的模态窗口
            System.out.println("modal help text: " + this.modalHelpText);
        } else 
            super.showHelp();
    }
}

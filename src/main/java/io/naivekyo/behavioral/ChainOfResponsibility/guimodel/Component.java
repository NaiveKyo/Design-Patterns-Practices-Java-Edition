package io.naivekyo.behavioral.ChainOfResponsibility.guimodel;

public abstract class Component implements ComponentWithContextualHelp {
    
    private String tooltipText;

    /**
     * 组件容器作为处理者链中的下一个处理者
     */
    protected Container container;

    public void setTooltipText(String tooltipText) {
        this.tooltipText = tooltipText;
    }

    /**
     * 如果当前组件设置了帮助文字, 那它将直接显示提示文字; 如果当前组件没有提示文字, 并且其父容器是存在的, 就将请求传递给其容器
     */
    @Override
    public void showHelp() {
        if (this.tooltipText != null && !"".equals(this.tooltipText)) {
            // 显示提示信息
            System.out.println(this.tooltipText);
        } else {
            if (this.container != null)
                this.container.showHelp();
        }
    }
}

package io.naivekyo.behavioral.ChainOfResponsibility.guimodel;

public class GUIApplicationTestClient {
    
    public void createUI() {
        Dialog dialog = new Dialog("测试对话框");
        dialog.setWikiPageURL("http://......");

        Panel panel = new Panel(0, 0, 400, 800);
        panel.setModalHelpText("本面板用于......");

        Button ok = new Button(250, 760, 50, 20, "确认");
        ok.setTooltipText("这是一个确认按钮...");

        Button cancel = new Button(320, 760, 50, 20, "取消");
        cancel.setTooltipText("这是一个取消按钮...");
        
        panel.add(ok);
        panel.add(cancel);
        
        dialog.add(panel);
    }

    /**
     * 模拟在某个界面元素上按下键盘 F1 键造成的回调
     */
    public void onF1KeyPress() {
        Component component = this.getComponentAtMouseCoords();
        component.showHelp();
    }

    public Component getComponentAtMouseCoords() {
        // do something
        return null;
    }

}

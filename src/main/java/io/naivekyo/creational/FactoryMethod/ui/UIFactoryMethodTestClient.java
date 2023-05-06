package io.naivekyo.creational.FactoryMethod.ui;

import io.naivekyo.creational.FactoryMethod.ui.factory.Dialog;
import io.naivekyo.creational.FactoryMethod.ui.factory.WebDialog;
import io.naivekyo.creational.FactoryMethod.ui.factory.WindowsDialog;

public class UIFactoryMethodTestClient {
    
    private static Dialog dialog;
    
    public static void main(String[] args) {
        String osType = "";
        
        if ("windows".equals(osType)) {
            dialog = new WindowsDialog();
        } else if ("web".equals(osType)) {
            dialog = new WebDialog();
        } else {
            // handle error
        }
        
        dialog.render();
    }
}

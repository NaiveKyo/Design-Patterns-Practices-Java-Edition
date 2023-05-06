package io.naivekyo.creational.FactoryMethod.ui.factory;

import io.naivekyo.creational.FactoryMethod.ui.product.Button;
import io.naivekyo.creational.FactoryMethod.ui.product.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

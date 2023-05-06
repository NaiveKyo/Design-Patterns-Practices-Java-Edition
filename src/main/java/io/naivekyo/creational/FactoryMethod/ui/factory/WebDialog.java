package io.naivekyo.creational.FactoryMethod.ui.factory;

import io.naivekyo.creational.FactoryMethod.ui.product.Button;
import io.naivekyo.creational.FactoryMethod.ui.product.HTMLButton;

public class WebDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}

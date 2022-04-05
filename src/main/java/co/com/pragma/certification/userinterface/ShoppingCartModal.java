package co.com.pragma.certification.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartModal extends PageObject {
    public static final Target MESSAGE_LABEL = Target.the("mensaje de la modal del carrito de compras").
            located(By.cssSelector(".layer_cart_product > h2"));
}

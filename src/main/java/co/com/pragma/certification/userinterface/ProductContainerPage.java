package co.com.pragma.certification.userinterface;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductContainerPage extends PageObject {
    public static final By PRODUCT_DIV = By.className("product-container");
    public static final By QUICK_VIEW_BUTTON = By.className("quick-view");
    public static final By ADD_TO_CART_BUTTON = By.className("ajax_add_to_cart_button");
    public static final By MORE_BUTTON = By.className("lnk_view");
}

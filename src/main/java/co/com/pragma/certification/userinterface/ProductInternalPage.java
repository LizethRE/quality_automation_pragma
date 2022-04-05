package co.com.pragma.certification.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductInternalPage extends PageObject {
    public static final By FRAME = By.cssSelector(".fancybox-iframe");
    public static final Target BREAD_CRUMB = Target.the("miga de pan").
            located(By.className("breadcrumb"));
    public static final Target QUANTITY_INPUT = Target.the("cantidad de productos").
            located(By.id("quantity_wanted"));
    public static final Target SIZE_SELECT = Target.the("talla del producto").
            located(By.id("group_1"));
    public static Target COLOR_CHECKBOX(String value){
        return Target.the("color " + value).
                located(By.name(value));
    }
    public static final Target ADD_TO_CART_BUTTON = Target.the("añadir al carrito de compras").
            located(By.id("add_to_cart"));
}

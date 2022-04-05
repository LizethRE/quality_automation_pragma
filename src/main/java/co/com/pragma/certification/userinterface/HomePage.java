package co.com.pragma.certification.userinterface;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {
    public static final Target SIGN_IN_URL = Target.the("opción del menú iniciar sesión").
            located(By.cssSelector(".login"));
    public static final Target CATEGORYS_TAB = Target.the("tabs de categorías").
            located(By.id("home-page-tabs"));

    @FindBy(className = "tab-content")
    public static List<WebElementFacade> PRODUCTS_TAB;

    public static final Target LOADER = Target.the("cargando contenido").
            located(By.id("fancybox-loading"));
}

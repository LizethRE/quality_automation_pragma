package co.com.pragma.certification.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:contact.us.page")
public class AccountHomePage extends PageObject {
    public static final Target USERNAME_LABEL = Target.the("nombre completo del usuario").
            located(By.cssSelector(".account"));
}

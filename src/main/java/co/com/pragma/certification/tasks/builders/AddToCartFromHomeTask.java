package co.com.pragma.certification.tasks.builders;

import co.com.pragma.certification.models.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static co.com.pragma.certification.userinterface.HomePage.CATEGORYS_TAB;
import static co.com.pragma.certification.userinterface.HomePage.PRODUCTS_TAB;
import static co.com.pragma.certification.userinterface.ProductContainerPage.ADD_TO_CART_BUTTON;
import static co.com.pragma.certification.userinterface.ProductContainerPage.PRODUCT_DIV;


public class AddToCartFromHomeTask implements Task {
    private Product product;

    public AddToCartFromHomeTask(Product product) {
        this.product = product;
    }

    public static AddToCartFromHomeBuilder with() {
        return new AddToCartFromHomeBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> products = PRODUCTS_TAB.get(0).thenFindAll(PRODUCT_DIV);

        actor.attemptsTo(Scroll.to(CATEGORYS_TAB).andAlignToTop());

        for (WebElementFacade item:products) {
            if (item.getText().contains(product.getName())){
                actor.attemptsTo(MoveMouse.to(item));

                WebElementFacade addToCartButton = item.find(ADD_TO_CART_BUTTON);
                actor.attemptsTo(Click.on(addToCartButton));
                break;
            }
        }
    }

    public static class AddToCartFromHomeBuilder{
        public AddToCartFromHomeTask name(String name){
            return new AddToCartFromHomeTask(
                    Product.builder()
                            .name(name)
                            .build()
            );
        }
    }
}

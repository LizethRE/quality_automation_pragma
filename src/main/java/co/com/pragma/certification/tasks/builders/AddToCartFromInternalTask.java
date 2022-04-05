package co.com.pragma.certification.tasks.builders;

import co.com.pragma.certification.models.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import java.util.List;

import static co.com.pragma.certification.userinterface.ProductInternalPage.*;
import static co.com.pragma.certification.userinterface.HomePage.*;
import static co.com.pragma.certification.userinterface.ProductInternalPage.ADD_TO_CART_BUTTON;
import static co.com.pragma.certification.userinterface.ProductContainerPage.PRODUCT_DIV;


public class AddToCartFromInternalTask implements Task {
    private Product product;

    public AddToCartFromInternalTask(Product product) {
        this.product = product;
    }

    public static AddToCartFromInternalBuilder with() {
        return new AddToCartFromInternalBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> products = PRODUCTS_TAB.get(0).thenFindAll(PRODUCT_DIV);

        actor.attemptsTo(Scroll.to(CATEGORYS_TAB).andAlignToTop());

        for (WebElementFacade item:products) {
            if (item.getText().contains(product.getName())){
                actor.attemptsTo(
                        Click.on(item),
                        Scroll.to(BREAD_CRUMB).andAlignToTop(),
                        Enter.theValue(product.getQuantity()).into(QUANTITY_INPUT),
                        SelectFromOptions.byVisibleText(product.getSize()).from(SIZE_SELECT),
                        Click.on(COLOR_CHECKBOX(product.getColor())),
                        Click.on(ADD_TO_CART_BUTTON)
                );
                break;
            }
        }
    }

    public static class AddToCartFromInternalBuilder{
        private String name;
        private String quantity;
        private String size;
        private String color;

        public AddToCartFromInternalBuilder name(String name){
            this.name = name;
            return this;
        }

        public AddToCartFromInternalBuilder quantity(String quantity){
            this.quantity = quantity;
            return this;
        }

        public AddToCartFromInternalBuilder size(String size){
            this.size = size;
            return this;
        }

        public AddToCartFromInternalBuilder color(String color){
            this.color = color;
            return this;
        }

        public AddToCartFromInternalTask andEnd(){
            return new AddToCartFromInternalTask(
                    Product.builder()
                            .name(this.name)
                            .quantity(this.quantity)
                            .size(this.size)
                            .color(this.color)
                            .build()
            );
        }
    }
}

package co.com.pragma.certification.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private String name;
    private String quantity;
    private String size;
    private String color;
}

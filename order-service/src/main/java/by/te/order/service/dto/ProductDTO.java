package by.te.order.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ProductDTO {

    private String id;
    private String description;
    private Integer price;

    public ProductDTO(String description, Integer price) {
        this.description = description;
        this.price = price;
    }
}

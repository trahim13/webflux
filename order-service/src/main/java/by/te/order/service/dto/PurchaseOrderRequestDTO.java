package by.te.order.service.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrderRequestDTO {

    private Integer userId;
    private String productId;

}

package by.te.order.service.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestContext {

    private PurchaseOrderRequestDTO purchaseOrderRequestDto;
    private ProductDTO productDto;
    private TransactionRequestDTO transactionRequestDto;
    private TransactionResponseDto transactionResponseDto;

    public RequestContext(PurchaseOrderRequestDTO purchaseOrderRequestDto) {
        this.purchaseOrderRequestDto = purchaseOrderRequestDto;
    }
}

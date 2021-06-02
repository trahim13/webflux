package by.te.order.service.util;

import by.te.order.service.dto.*;
import by.te.order.service.entity.PurchaseOrder;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    public static PurchaseOrderResponseDTO getPurchaseOrderResponseDto(PurchaseOrder purchaseOrder){
        PurchaseOrderResponseDTO dto = new PurchaseOrderResponseDTO();
        BeanUtils.copyProperties(purchaseOrder, dto);
        dto.setOrderId(purchaseOrder.getId());
        return dto;
    }

    public static void setTransactionRequestDto(RequestContext requestContext){
        TransactionRequestDTO dto = new TransactionRequestDTO();
        dto.setUserId(requestContext.getPurchaseOrderRequestDto().getUserId());
        dto.setAmount(requestContext.getProductDto().getPrice());
        requestContext.setTransactionRequestDto(dto);
    }

    public static PurchaseOrder getPurchaseOrder(RequestContext requestContext){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setUserId(requestContext.getPurchaseOrderRequestDto().getUserId());
        purchaseOrder.setProductId(requestContext.getPurchaseOrderRequestDto().getProductId());
        purchaseOrder.setAmount(requestContext.getProductDto().getPrice());
        TransactionStatus status = requestContext.getTransactionResponseDto().getStatus();
        OrderStatus orderStatus = TransactionStatus.APPROVED.equals(status) ? OrderStatus.COMPLETED : OrderStatus.FAILED;
        purchaseOrder.setStatus(orderStatus);
        return purchaseOrder;
    }


}

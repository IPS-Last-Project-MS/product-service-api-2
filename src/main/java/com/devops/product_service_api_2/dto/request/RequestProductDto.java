package com.devops.product_service_api_2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDto {
    private String id;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}

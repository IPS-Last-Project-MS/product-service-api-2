package com.devops.product_service_api_2.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "product")
public class Product {
    @Id
    private String productId;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    private FileData data;
}

package com.devops.product_service_api_2.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}

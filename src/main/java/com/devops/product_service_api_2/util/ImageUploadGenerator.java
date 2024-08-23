package com.devops.product_service_api_2.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImageUploadGenerator {
    public String ResourceName(String name, String type){
        StringBuilder builder = new StringBuilder();
        builder.append(UUID.randomUUID().toString());
        builder.append("-DS-");
        builder.append(type).append("-");
        builder.append(name);
        return builder.toString();
    }
}

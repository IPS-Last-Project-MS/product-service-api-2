package com.devops.product_service_api_2.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CommonFileSavedSimpleDataDto {
    private String hash;
    private String directory;
    private String fileName;
    private String resourceUrl;
}

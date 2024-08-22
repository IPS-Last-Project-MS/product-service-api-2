package com.devops.product_service_api_2.service.impl;

import com.devops.product_service_api_2.dto.request.RequestProductDto;
import com.devops.product_service_api_2.dto.response.ResponseProductDto;
import com.devops.product_service_api_2.dto.response.paginate.ResponseProductPaginatedDto;
import com.devops.product_service_api_2.service.ProductService;

public class ProductServiceImpl implements ProductService {
    @Override
    public void create(RequestProductDto dto) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(RequestProductDto dto, String id) {

    }

    @Override
    public ResponseProductDto findById(String id) {
        return null;
    }

    @Override
    public ResponseProductPaginatedDto findAll(String searchText, int page, int size) {
        return null;
    }
}

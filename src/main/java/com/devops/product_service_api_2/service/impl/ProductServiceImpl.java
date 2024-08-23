package com.devops.product_service_api_2.service.impl;

import com.amazonaws.services.dlm.model.InternalServerException;
import com.devops.product_service_api_2.dto.request.RequestProductDto;
import com.devops.product_service_api_2.dto.response.ResponseProductDto;
import com.devops.product_service_api_2.dto.response.paginate.ResponseProductPaginatedDto;
import com.devops.product_service_api_2.entity.FileData;
import com.devops.product_service_api_2.entity.Product;
import com.devops.product_service_api_2.repo.ProductRepo;
import com.devops.product_service_api_2.service.FileService;
import com.devops.product_service_api_2.service.ProductService;
import com.devops.product_service_api_2.util.CommonFileSavedBinaryDataDto;
import com.devops.product_service_api_2.util.FileDataExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    @Value("${bucketName}")
    private String bucketName;

    private final ProductRepo repo;
    private final FileService fileService;
    private final FileDataExtractor fileDataExtractor;

    @Override
    public void create(RequestProductDto dto, MultipartFile file) throws SQLException {
        CommonFileSavedBinaryDataDto resource = null;
        try{
            resource = fileService.createResource(file,"product/icon", bucketName);
            Product p = new Product().builder()
                    .productId(UUID.randomUUID().toString())
                    .data(
                            new FileData(
                                    fileDataExtractor.blobToByteArray(resource.getFileName()),
                                    fileDataExtractor.blobToByteArray(resource.getHash()),
                                    resource.getDirectory().getBytes(),
                                    fileDataExtractor.blobToByteArray(resource.getResourceUrl())
                            )
                    )
                    .qtyOnHand(dto.getQtyOnHand())
                    .description(dto.getDescription())
                    .unitPrice(dto.getUnitPrice())
                    .build();
            productRepo.save(p);
        }catch (Exception e){
            assert resource != null;
            fileService.deleteResource(bucketName,
                    resource.getDirectory(),fileDataExtractor.extractActualFileName(
                            new InputStreamReader(
                                    resource.getFileName().getBinaryStream()
                            )
                    ));
            throw new InternalServerException("Something went wrong");
        }
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

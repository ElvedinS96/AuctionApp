package com.example.auctionapp.controller;

import com.example.auctionapp.dto.ProductDto;
import com.example.auctionapp.dto.RoleDto;
import com.example.auctionapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements IBaseController<ProductDto> {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {

        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/related")
    public ResponseEntity<List<ProductDto>> getRelatedProducts(
                                                    @PathVariable Long id,
                                                    @RequestParam("subcategory") Long subcategoryId) {
        return new ResponseEntity<>(productService.getRelatedProducts(id, subcategoryId), HttpStatus.OK);
    }

    @GetMapping("/feature")
    public ResponseEntity<List<ProductDto>> getFeatureProducts() {
        return new ResponseEntity<>(productService.getFeatureProducts(), HttpStatus.OK);
    }

    @PostMapping()
    @Valid
    public ResponseEntity<ProductDto>  add(@Valid @RequestBody ProductDto resource) {

        return new ResponseEntity<>(productService.add(resource), HttpStatus.CREATED);
    }

    @PutMapping()
    @Valid
    public ResponseEntity<ProductDto>  update(@Valid @RequestBody ProductDto resource) {

        return new ResponseEntity<>(productService.update(resource), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        productService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

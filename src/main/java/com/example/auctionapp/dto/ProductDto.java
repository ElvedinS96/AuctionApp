package com.example.auctionapp.dto;

import com.example.auctionapp.model.Image;
import com.example.auctionapp.model.Subcategory;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ProductDto extends BaseResourceDto{

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Long subcategoryId;

    @NotNull
    private Long auctionStartDate;

    @NotNull
    private Long auctionEndDate;

    private List<String> imagesUrl;

    private Boolean feature;

    @NotNull
    private Long userId;

    private List<BidDto> bids;

    public ProductDto() {
    }

    public ProductDto(Long id,
                      LocalDateTime dateCreated,
                      LocalDateTime lastModifiedDate,
                      String name,
                      String description,
                      Double price,
                      Long subcategoryId,
                      Long auctionStartDate,
                      Long auctionEndDate,
                      List<String> imagesUrl,
                      Boolean feature,
                      Long userId,
                      List<BidDto> bids) {

        super(id, dateCreated, lastModifiedDate);
        this.name = name;
        this.description = description;
        this.price = price;
        this.subcategoryId = subcategoryId;
        this.auctionStartDate = auctionStartDate;
        this.auctionEndDate = auctionEndDate;
        this.imagesUrl = imagesUrl;
        this.feature = feature;
        this.userId = userId;
        this.bids = bids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Long getAuctionStartDate() {
        return auctionStartDate;
    }

    public void setAuctionStartDate(Long auctionStartDate) {
        this.auctionStartDate = auctionStartDate;
    }

    public Long getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Long auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public List<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(List<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Boolean getFeature() {
        return feature;
    }

    public void setFeature(Boolean feature) {
        this.feature = feature;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<BidDto> getBids() {
        return bids;
    }
}

package com.example.auctionapp.model;

import com.example.auctionapp.enumeration.ColorEnum;
import com.example.auctionapp.enumeration.SizeEnum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends Resource {

    @NotBlank
    private String name;

    @Size(min=0, max = 1000)
    private String description;

    @NotNull
    private Double price;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id", updatable = false)
    private Subcategory subcategory;


    @NotNull
    private LocalDateTime auctionStartDate;

    @NotNull
    private LocalDateTime auctionEndDate;
    @Size(min = 2)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    private Boolean feature;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
    private UserAccount userAccount;

    @OneToMany(mappedBy = "product")
    private List<Bid> bids;

    private ColorEnum color;

    private SizeEnum size;

    public Product() {
    }

    public Product(String name,
                   String description,
                   Double price,
                   Subcategory subcategory,
                   LocalDateTime auctionStartDate,
                   LocalDateTime auctionEndDate,
                   List<Image> images,
                   Boolean feature,
                   UserAccount userAccount,
                   ColorEnum color,
                   SizeEnum size) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.subcategory = subcategory;
        this.auctionStartDate = auctionStartDate;
        this.auctionEndDate = auctionEndDate;
        this.images = images;
        this.feature=feature;
        this.userAccount = userAccount;
        this.color = color;
        this.size = size;
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

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public LocalDateTime getAuctionStartDate() {
        return auctionStartDate;
    }

    public void setAuctionStartDate(LocalDateTime auctionStartDate) {
        this.auctionStartDate = auctionStartDate;
    }

    public LocalDateTime getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(LocalDateTime auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Boolean getFeature() {
        return feature;
    }

    public void setFeature(Boolean feature) {
        this.feature = feature;
    }

    public UserAccount getUser() {
        return userAccount;
    }

    public void setUser(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }
}

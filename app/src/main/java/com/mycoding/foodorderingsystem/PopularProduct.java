package com.mycoding.foodorderingsystem;

public class PopularProduct {
    Integer popularPhoto;
    String popularTitles;
    String popularPrice;
    String popularSubTitle;

    public PopularProduct(Integer popularPhoto, String popularTitles, String popularSubTitle, String popularPrice){
        this.popularPhoto = popularPhoto;
        this.popularTitles = popularTitles;
        this.popularSubTitle = popularSubTitle;
        this.popularPrice = popularPrice;
    }

    public String getPopularSubTitle() {
        return popularSubTitle;
    }

    public Integer getPopularPhoto() {
        return popularPhoto;
    }

    public String getPopularTitles() {
        return popularTitles;
    }

    public String getPopularPrice() {
        return popularPrice;
    }
}

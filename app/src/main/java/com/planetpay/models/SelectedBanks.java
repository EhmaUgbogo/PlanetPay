package com.planetpay.models;

public class SelectedBanks {
    private  String name;
    private Integer imageUrl;

    public SelectedBanks(String name, Integer imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }


}

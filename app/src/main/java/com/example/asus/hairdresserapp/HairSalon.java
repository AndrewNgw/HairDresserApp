package com.example.asus.hairdresserapp;

import java.io.Serializable;
import java.util.Objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "hairSalon_table")
public class HairSalon implements Serializable {
/*
    @PrimaryKey(autoGenerate = true)
    private int id;*/

    private String name;
    private String address;
    private String parking;
    private String wifi;
    private String prices;
    private String openingHours;

    public HairSalon(){

    }

    public HairSalon(String name, String address, String parking, String wifi, String prices, String openingHours) {
        this.name = name;
        this.address = address;
        this.parking = parking;
        this.wifi = wifi;
        this.prices = prices;
        this.openingHours = openingHours;
    }
/*
    public int getId() {
        return id;
    }*/

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getParking() {
        return parking;
    }

    public String getWifi() {
        return wifi;
    }

    public String getPrices() {
        return prices;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String toString(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HairSalon hairSalon = (HairSalon) o;
        return Objects.equals(name, hairSalon.name) &&
                Objects.equals(address, hairSalon.address) &&
                Objects.equals(parking, hairSalon.parking) &&
                Objects.equals(wifi, hairSalon.wifi) &&
                Objects.equals(prices, hairSalon.prices) &&
                Objects.equals(openingHours, hairSalon.openingHours);
    }
}

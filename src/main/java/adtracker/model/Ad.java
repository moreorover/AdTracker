/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtracker.model;

import adtracker.model.enums.AdStatus;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author mselv
 */
public class Ad {
    private String adId;
    private String adUrl;
    private AdAuthor author;
    
    private AdStatus status;
    
    private LocalDateTime found;
    private LocalDateTime updated;
    private LocalDateTime lastChecked;
    private LocalDateTime sold;
    
    private int price;
    
    private Car car;
    
    private String location;
    
    private String comment;

    Ad() {
        this.car = new Car();
    }

    Ad(String adId, String adUrl, AdStatus status, LocalDateTime found) {
        this.adId = adId;
        this.adUrl = adUrl;
        this.status = status;
        this.found = found;
        this.car = new Car();
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public AdAuthor getAuthor() {
        return author;
    }

    public void setAuthor(AdAuthor author) {
        this.author = author;
    }

    public AdStatus getStatus() {
        return status;
    }

    public void setStatus(AdStatus status) {
        this.status = status;
    }

    public LocalDateTime getFound() {
        return found;
    }

    public void setFound(LocalDateTime found) {
        this.found = found;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDateTime lastChecked) {
        this.lastChecked = lastChecked;
    }

    public LocalDateTime getSold() {
        return sold;
    }

    public void setSold(LocalDateTime sold) {
        this.sold = sold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "adId='" + adId + '\'' +
                ", adUrl='" + adUrl + '\'' +
                ", author=" + author +
                ", status=" + status +
                ", found=" + found +
                ", updated=" + updated +
                ", lastChecked=" + lastChecked +
                ", sold=" + sold +
                ", price=" + price +
                ", car=" + car +
                ", location='" + location + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return price == ad.price &&
                Objects.equals(adId, ad.adId) &&
                Objects.equals(adUrl, ad.adUrl) &&
                Objects.equals(author, ad.author) &&
                Objects.equals(car, ad.car) &&
                Objects.equals(location, ad.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, adUrl, author, status, found, updated, lastChecked, sold, price, car, location, comment);
    }
}

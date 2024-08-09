package main.java;

import java.util.Date;

class OrderDetail {
    private int detailID;
    private String carType;
    private int price;
    private Date date;
    private int memberID;
    private int days;
    private String location;

    public OrderDetail(int detailID, String carType, int price, Date date, int memberID, int days, String location) {
        this.detailID = detailID;
        this.carType = carType;
        this.price = price;
        this.date = date;
        this.memberID = memberID;
        this.days = days;
        this.location = location;
    }

    // Getters and Setters
    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
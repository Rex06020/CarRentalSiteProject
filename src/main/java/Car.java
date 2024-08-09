package main.java;

import java.util.Date;

public class Car {
    private int carID;
    private String carType;
    private int price;
    private Date date;
    private int peopleNub;
    private CarStatus carStatus;
    private String cLocation;
    
	enum CarStatus {
	    USE, UNUSE
	}

    public Car(int carID, String carType, int price, Date date, int peopleNub, CarStatus carStatus, String cLocation) {
        this.carID = carID;
        this.carType = carType;
        this.price = price;
        this.date = date;
        this.peopleNub = peopleNub;
        this.carStatus = carStatus;
        this.cLocation = cLocation;
    }

    // Getters and Setters
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
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

    public int getPeopleNub() {
        return peopleNub;
    }

    public void setPeopleNub(int peopleNub) {
        this.peopleNub = peopleNub;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public String getCLocation() {
        return cLocation;
    }

    public void setCLocation(String cLocation) {
        this.cLocation = cLocation;
    }
}
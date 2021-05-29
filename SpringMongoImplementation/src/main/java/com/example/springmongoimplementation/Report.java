package com.example.springmongoimplementation;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;

import java.util.*;

@JsonSerialize
public class Report {

    @Id
    private Float batchId;
    private Float productType;
    private Date date = new Date();
    private Float totalAmount;
    private int defectAmount;
    private int acceptedAmount;
    private Double humidity;
    private Double temperature;



    public Float getBatchId() {
        return batchId;
    }

    public void setBatchId(Float batchId) {
        this.batchId = batchId;
    }

    public Float getProductType() {
        return productType;
    }

    public void setProductType(Float productType) {
        this.productType = productType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getDefectAmount() {
        return defectAmount;
    }

    public void setDefectAmount(int defectAmount) {
        this.defectAmount = defectAmount;
    }

    public int getAcceptedAmount() {
        return acceptedAmount;
    }

    public void setAcceptedAmount(int acceptedAmount) {
        this.acceptedAmount = acceptedAmount;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Report() {
    }

    public Report(Float batchId, Float productType, Date date, Float totalAmount, int defectAmount, int acceptedAmount, Double humidity, Double temperature) {
        this.batchId = batchId;
        this.productType = productType;
        this.date = date;
        this.totalAmount = totalAmount;
        this.defectAmount = defectAmount;
        this.acceptedAmount = acceptedAmount;
        this.humidity = humidity;
        this.temperature = temperature;
    }
}
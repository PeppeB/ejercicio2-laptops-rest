package com.example.ejercicio2laptopsrest.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

// The annotation @Entity makes the Laptop class an entity.
// The annotation @Table specifies that Laptop entities should be persisted to a table named Laptops
// in the database.
@Entity
@Table(name = "Laptops")
@ApiModel("Laptop entity representing a laptop computer")
public class Laptop {

    // attributes

    // The annotation @id defines the ID property of the entity Laptop.
    // The annotation @GeneratedValue(strategy = GenerationType.AUTO) specifies the database will
    // automatically generate the ID value.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("Auto-incrementing key of type Long")
    private Long id;

    private String brand;
    private String model;
    private String color;
    @ApiModelProperty("Dimension and type of display")
    private String display;
    private String graphicCard;
    private String processor;
    @ApiModelProperty("Capacity and type of Hard-Disk")
    private String storage;
    @ApiModelProperty("Memory capacity")
    private String ram;
    private String microphoneType;
    private String webcamType;
    private String speakersType;
    private Boolean hasOpticalDrive;
    private Boolean hasFingerprintScanner;
    private Boolean hasBluetooth;
    private Boolean hasSdCardReader;
    @ApiModelProperty("Number of usb ports")
    private Integer nrUsbPorts;
    private String batteryType;
    private String operatingSystem;

    // constructors

    public Laptop() {

    }

    public Laptop(Long id, String brand, String model, String color, String display, String graphicCard,
                  String processor, String storage, String ram, String microphoneType, String webcamType,
                  String speakersType, Boolean hasOpticalDrive, Boolean hasFingerprintScanner, Boolean hasBluetooth,
                  Boolean hasSdCardReader, Integer nrUsbPorts, String batteryType, String operatingSystem) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.display = display;
        this.graphicCard = graphicCard;
        this.processor = processor;
        this.storage = storage;
        this.ram = ram;
        this.microphoneType = microphoneType;
        this.webcamType = webcamType;
        this.speakersType = speakersType;
        this.hasOpticalDrive = hasOpticalDrive;
        this.hasFingerprintScanner = hasFingerprintScanner;
        this.hasBluetooth = hasBluetooth;
        this.hasSdCardReader = hasSdCardReader;
        this.nrUsbPorts = nrUsbPorts;
        this.batteryType = batteryType;
        this.operatingSystem = operatingSystem;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMicrophoneType() {
        return microphoneType;
    }

    public void setMicrophoneType(String microphoneType) {
        this.microphoneType = microphoneType;
    }

    public String getWebcamType() {
        return webcamType;
    }

    public void setWebcamType(String webcamType) {
        this.webcamType = webcamType;
    }

    public String getSpeakersType() {
        return speakersType;
    }

    public void setSpeakersType(String speakersType) {
        this.speakersType = speakersType;
    }

    public Boolean getHasOpticalDrive() {
        return hasOpticalDrive;
    }

    public void setHasOpticalDrive(Boolean hasOpticalDrive) {
        this.hasOpticalDrive = hasOpticalDrive;
    }

    public Boolean getHasFingerprintScanner() {
        return hasFingerprintScanner;
    }

    public void setHasFingerprintScanner(Boolean hasFingerprintScanner) {
        this.hasFingerprintScanner = hasFingerprintScanner;
    }

    public Boolean getHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(Boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public Boolean getHasSdCardReader() {
        return hasSdCardReader;
    }

    public void setHasSdCardReader(Boolean hasSdCardReader) {
        this.hasSdCardReader = hasSdCardReader;
    }

    public Integer getNrUsbPorts() {
        return nrUsbPorts;
    }

    public void setNrUsbPorts(Integer nrUsbPorts) {
        this.nrUsbPorts = nrUsbPorts;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}

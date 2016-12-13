/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import Messeges.SystemMesseges;
import manufacturer.Business;
import utilities.Validate;

/**
 *
 * @author Deepak
 */
public class Product {

    private String productName, description, category, productSizeUnit;
    private double cost, sellPrice;
    private int productSize, packQuantity;
    private String barcode;
    private Business manufacturer;
    
     public Product(String categeory, String name, String description,int packQuantity,
            double cost, double price, Business manufacturer) {
        setProductName(name);
        setDescription(description);
        setPackQuantity(packQuantity);
        setCost(cost);
        setSellPrice(price);
        setCategory(categeory);
        setManufacturer(manufacturer);
    }
     /** This constructor is called if product has a size e.g - food, beverages etc*/
    public Product(String categeory, String name,  String description,int productSize, int packQuantity,
            double cost, double price, Business manufacturer) {
        this(categeory,name,description,packQuantity,cost,price,manufacturer);
        setProductSizeUnit(categeory);     
    }

    public String getProductName() {
        if (this.productName.isEmpty()) {
            this.productName = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return this.productName;
    }

    public void setProductName(String name) {
        if (Validate.emptyValidator(name)) {
            this.productName = name;
        } else {
            throw new IllegalArgumentException(SystemMesseges.EMPTY_INPUT_MESSAGE);
        }
    }

    public String getDescription() {
        if (this.description.isEmpty()) {
            this.description = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return description;
    }

    public void setDescription(String description) {
        if (Validate.emptyValidator(description)) {
            this.productName = description;
        } else {
            throw new IllegalArgumentException(SystemMesseges.EMPTY_INPUT_MESSAGE);
        }
    }

    public String getBarcode() {
        if (this.barcode.isEmpty()) {
            this.barcode = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return barcode;
    }

    public void setBarcode(String barcode) {
        if (Validate.emptyValidator(barcode)) {
            this.barcode = barcode;
        } else {
            throw new IllegalArgumentException(SystemMesseges.EMPTY_INPUT_MESSAGE);
        }
    }

    public int getPackQuantity() {
        if (this.packQuantity > 0) {
            this.packQuantity = 0;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + "Pack Quantity" + SystemMesseges.NUM_SETTO_ZERO);
        }
        return this.packQuantity;
    }

    public void setPackQuantity(int size) {
        if (Validate.numberValidator(size)) {
            this.packQuantity = size;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_NUMBER_MESSEGE);
        }

    }

    public double getCost() {
        if (this.cost < 0) {
            this.cost = 0;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + SystemMesseges.NUM_SETTO_ZERO);
        }
        return this.cost;
    }

    public void setCost(double cost) {
        if (Validate.numberValidator(cost)) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException(SystemMesseges.EMPTY_INPUT_MESSAGE);
        }
    }

    public double getSellPrice() {
        if (this.sellPrice < 0) {
            this.sellPrice = 0;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + SystemMesseges.NUM_SETTO_ZERO);
        }
        return this.sellPrice;
    }

    public void setSellPrice(double price) {
        if (Validate.numberValidator(price)) {
            this.sellPrice = price;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_NUMBER_MESSEGE);
        }
    }

    public String getCategory() {
        if (this.category.isEmpty()) {
            this.category = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return category;
    }

    public void setCategory(String category) {
        if (Validate.alphaNumericValidator(category)) {
            this.category = category.trim();
        } else {
             throw new IllegalArgumentException(SystemMesseges.EMPTY_VARIABLE_MESSAGE);
        }
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public String getProductSizeUnit() {
        if (this.productSizeUnit.isEmpty()) {
            this.productSizeUnit = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return productSizeUnit;
    }

    public void setProductSizeUnit(String str) {
        if(str.equalsIgnoreCase("liquid")){
            this.productSizeUnit = "ml";            
        }else if(str.equalsIgnoreCase("solid")){
            this.productSizeUnit = "g";   
        }
    }
    
    public Business getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Business manufacturer) {
        this.manufacturer = manufacturer;
    }

}

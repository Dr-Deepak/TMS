/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manufacturer;

import Messeges.SystemMesseges;
import utilities.Validate;

/**
 *
 * @author Deepak
 */
public abstract class Business {

    private String busName, address, city, posCode, provinceCode, countryCharCode, email, phNum, FxNum;

    public Business(String busName, String address, String city, String prov, String posCode,
            String country, String email, String phNumber, String FxNumber) {
        setBusiName(busName);        
        setAddress(address);
        setCountry(country);
        setProvinceCode(prov, country);
        setCity(city, prov);
        setPosCode(posCode);
        setPhNumber(phNumber);   
        setFxNumber(FxNumber);    
    }

    public String getProvince() {
        if (this.provinceCode.isEmpty()) {
            this.provinceCode = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return provinceCode;
    }
     public void setProvinceCode(String provCode, String countryCode) {
        if (Validate.provinceValidate(provCode, countryCode)) {
            this.provinceCode = provCode;
        }else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_PROVINCE_MESSAGE);
        }
    }
    public String getPosCode() {
        if (this.posCode.isEmpty()) {
            this.posCode = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return posCode;
    }
    public void setPosCode(String posCode) {
        if (Validate.postalCodeValidator(posCode)) {
            this.posCode = posCode;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_POSTCODE_MESSAGE);
        }
    }
    
    public String getBusiName() {
        if (this.busName.isEmpty()) {
            this.busName = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return busName;
    }
    public void setBusiName(String busName) {
        if (Validate.alphaNumericValidator(busName)) {
            this.busName = busName;
        } else {
            throw new IllegalArgumentException(this.busName.getClass().getSimpleName() 
                                               + SystemMesseges.INVALID_FIELD_MESSAGE);
        }
    }
     
    public String getAddress() {
        if (this.address.isEmpty()) {
            this.address = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return address;
    }
    public void setAddress(String address) {
        if (Validate.emptyValidator(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException(this.address.getClass().getSimpleName()
                    + SystemMesseges.EMPTY_INPUT_MESSAGE);
        }
    }

    public String getCity() {
        if (this.city.isEmpty()) {
            this.city = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return city;
    }
    public void setCity(String city, String provCode) {
        if (Validate.cityValidator(city, provCode)) {
            this.city = city;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_CITY_MESSAGE);
        }
    }

    public String getCountry() {
        if (this.countryCharCode.isEmpty()) {
            this.countryCharCode = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return countryCharCode;
    }
    public void setCountry(String countryCharCode) {
        if (Validate.countryValidator(countryCharCode)) {
            this.countryCharCode = countryCharCode;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_COUNTRY_MESSAGE);
        }
    }
    
    public String getEmail() {
        if (this.email.isEmpty()) {
            this.email = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return email;
    }
    public void setEmail(String email) {
        if (Validate.emailValidator(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_EMAIL_MESSEGE);
        }
    }

    public String getPhNumber() {
        if (this.phNum.isEmpty()) {
            this.phNum = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return phNum;
    }
    public void setPhNumber(String Ph) {
        if (Validate.phoneValidator(Ph)) {
            this.phNum = Ph;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_PHONE_MESSAGE);
        }
    }
    
    public String getFxNumber() {
        if (this.FxNum.isEmpty()) {
            this.FxNum = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return FxNum;
    }
    public void setFxNumber(String Fax) {
        if (Validate.phoneValidator(Fax)) {
            this.FxNum = Fax;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_PHONE_MESSAGE);
        }
    }
    @Override
    public String toString() {
        return "Manufacturer:\t" + getBusiName()
                + "\nAddress    :\t" + getAddress()
                + "\nCity       :\t" + getCity()
                + "\nPostal Code:\t" + getPosCode()
                + "\nProvince   :\t" + getProvince()
                + "\nCountry    :\t" + getCountry()
                + "\nEmail      :\t" + getEmail()
                + "\nPhone No.  :\t" + getPhNumber()
                + "\nFax No.    :\t" + getFxNumber();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import Messeges.SystemMesseges;
import java.time.LocalDate;
import utilities.Validate;

/**
 * @author Deepak
 */
public abstract class Employee {

    private boolean status;
    private LocalDate dateOfBirth;    
    private int employeeCounter;
    private int employeeID;
    private final double MAX_REG_HOURS_PER_WEEK = 44;
    private String firstName, lastName, gender, email, sin, address, city,
                   posCode,provinceCode,countryCharCode,cellPhone,homePhone;

    public Employee(String firstName, String lastName, String gender,
            String address, String city, String posCode, String provinceCode, String countryCode,
            String cellPhone, int year, int month, int day, boolean status) {
        
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setAddress(address);
        setCity(city, provinceCode);
        setPosCode(posCode);
        setProvinceCode(provinceCode, countryCode);
        setCountry(countryCode);
        setCellPhone(cellPhone);
        setDateOfBirth(year, month, day);
        this.status = status;
        employeeCounter++;
        this.employeeID = employeeCounter;
    }

    /**
     * Getters and setters for all variables with their specific validations 
     *
     * @return
     */
    public String getFirstName() {
        if (this.firstName.isEmpty()) {
            this.firstName = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
            return firstName;
        }
        return this.firstName;

    }

    public void setFirstName(String txt) {    
        if (Validate.alphaNumericValidator(txt)) {
            this.firstName = txt;
        } else {
            throw new IllegalArgumentException(this.firstName.getClass().getSimpleName() 
                                                + SystemMesseges.INVALID_FIELD_MESSAGE);
        }
    }

    public String getLastName() {
        if (this.lastName.isEmpty()) {
            this.lastName = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return this.lastName;

    }

    public void setLastName(String lastName) {
        if (Validate.alphaNumericValidator(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException(this.lastName.getClass().getSimpleName() 
                                               + SystemMesseges.INVALID_FIELD_MESSAGE);
        }
    }

    public String getGender() {
        if (this.gender.isEmpty()) {
            this.gender = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return this.gender;
    }

    public void setGender(String gender) {
        if (Validate.genderValidator(gender)) {
            this.gender = gender;
        } throw new IllegalArgumentException(SystemMesseges.INVALID_GENDER_MESSAGE);
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

    public String getEmail() {
        if (this.email.isEmpty()) {
            this.email = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return this.email;

    }

    public void setEmail(String email) {
        if (Validate.emailValidator(email)) {
            this.email = email;
        }else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_EMAIL_MESSEGE);
        }
    }

    public String getSin() {
        if (this.sin.isEmpty()) {
            this.sin = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return sin;
    }

    public void setSin(String sin) {
        if (Validate.sinValidator(sin)) {
            this.sin = sin;
        }else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_SIN_MESSEGE);
        }
    }

    public String getCity() {
        if (this.city.isEmpty()) {
            this.city = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return this.city;
    }

    public void setCity(String city, String provCode) {
        if (Validate.cityValidator(city, provCode)) {
            this.city = city;
        }else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_CITY_MESSAGE);
        }
    }

    public String getProvinceCode() {
        if (this.provinceCode.isEmpty()) {
            this.provinceCode = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return this.provinceCode;

    }

    public void setProvinceCode(String provCode, String countryCode) {
        if (Validate.provinceValidate(provCode, countryCode)) {
            this.provinceCode = provCode;
        }else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_PROVINCE_MESSAGE);
        }
    }

    public String getCountry() {
        if (this.countryCharCode.isEmpty()) {
            this.countryCharCode = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return this.countryCharCode;
    }

    public void setCountry(String countryCharCode) {
        if (Validate.countryValidator(countryCharCode)) {
            this.countryCharCode = countryCharCode;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_COUNTRY_MESSAGE);
        }
    }

    public String getCellPhone() {
        if (this.cellPhone.isEmpty()) {
            this.cellPhone = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        if (Validate.phoneValidator(cellPhone)) {
            this.cellPhone = cellPhone;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_PHONE_MESSAGE);
        }
    }

    public String getHomePhone() {
        if (this.homePhone.isEmpty()) {
            this.homePhone = SystemMesseges.EMPTY_VARIABLE_MESSAGE;
        }
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        if (Validate.phoneValidator(homePhone)) {
            this.homePhone = homePhone;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_PHONE_MESSAGE);
        }

    }
   
    public String getStatus() {
        if (status) {
            return "Active";
        } else {
            return "Inactive";
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }  

    public LocalDate getDateOfBirth() {
        if (this.dateOfBirth == null) {
            dateOfBirth = LocalDate.now();
            System.out.println(SystemMesseges.EMPTY_DATE_MESSAGE);
        }
        return dateOfBirth;
    }

    public void setDateOfBirth(int year, int month, int day) {
        if (Validate.ageValidator(LocalDate.of(year, month, day))) {
            //this.dateOfBirth = new LocalDate.of(year, month, day-1);
            
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_DATE_MESSAGE);
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
    
    public double getMAX_REG_HOURS_PER_WEEK() {
        return MAX_REG_HOURS_PER_WEEK;
    }
    @Override
    public String toString() {
        return "First Name:\t" + getFirstName()
                + "\nLast Name :\t" + getLastName()
                + "\nGender    :\t" + getGender()
                + "\nD.O.B.    :\t" + getDateOfBirth()
                + "\nEmail     :\t" + getEmail()
                + "\nSIN       :\t" + getSin()
                + "\nAddress   :\t" + getAddress()
                + "\nCity      :\t" + getCity()
                + "\nPostalCode:\t" + getPosCode()
                + "\nProvince  :\t" + getProvinceCode()
                + "\nCountry   :\t" + getCountry()
                + "\nHome Phone:\t" + getHomePhone()
                + "\nCell Phone:\t" + getCellPhone()
                + "\nStatus    :\t" + getStatus();
    }

}

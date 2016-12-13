/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import Messeges.SystemMesseges;
import utilities.Input;
import utilities.Validate;

/**
 *
 * @author Deepak
 */
public abstract class FullTimeEmployee extends Employee {
    
    private double BenefitPercentage;
    private double hourlyRate;
    public FullTimeEmployee(String firstName, String lastName, String gender, String address,
                            String city, String posCode, String provinceCode, String countryCode,
                            String cellPhone,double hourlyRate, int year, int month, int day, boolean status) {
                       super(firstName, lastName, gender, address, city, posCode, provinceCode,
                            countryCode, cellPhone, year, month, day, status);
                        setHourlyRate(hourlyRate);
    }     
    
     public double getHourlyRate() {
        if (this.hourlyRate < 0 || this.hourlyRate > 400) {
            this.hourlyRate = 0;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + " Hourly rate" + SystemMesseges.NUM_SETTO_ZERO);
        }
        return this.hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (Validate.realPosNumValidator(hourlyRate)) {
            this.hourlyRate = hourlyRate;
        } else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_NUMBER_MESSEGE);
        }
    }    
    

    @Override
    public String toString() {
        return super.toString()
                + "\nSales     :\t" + getHourlyRate();
    }

}

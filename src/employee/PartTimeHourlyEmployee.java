/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import Messeges.SystemMesseges;
import utilities.Validate;

/**
 *
 * @author Deepak
 */
public class PartTimeHourlyEmployee extends PartTimeEmployee {
    private double hoursWorkedPerWeek;
    private double hourlyRate;
    public PartTimeHourlyEmployee(String firstName, String lastName, String gender, String address,
                                    String countryCode, String provinceCode, String city, String posCode,  
                                    String cellPhone, double hourlyRate, int year, int month, int day, boolean status) {
                            super(firstName, lastName, gender, address, city, posCode, provinceCode, countryCode, 
                                    cellPhone, year, month, day, status);
    }

    public double gethoursWorkedPerWeek() {
        if(this.hoursWorkedPerWeek < 0){
             this.hoursWorkedPerWeek=0;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + " Hourly rate" + SystemMesseges.NUM_SETTO_ZERO);
        }
        return hoursWorkedPerWeek;
    }

    public void sethoursWorkedPerWeek(double hoursWorked) {
        if(Validate.realPosNumValidator(hoursWorked)){
        this.hoursWorkedPerWeek = hoursWorked;
        }else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_DOUBLE_MESSAGE);
        }
    }

    public double getHourlyRate() {
        if(this.hourlyRate < 0){
            this.hourlyRate = 0;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + " Hourly rate" + SystemMesseges.NUM_SETTO_ZERO);
        }        
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if(Validate.numberValidator(hourlyRate)){
        this.hourlyRate = hourlyRate;
        }else {
            throw new IllegalArgumentException(SystemMesseges.INVALID_DOUBLE_MESSAGE);
        }
        
    }
    
    
    @Override
    public String toString() {
        return super.toString()
               +"\nHourlyRate:\t"+getHourlyRate();
    }
    
}

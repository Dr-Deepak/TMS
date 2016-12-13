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
public class FullTimeHourlyEmployee extends FullTimeEmployee {
private double hoursWorkedPerWeek;
    public FullTimeHourlyEmployee(String firstName, String lastName, String gender, String address,
                                    String countryCode, String provinceCode, String city, String posCode,  
                                    String cellPhone, double hourlyRate, int year, int month, int day, boolean status) {
                            super(firstName, lastName, gender, address, city, posCode, provinceCode, countryCode, 
                                    cellPhone, hourlyRate, year, month, day, status);
                            
       
    }
     public double getHoursWorkedPerWeek() {
        if(this.hoursWorkedPerWeek<=0){
            this.hoursWorkedPerWeek =0;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + " Hours worked per week" + SystemMesseges.NUM_SETTO_ZERO);
        }
        return hoursWorkedPerWeek;
    }

    public void setHoursWorkedPerWeek(double hoursWorkedPerWeek) {
        if(Validate.numberValidator(hoursWorkedPerWeek))
        this.hoursWorkedPerWeek = hoursWorkedPerWeek;
    }

    @Override
    public String toString() {
        return super.toString()
               +"\nHourlyRate:\t"+getHourlyRate();
    }
    
}

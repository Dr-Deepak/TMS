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
public class SalaryEmployee extends FullTimeEmployee {

    private double salary;

    public SalaryEmployee(String firstName, String lastName, String gender, String address,
            String city, String posCode, String provinceCode, String countryCode, String cellPhone,
             double hourlyRate, int year, int month, int day, boolean status) {
        super(firstName, lastName, gender, address, city, posCode, provinceCode,
                countryCode, cellPhone, hourlyRate, year, month, day, status);
    }

    public double getSalary() {
        if (this.salary < 0) {
            this.salary = 0.0;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + SystemMesseges.NUM_SETTO_ZERO);
        }
        return this.salary;
    }

    public void setSalary(double hourlyRate) {
        {
           this. salary = this.getMAX_REG_HOURS_PER_WEEK()* this.getHourlyRate();                  
        }
        throw new IllegalArgumentException(SystemMesseges.INVALID_COMMISSION_MESSAGE);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nSalary    :\t" + getSalary();
    }

}

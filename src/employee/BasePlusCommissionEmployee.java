/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import Messeges.SystemMesseges;

/*
 * @author Deepak
 */
public class BasePlusCommissionEmployee extends FullTimeEmployee{
    private double commPercentage, sales;

    public BasePlusCommissionEmployee(String firstName, String lastName,
                                      String gender, String address, String city, String posCode,
                                      String provinceCode, String countryCode, String cellPhone,
                                      double hourlyRate, double commPercentage,int year, int month, int day, boolean status) {
                                super(firstName, lastName, gender, address, city, posCode, provinceCode,
                                        countryCode, cellPhone, hourlyRate, year, month, day, status);
                           
        setCommPercentage(commPercentage);
    }
    
    public double getCommPercentage() {
        if(this.commPercentage < 0){
            this.commPercentage = 0.00;
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + SystemMesseges.NUM_SETTO_ZERO);
        }
        return commPercentage;
    }

    public void setCommPercentage(double commPercentage) {
        if (commPercentage < 0){
           throw new IllegalArgumentException(SystemMesseges.INVALID_COMMISSION_MESSAGE);
        }else
        {
           this.commPercentage = commPercentage;
        }
    }
    public double getCommission(){
        return this.commPercentage;
    }
      
    @Override
    public String toString() {
        return super.toString()
               +"\nCommission    :\t"+ getCommPercentage();              
    }
}

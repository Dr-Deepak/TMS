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
/**
 * employee = new CommissionEmployee(firstName, lastName, gender, address, city, posCode,
                            provinceCode, countryCode, cellPhone, commPercent, year, month, day, status);
 * @author Deepak
 */
public class CommissionEmployee extends PartTimeEmployee {
    private double commPercent;
                                     
    public CommissionEmployee(String firstName, String lastName, String gender,String address, String city, String posCode, String provinceCode, String countryCode,String cellPhone,double commPercent, int year, int month, int day, boolean status) {
                            super(firstName, lastName, gender, address, city, posCode, provinceCode,
                                    countryCode, cellPhone, year, month, day, status);
        setCommPercent(commPercent);
    }

    public double getCommPercent() {
        if(this.commPercent < 0){
             this.commPercent = 0;
        }
        else{
            System.out.println(SystemMesseges.EMPTY_VARIABLE_MESSAGE + " Commission Percentage" + SystemMesseges.NUM_SETTO_ZERO);
        }
        return commPercent;
    }

    public void setCommPercent(double commPercent) {
        
        if(Validate.realPosNumValidator(commPercent)){
            this.commPercent = commPercent;
        }
    }
  
    @Override
    public String toString() {
        return super.toString()
               +"\nComm Percentage:\t"+getCommPercent();
    }
    
}

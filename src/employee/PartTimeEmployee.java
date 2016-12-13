/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author Deepak
 */
public abstract class PartTimeEmployee extends Employee{    

    public PartTimeEmployee(String firstName, String lastName, String gender, String address,
                            String city, String posCode, String provinceCode, String countryCode,
                            String cellPhone, int year, int month, int day, boolean status) {
                        super(firstName, lastName, gender, address, city, posCode, provinceCode,
                                countryCode, cellPhone, year, month, day, status);
    }

    
    

    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Deepak
 */
public class Errors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String firstName, lastName, gender, email, sin, address, city,
                   posCode,provinceCode,countryCharCode,cellPhone,homePhone;
        // TODO code application logic here
       firstName = ServiceClass.stringInputMesseage("first name").getStrVal();
       lastName  = ServiceClass.stringInputMesseage("last name").getStrVal();
         gender  = ServiceClass.stringInputMesseage("gender").getStrVal();
         email   = ServiceClass.stringInputMesseage("email").getStrVal();
         sin     = ServiceClass.stringInputMesseage("sin").getStrVal();   
         address = ServiceClass.stringInputMesseage("address").getStrVal();
         city    = ServiceClass.stringInputMesseage("city").getStrVal();
         posCode = ServiceClass.stringInputMesseage("posCode").getStrVal();
    provinceCode = ServiceClass.stringInputMesseage("provinceCode").getStrVal();
 countryCharCode = ServiceClass.stringInputMesseage("countryCharCode").getStrVal();
       cellPhone = ServiceClass.stringInputMesseage("cellPhone").getStrVal();
       homePhone = ServiceClass.stringInputMesseage("homePhone").getStrVal();
    }
    
}

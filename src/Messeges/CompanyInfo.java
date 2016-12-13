/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** @author Deepak Created On Nov 16, 2016 by 3:43:41 PM*/
package Messeges;

import manufacturer.Business;

public class CompanyInfo extends Business {
private String busName, Phone, Email, Fax,StreetNo,StreetAdd,City,Province,postCode,Country; 

    public CompanyInfo(String busName, String address, String city, String prov, String posCode, String country, String email, String phNumber, String FxNumber) {
        super(busName, address, city, prov, posCode, country, email, phNumber, FxNumber);
    }
}

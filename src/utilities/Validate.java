/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.time.LocalDate;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.management.BadStringOperationException;

/**
 *
 * @author Deepak
 */
public class Validate {
    private static final Pattern STR_PATTERN = Pattern.compile("^[a-zA-Z ]$");
    private static final Pattern ALPNUM_PATTERN = Pattern.compile("^[a-zA-Z0-9]$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+([0-9\\-]?){9,11}[0-9]$");
    private static final Pattern NUM_PATTERN = Pattern.compile("^([0-9\\.]?){9,11}[0-9]$");
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Validates if String is empty OR string contains any thing else than
     * alphabets
     *
     * @param str
     * @return
     * @throws BadStringOperationException
     */
    public static boolean alphaNumericValidator(String str) {
        return (emptyValidator(str) || ALPNUM_PATTERN.matcher(str).matches());
    }

    /**
     * Validates if String is empty OR string contains any thing else than
     * alphabets
     *
     * @param str
     * @return
     */
    public static boolean nameValidator(String str) {
        return (emptyValidator(str) || STR_PATTERN.matcher(str).matches());
    }

    /**
     * Validates entered age minimum 14 max 100
     *
     * @param date
     * @return
     */
    public static boolean ageValidator(LocalDate date) {
        return LocalDate.now().compareTo(date) > 14 && LocalDate.now().compareTo(date) < 100;
    }

    /**
     * Validates if String is empty or string contains any thing else than
     * alphabets or number of character are exactly 12
     *
     * @param str
     * @return
     * @throws BadStringOperationException
     */
    public static boolean phoneValidator(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            return !(str.length() != 12 || !PHONE_PATTERN.matcher(str).matches());
        }
    }

    /**
     * Validated Gender in M or F format only
     *
     * @param str
     * @return
     */
    public static boolean genderValidator(String str) {
        if (str.isEmpty() || str.length() > 0) {
            return false;
        } else {
            return !(!str.equalsIgnoreCase("M") && !str.equalsIgnoreCase("F"));
        }
    }

    /**
     * Only validates if parameter is not empty
     *
     * @param str
     * @return
     */
    public static boolean emptyValidator(String str) {
        return !str.isEmpty();
    }

    /**
     * Validates entered parameters against phone regular expression and ensures
     * parameter having 11 characters
     *
     * @param str
     * @return
     */
    public static boolean sinValidator(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            return !(str.length() != 11 || !PHONE_PATTERN.matcher(str).matches());
        }
    }

    /**
     * Validates entered email have @ character and a period
     *
     * @param str
     * @return
     */
    public static boolean emailValidator(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            return !(str.length() != 11 || !EMAIL_REGEX.matcher(str).matches());
        }
    }

    public static boolean cityValidator(String city, String provCode) {
        System.out.println("No Validation. Need to connect database for Validation");
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean provinceValidate(String provCode, String countryCode) {
        System.out.println("No Validation. Need to connect database for Validation");
        return true;
        
    }

    public static boolean countryValidator(String countryCharCode) {
        String[] locales = Locale.getISOCountries();
        boolean valid =false;
        for (String cs : locales) {
            if (cs.equalsIgnoreCase(countryCharCode)) {
                 valid=true;                
            }
        }
      return valid;        
    }

    public static boolean postalCodeValidator(String posCode) {
        System.out.println("No Validation yet. Need to find regex");
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean numberValidator(double num) {
        return !(num < 0);

    }

    public static boolean realPosNumValidator(double num) {
        return (num > 0);
    }

    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

package commons.FuncValidation;

import commons.ExceptionCustomer.*;

import java.time.LocalDate;
import java.time.Period;

public class CheckCustomer {
    private static String regex = "";

// ----------- Customer --------------- //

    public static boolean checkNameCustomer(String str) throws NameException {
        regex = "^([A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]{1}" +
                "[a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừỴỶỸửữựỵỷỹ ]{2,7}){2,8}$";
        if (!str.matches(regex)) {
            throw new NameException();
        } else {
            return str.matches(regex);
        }

    }

    public static boolean checkEmail(String str) throws EmailException {
        regex = "^[\\w\\d\\-_.]{3,20}@[\\w]{3,7}+(.[\\w]{2,5}){1,5}$";
        if (!str.matches(regex)) {
            throw new EmailException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkCardNumber(String str) throws IdCardException {
        regex = "^[\\d]{3}+\\s[\\d]{3}+\\s[\\d]{3}$";
        if (!str.matches(regex)) {
            throw new IdCardException();
        } else {
            return str.matches(regex);
        }
    }

    public static boolean checkGender(String str) throws GenderException {
        regex = "^male$|^female$|^unknow$";
        if (!str.matches(regex)){
            throw new GenderException();
        }else {
            return str.matches(regex);
        }
    }

    public static boolean checkDayOfBirth(String str) throws BirthdayException {
        boolean check;
        LocalDate birthday;
        regex = "\\b(0?[1-9]|[12]\\d|3[01])[\\/\\-.](0?[1-9]|[12]\\d|3[01])[\\/\\-.](\\d{2}|\\d{4})\\b";
        check = str.matches(regex);
        if (check) {
            String[] dateString = str.split("/");
            int date = Integer.parseInt(dateString[0]);
            int month = Integer.parseInt(dateString[1]);
            int year = Integer.parseInt(dateString[2]);
            try {
                birthday = LocalDate.of(year, month, date);
            } catch (Exception e) {
                throw new BirthdayException();
            }
            LocalDate today = LocalDate.now();
            if (Period.between(birthday, today).getYears() < 18) {
                throw new BirthdayException();
            }
            if (year < 1900) {
                throw new BirthdayException();
            }
        } else {
            throw new BirthdayException();
        }
        return check;
    }

    public static boolean checkTypeCustomer (String str) throws TypeCustomerException {
        regex = "^Diamond$|^Platinium|^Gold$|^Silver$|^Member$";
        if (!str.matches(regex)){
            throw new TypeCustomerException();
        }else {
            return str.matches(regex);
        }
    }
}

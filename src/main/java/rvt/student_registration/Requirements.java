package rvt.student_registration;

public class Requirements {

    public Requirements() {
    }

    public boolean checkVards(String value) {
        final String regex = "^[a-zA-Z]+$";
        if (value.length() < 3) {
            return false;
        } else {
            return value.matches(regex);
        }
    }

    public boolean checkUzvards(String value) {
        final String regex = "^[a-zA-Z]+$";
        if (value.length() < 3) {
            return false;
        } else {
            return value.matches(regex);
        }
    }

    public boolean CheckEmail(String value) {
        final String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (value.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean CheckCode(String value) {
        final String regex = "^\\d{6}-\\d{5}$";
        if (value.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
}

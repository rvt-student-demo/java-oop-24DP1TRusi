package rvt.utils;

public enum ConsoleColors {
    RED("\u001B[31m");


    final String code;
    ConsoleColors(String code) {
        this.code = code;
    }
}

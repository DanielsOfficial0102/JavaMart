package br.com.javamart.models;

public class Admin implements AdminInterface {
    private static final String PASSWORD = "admin";

    public static String getSenhaAdmin() {
        return PASSWORD;
    }
}

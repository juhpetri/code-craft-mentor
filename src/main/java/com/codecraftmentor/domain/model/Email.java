package com.codecraftmentor.domain.model;

import lombok.Getter;

import java.util.regex.Pattern;

public class Email {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    @Getter
    private final String email;

    public Email(String email) {
        this.email = email;
    }

    public static boolean isValido(String email) {
        if (email == null || !EMAIL_REGEX.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
        return true;
    }

    @Override
    public String toString() {
        return email;
    }
}

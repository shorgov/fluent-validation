package com.shorgov.fluentvalidation;

import java.util.Objects;

public class Validation {

    private final StringBuilder errors = new StringBuilder();

    public void addErrorMessage(String message) {
        errors.append("\n").append(Objects.requireNonNull(message));
    }


    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String getErrorMessages() {
        return errors.toString();
    }

    public static Validation ofNull() {
        return null;
    }

    public static Validation creteOnEmpty(Validation v) {
        return Objects.isNull(v) ? new Validation() : v;
    }
}

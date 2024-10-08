package com.shorgov.fluentvalidation;

import java.security.InvalidParameterException;
import java.util.Objects;

public class ValidationExtensions {

    public static <T> Validation isNull(Validation v, T toBeChecked, String message) {
        if (Objects.isNull(toBeChecked)) {
            v = Validation.creteOnEmpty(v);
            v.addErrorMessage(message);
        }
        return v;
    }

    public static Validation notGreaterThan(Validation v, int toBeChecked, int upperLimit, String message) {
        if (toBeChecked > upperLimit) {
            v = Validation.creteOnEmpty(v);
            v.addErrorMessage(message);
        }
        return v;
    }

    public static Validation check(Validation v) {
        if (!Objects.isNull(v)) {
            if (v.hasErrors()) {
                throw new InvalidParameterException(v.getErrorMessages());
            }
        }
        return v;
    }
}

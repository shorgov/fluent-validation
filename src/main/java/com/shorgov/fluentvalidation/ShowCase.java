package com.shorgov.fluentvalidation;

import lombok.experimental.ExtensionMethod;

@ExtensionMethod(ValidationExtensions.class)
public class ShowCase {

    public static void main(String[] args) {
        invokeSomeDummyMethod("John", null, "Sofia, Bulgaria, Street 1", 99);
        //invokeSomeDummyMethod("John", "Doe", null, 500);
    }

    private static void invokeSomeDummyMethod(String firstName, String lastName, String addressLine, int age) {

        Validation.createEmpty()
                .isNull(firstName, "firstName is null")
                .isNull(lastName, "lastName is null")
                .check()
                .isNull(addressLine, "addressLine is null")
                .notGreaterThan(age, 120, "age exceeds the limit of 100")
                .check();
    }
}

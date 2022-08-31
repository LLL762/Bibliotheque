package com.afpa.bibliotheque.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public interface ValidatorString extends Function<String, Map<String, String>> {

    static final String NOT_BLANK_NOT_NULL = "NOT_BLANK_NOT_NULL";


    static ValidatorString notNullNotBlank(final String message) {

        return s -> s != null && !s.isBlank() ? new HashMap<>() : new HashMap<>(Map.of(NOT_BLANK_NOT_NULL, message));
    }


    static ValidatorString maxLength(final int maxLength, final String message) {

        return s -> s.length() <= maxLength ? new HashMap<>() : new HashMap<>(Map.of("MAX_LENGTH", message));
    }

    static ValidatorString isUnsignedInteger(final String message) {
        return s -> {
            try {
                int i = Integer.parseInt(s);

                return i >= 0 ? new HashMap<>() : new HashMap<>(Map.of("NOT_AN_UNSIGNED_INT", message));

            } catch (NumberFormatException e) {

                return new HashMap<>(Map.of("NOT_AN_UNSIGNED_INT", message));
            }
        };
    }

    default ValidatorString and(ValidatorString other) {
        return s -> {
            final Map<String, String> output = this.apply(s);
            output.putAll(other.apply(s));
            return output;
        };
    }


}

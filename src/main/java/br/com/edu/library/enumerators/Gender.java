package br.com.edu.library.enumerators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Gender {

    MALE(1, "Masculino"),
    FEMALE(2, "Feminino");

    private final int id;
    private final String field;

    Gender(int id, String field) {
        this.id = id;
        this.field = field;
    }

    public int getId() {
        return id;
    }

    @JsonValue
    public String getField() {
        return field;
    }

    @JsonCreator
    public static Gender deserializeByName(String value) {
        return Gender.getGender(value);
    }

    public static Gender getGender(String value) {
        return Stream.of(Gender.values())
                .filter(c -> c.getField().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Gender getGender(int value) {
        return Stream.of(Gender.values())
                .filter(c -> c.getId() == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

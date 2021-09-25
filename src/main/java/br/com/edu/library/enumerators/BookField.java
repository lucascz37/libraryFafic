package br.com.edu.library.enumerators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum BookField {

    HUMAN(1, "Humanas"),
    EXACT(2, "Exatas");

    private final int id;
    private final String field;

    BookField(int id, String field) {
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
    public static BookField deserializeByName(String value) {
        return BookField.getBookField(value);
    }

    public static BookField getBookField(String value) {
        return Stream.of(BookField.values())
                .filter(c -> c.getField().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static BookField getBookField(int value) {
        return Stream.of(BookField.values())
                .filter(c -> c.getId() == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

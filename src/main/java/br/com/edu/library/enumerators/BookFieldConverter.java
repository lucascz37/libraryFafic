package br.com.edu.library.enumerators;



import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BookFieldConverter implements AttributeConverter<BookField, Integer> {
    @Override
    public Integer convertToDatabaseColumn(BookField bookField) {
        if (bookField == null) {
            return null;
        }

        return bookField.getId();
    }

    @Override
    public BookField convertToEntityAttribute(Integer integer) {
        if (integer == null) {
            return null;
        }

        return BookField.getBookField(integer);
    }
}

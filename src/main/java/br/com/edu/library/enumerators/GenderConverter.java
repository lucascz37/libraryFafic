package br.com.edu.library.enumerators;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender gender) {
        if (gender == null) {
            return null;
        }

        return gender.getId();
    }

    @Override
    public Gender convertToEntityAttribute(Integer integer) {
        if (integer == null) {
            return null;
        }

        return Gender.getGender(integer);
    }
}

package br.com.edu.library.dto.impl;

import br.com.edu.library.dto.DTO;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

public abstract class GenericDTO<T> implements DTO<T> {

    private final static ModelMapper mapper = createMapperSkipNull();

    private final static ModelMapper mapperReplace = createMapperReplace();
    
    private final Class<T> tClass;
    
    public GenericDTO(Class<T> tClass){
        this.tClass = tClass;
    }

    @Override
    public T fill(T clazz) {
        mapper.map(this, clazz);
        return clazz;
    }

    @Override
    public T replace(T clazz) {
        mapperReplace.map(this, clazz);
        return clazz;
    }

    @Override
    public T to() {
        return mapper.map(this, tClass);
    }

    private static ModelMapper createMapperSkipNull() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);
        return mapper;
    }

    private static ModelMapper createMapperReplace() {
        ModelMapper mapper = new ModelMapper();
        Condition<?, ?> skipIds = context -> !context.getMapping().getLastDestinationProperty().getName().equals("id");
        mapper.getConfiguration().setPropertyCondition(skipIds);
        mapper.getConfiguration().setSkipNullEnabled(false);
        return mapper;
    }
}

package br.com.edu.library.dto;

public interface DTO <T> {
    public T fill(T clazz);

    public T replace(T clazz);

    public T to();
}

package dev.luzifer.response;

import java.util.Optional;

public class Response<T> {
    
    private final T value;
    
    private String message;
    
    public Response(T t) {
        this.value = t;
    }
    
    public Response(T t, String customResponseMessage) {
        this.value = t;
        this.message = customResponseMessage;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Optional<T> getValueWrapped() {
        return value == null ? Optional.empty() : Optional.of(value);
    }
    
    public T getValue() {
        return value;
    }
    
}

package dev.luzifer.response;

import java.util.Optional;

public class Response<T> {
    
    private final T value;
    
    private String customResponseMessage;
    
    public Response(T t) {
        this.value = t;
    }
    
    public Response(T t, String customResponseMessage) {
        this.value = t;
        this.customResponseMessage = customResponseMessage;
    }
    
    public void setCustomResponseMessage(String customResponseMessage) {
        this.customResponseMessage = customResponseMessage;
    }
    
    public String getCustomResponseMessage() {
        return customResponseMessage;
    }
    
    public Optional<T> getValueWrapped() {
        return value == null ? Optional.empty() : Optional.of(value);
    }
    
    public T getValue() {
        return value;
    }
    
}

   
package com.example.demo.entity;

public class Answer<T> {

    private T data;
    private String message;
    private int status;

    public Answer() {
    }

    public Answer(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public static <T> Answer<T> success(T data) {
        return new Answer<>(data, "Succès", 200);
    }

    public static <T> Answer<T> error(String message) {
        return new Answer<>(null, message, 500);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
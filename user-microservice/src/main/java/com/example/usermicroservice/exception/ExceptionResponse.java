package com.example.usermicroservice.exception;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data found for the requested petition"),
    USER_DOES_NOT_EXIST("The user could not be found");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

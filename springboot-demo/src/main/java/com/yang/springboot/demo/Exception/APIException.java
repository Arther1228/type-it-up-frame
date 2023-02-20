package com.yang.springboot.demo.Exception;


import lombok.Data;

/**
 * @author admin
 */
@Data
public class APIException extends RuntimeException {

    private String message;

    public APIException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return " Message=" + this.message;
    }
}

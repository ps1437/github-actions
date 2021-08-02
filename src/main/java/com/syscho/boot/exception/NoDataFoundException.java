package com.syscho.boot.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String msg) {
        super(msg);
    }

    public NoDataFoundException(Long id) {
        super(String.format("No Data found for id %d ", id));
    }

}

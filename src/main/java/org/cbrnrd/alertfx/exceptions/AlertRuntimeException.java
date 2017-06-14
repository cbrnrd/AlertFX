package org.cbrnrd.alertfx.exceptions;

/**
 * Root unchecked exception for the project
 */
public class AlertRuntimeException extends RuntimeException {

    public AlertRuntimeException(){}

    public AlertRuntimeException(String msg){
        super(msg);
    }

    public AlertRuntimeException(String msg, Throwable cause){
        super(msg, cause);
    }

}

package org.cbrnrd.alertfx.exceptions;

/**
 * Root checked exception for the project (not being used by anything right now)
 */
public class AlertException extends Exception{

    public AlertException(){}

    public AlertException(String msg){
        super(msg);
    }

    public AlertException(String msg, Throwable cause){
        super(msg, cause);
    }
}

package org.cbrnrd.alertfx.exceptions;

/**
 * <i>Will be thrown</i> if the alert is already shown and the user is trying to edit it
 */
public class AlertNotEditableException extends AlertRuntimeException{

    public AlertNotEditableException(){}

    public AlertNotEditableException(String msg){
        super(msg);
    }

    public AlertNotEditableException(String msg, Throwable cause){
        super(msg, cause);
    }

}

package com.shashwat.ibxp.dom;

import org.w3c.dom.DOMException;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:46:54 PM
 */
// TODO: extends IBXPException ???
public class IBDOMException extends DOMException
{
	private static final long serialVersionUID = 5002;
    Throwable cause = null;
    public IBDOMException(short code, String message) {
        super(code, message);
    }
    public IBDOMException(short code, Throwable cause) {
        super(code, cause.getMessage());
        this.cause = cause;
    }
    public IBDOMException(Throwable cause) {
        this(IBDOMExceptionCodes.GENERAL_EXCEPTION, cause);
    }
    public Throwable getCause() {
        if(cause != null)
            return cause;
        else
            return super.getCause();
    }
}

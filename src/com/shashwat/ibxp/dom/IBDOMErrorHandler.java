package com.shashwat.ibxp.dom;

import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMError;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:35:45 PM
 */
public class IBDOMErrorHandler implements DOMErrorHandler
{
    public boolean handleError(DOMError error) {
        return false;  // TODO: implementation...
    }
}

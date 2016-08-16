package com.shashwat.ibxp.dom;

import org.w3c.dom.DOMError;
import org.w3c.dom.DOMLocator;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:33:50 PM
 */
// TODO: extends java.lang.Error ???
public class IBDOMError implements DOMError
{
    public short getSeverity() {
        return 0;  // TODO: implementation...
    }

    public String getMessage() {
        return null;  // TODO: implementation...
    }

    public String getType() {
        return null;  // TODO: implementation...
    }

    public Object getRelatedException() {
        return null;  // TODO: implementation...
    }

    public Object getRelatedData() {
        return null;  // TODO: implementation...
    }

    public DOMLocator getLocation() {
        return null;  // TODO: implementation...
    }
}

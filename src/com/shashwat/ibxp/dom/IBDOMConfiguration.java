package com.shashwat.ibxp.dom;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMStringList;
import org.w3c.dom.DOMException;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:33:09 PM
 */
public class IBDOMConfiguration implements DOMConfiguration
{
    public void setParameter(String name, Object value) throws DOMException {
        // TODO: implementation...
    }

    public Object getParameter(String name) throws DOMException {
        return null;  // TODO: implementation...
    }

    public boolean canSetParameter(String name, Object value) {
        return false;  // TODO: implementation...
    }

    public DOMStringList getParameterNames() {
        return null;  // TODO: implementation...
    }
}

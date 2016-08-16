package com.shashwat.ibxp.dom;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;
import org.w3c.dom.DOMException;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:28:31 PM
 */
public class IBDOMImplementation implements DOMImplementation
{
    public boolean hasFeature(String feature, String version) {
        return false;  // TODO: implementation...
    }

    public IBDocumentType createDocumentType(String qualifiedName, String publicId, String systemId) throws DOMException {
        return null;  // TODO: implementation...
    }

    public IBDocument createDocument(String namespaceURI, String qualifiedName, DocumentType doctype) throws DOMException {
        return null;  // TODO: implementation...
    }

    public Object getFeature(String feature, String version) {
        return null;  // TODO: implementation...
    }
}

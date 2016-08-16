package com.shashwat.ibxp.dom;

import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:14:45 PM
 * 
 * DocumentType may contain-- no children
 */
public class IBDocumentType extends IBNode implements DocumentType
{
    public IBDocumentType(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }

    public String getName() {
        return null;  // TODO: implementation...
    }

    public NamedNodeMap getEntities() {
        return null;  // TODO: implementation...
    }

    public NamedNodeMap getNotations() {
        return null;  // TODO: implementation...
    }

    public String getPublicId() {
        return null;  // TODO: implementation...
    }

    public String getSystemId() {
        return null;  // TODO: implementation...
    }

    public String getInternalSubset() {
        return null;  // TODO: implementation...
    }
}

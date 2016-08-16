package com.shashwat.ibxp.dom;

import org.w3c.dom.Entity;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * All the references to a node shall always point to the latest data
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:17:46 PM
 * 
 * Entity may contain-- Element, ProcessingInstruction, Comment, Text, CDATASection, EntityReference
 */
public class IBEntity extends IBNode implements Entity
{
    public IBEntity(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }

    public String getPublicId() {
        return null;  // TODO: implementation...
    }

    public String getSystemId() {
        return null;  // TODO: implementation...
    }

    public String getNotationName() {
        return null;  // TODO: implementation...
    }

    public String getInputEncoding() {
        return null;  // TODO: implementation...
    }

    public String getXmlEncoding() {
        return null;  // TODO: implementation...
    }

    public String getXmlVersion() {
        return null;  // TODO: implementation...
    }
}

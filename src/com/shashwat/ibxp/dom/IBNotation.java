package com.shashwat.ibxp.dom;

import org.w3c.dom.Notation;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:19:16 PM
 * 
 * Notation may contain-- no children
 */
public class IBNotation extends IBNode implements Notation
{
    public IBNotation(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }

    public String getPublicId() {
        return null;  // TODO: implementation...
    }

    public String getSystemId() {
        return null;  // TODO: implementation...
    }
}

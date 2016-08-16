package com.shashwat.ibxp.dom;

import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.DOMException;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:20:16 PM
 * 
 * ProcessingInstruction may contain-- no children
 */
public class IBProcessingInstruction extends IBNode implements ProcessingInstruction
{
    public IBProcessingInstruction(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }

    public String getTarget() {
        return null;  // TODO: implementation...
    }

    public String getData() {
        return null;  // TODO: implementation...
    }

    public void setData(String data) throws DOMException {
        // TODO: implementation...
    }
}

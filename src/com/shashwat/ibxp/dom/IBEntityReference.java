package com.shashwat.ibxp.dom;

import org.w3c.dom.EntityReference;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * All the references to a node shall always point to the latest data
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:16:57 PM
 * 
 * EntityReference may contain-- Element, ProcessingInstruction, 
 *   Comment, Text, CDATASection, EntityReference
 */
public class IBEntityReference extends IBNode implements EntityReference 
{
    public IBEntityReference(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }
}

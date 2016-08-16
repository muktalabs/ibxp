package com.shashwat.ibxp.dom;

import org.w3c.dom.DocumentFragment;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:13:12 PM
 * 
 * DocumentFragment may contain-- Element, ProcessingInstruction, 
 *   Comment, Text, CDATASection, EntityReference
 */
public class IBDocumentFragment extends IBNode implements DocumentFragment 
{
    public IBDocumentFragment(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }
}

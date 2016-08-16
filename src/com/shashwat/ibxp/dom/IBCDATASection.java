package com.shashwat.ibxp.dom;

import org.w3c.dom.CDATASection;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:27:42 PM
 * 
 * CDATASection may contain-- no children
 */
public class IBCDATASection extends IBText implements CDATASection 
{
    public IBCDATASection(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }
}

package com.shashwat.ibxp.dom;

import org.w3c.dom.Comment;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * All the references to a node shall always point to the latest data
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:23:40 PM
 * 
 * Comment may contain-- no children
 */
public class IBComment extends IBCharacterData implements Comment
{
    public IBComment(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }
}

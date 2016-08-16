package com.shashwat.ibxp.dom;

import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * All the references to a node shall always point to the latest data
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:25:15 PM
 * 
 * Text may contain-- no children
 */
public class IBText extends IBCharacterData implements Text
{
    public IBText(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }

    public Text splitText(int offset) throws DOMException {
        return null;  // TODO: implementation...
    }

    public boolean isElementContentWhitespace() {
        return false;  // TODO: implementation...
    }

    public String getWholeText() {
        return null;  // TODO: implementation...
    }

    public Text replaceWholeText(String content) throws DOMException {
        return null;  // TODO: implementation...
    }
}

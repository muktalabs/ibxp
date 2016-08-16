package com.shashwat.ibxp.dom;

import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * All the references to a node shall always point to the latest data
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:22:02 PM
 */
public class IBCharacterData extends IBNode implements CharacterData
{
    public IBCharacterData(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }

    public String getData() throws DOMException {
        return null;  // TODO: implementation...
    }

    public void setData(String data) throws DOMException {
        // TODO: implementation...
    }

    public int getLength() {
        return 0;  // TODO: implementation...
    }

    public String substringData(int offset, int count) throws DOMException {
        return null;  // TODO: implementation...
    }

    public void appendData(String arg) throws DOMException {
        // TODO: implementation...
    }

    public void insertData(int offset, String arg) throws DOMException {
        // TODO: implementation...
    }

    public void deleteData(int offset, int count) throws DOMException {
        // TODO: implementation...
    }

    public void replaceData(int offset, int count, String arg) throws DOMException {
        // TODO: implementation...
    }
}

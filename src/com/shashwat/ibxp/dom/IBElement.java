package com.shashwat.ibxp.dom;

import org.w3c.dom.*;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * All the references to a node shall always point to the latest data
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:15:56 PM
 * 
 * Element may contain-- Element, Text, Comment, ProcessingInstruction, CDATASection, EntityReference
 */
public class IBElement extends IBNode implements Element
{
    protected IBElement(IBDSHelper ds, int nodeIndex)
    {
    	super(ds, nodeIndex);
    }
    
	public String getTagName()
	{
		try
    	{
    		return dsHelper.getNodeName(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public String getAttribute(String name) 
    {
    	try
    	{
    		return dsHelper.getAttribute(nodeIndex, name);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public void setAttribute(String name, String value) throws DOMException 
    {
    	try
    	{
    		dsHelper.setAttribute(nodeIndex, name, value);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    /** The DOM API uses the method name "remove" when the method changes the structural model, 
     *  and the method name "delete" when the method gets rid of something inside the structure model.
     *  The thing that is deleted is not returned. The thing that is removed may be returned, 
     *  when it makes sense to return it.
     */
    public void removeAttribute(String name) throws DOMException 
    {
    	try
    	{
    		dsHelper.removeAttribute(nodeIndex, name);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Attr getAttributeNode(String name) 
    {
    	try
    	{
    		return dsHelper.getAttributeNode(nodeIndex, name);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Attr setAttributeNode(Attr newAttr) throws DOMException 
    {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public NodeList getElementsByTagName(String name) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public String getAttributeNS(String namespaceURI, String localName) throws DOMException 
    {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException 
    {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public boolean hasAttribute(String name) 
    {
    	try
    	{
    		return dsHelper.hasAttribute(nodeIndex, name);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public TypeInfo getSchemaTypeInfo() {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    // TODO: As per the documentation, ID attribute may have any name...?
    // TODO: Special indexing provisions have to be made for them.
    public void setIdAttribute(String name, boolean isId) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }
}

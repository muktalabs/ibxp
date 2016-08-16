package com.shashwat.ibxp.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.TypeInfo;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * Description from 'JavaTM 2 Platform Standard Edition 5.0 API Specification'
 * The Attr interface represents an attribute in an Element object. Typically the allowable values for the attribute are defined in a schema associated with the document.
 * Attr objects inherit the Node interface, but since they are not actually child nodes of the element they describe, the DOM does not consider them part of the document tree. Thus, the Node attributes parentNode, previousSibling, and nextSibling have a null value for Attr objects. The DOM takes the view that attributes are properties of elements rather than having a separate identity from the elements they are associated with; this should make it more efficient to implement such features as default attributes associated with all elements of a given type. Furthermore, Attr nodes may not be immediate children of a DocumentFragment. However, they can be associated with Element nodes contained within a DocumentFragment. In short, users and implementors of the DOM need to be aware that Attr nodes have some things in common with other objects inheriting the Node interface, but they also are quite distinct.
 * The attribute's effective value is determined as follows: if this attribute has been explicitly assigned any value, that value is the attribute's effective value; otherwise, if there is a declaration for this attribute, and that declaration includes a default value, then that default value is the attribute's effective value; otherwise, the attribute does not exist on this element in the structure model until it has been explicitly added. Note that the Node.nodeValue attribute on the Attr instance can also be used to retrieve the string version of the attribute's value(s).
 * If the attribute was not explicitly given a value in the instance document but has a default value provided by the schema associated with the document, an attribute node will be created with specified set to false. Removing attribute nodes for which a default value is defined in the schema generates a new attribute node with the default value and specified set to false. If validation occurred while invoking Document.normalizeDocument(), attribute nodes with specified equals to false are recomputed according to the default attribute values provided by the schema. If no default value is associate with this attribute in the schema, the attribute node is discarded.
 * In XML, where the value of an attribute can contain entity references, the child nodes of the Attr node may be either Text or EntityReference nodes (when these are in use; see the description of EntityReference for discussion).
 * The DOM Core represents all attribute values as simple strings, even if the DTD or schema associated with the document declares them of some specific type such as tokenized.
 * The way attribute value normalization is performed by the DOM implementation depends on how much the implementation knows about the schema in use. Typically, the value and nodeValue attributes of an Attr node initially returns the normalized value given by the parser. It is also the case after Document.normalizeDocument() is called (assuming the right options have been set). But this may not be the case after mutation, independently of whether the mutation is performed by setting the string value directly or by changing the Attr child nodes. In particular, this is true when character references are involved, given that they are not represented in the DOM and they impact attribute value normalization. On the other hand, if the implementation knows about the schema in use when the attribute value is changed, and it is of a different type than CDATA, it may normalize it again at that time. This is especially true of specialized DOM implementations, such as SVG DOM implementations, which store attribute values in an internal form different from a string.
 */
/** Index Based Attribute
 * Attr may contain-- Text, EntityReference
 * All the references to a node shall always point to the latest data
 * 
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 11:43:10 AM
 */
public class IBAttribute extends IBNode implements Attr
{
    private int attrOffset;
	protected IBAttribute(IBDSHelper ibds, int nodeIndex, int attrOffset) throws IBDOMException {
        super(ibds, nodeIndex);
        this.attrOffset = attrOffset;
    }

    public String getName() 
    {
    	try
    	{
    		return dsHelper.getAttrName(nodeIndex, attrOffset);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public boolean getSpecified() {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public String getValue() 
    {
    	try
    	{
    		return dsHelper.getAttrValue(nodeIndex, attrOffset);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public void setValue(String value) throws DOMException 
    {
    	try
    	{
    		String name = dsHelper.getAttrName(nodeIndex, attrOffset);
    		dsHelper.setAttribute(nodeIndex, name, value);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Element getOwnerElement() {
    	try
    	{
    		return IBDOMFactory.getNewIBElement(dsHelper, nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public TypeInfo getSchemaTypeInfo() {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public boolean isId() {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

}

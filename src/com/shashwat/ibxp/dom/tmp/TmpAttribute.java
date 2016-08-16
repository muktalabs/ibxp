package com.shashwat.ibxp.dom.tmp;

import org.w3c.dom.*;

import com.shashwat.ibxp.dom.IBDOMException;
import com.shashwat.ibxp.parser.IBDSHelper;

public class TmpAttribute implements Attr
{
	private String name;
	private String value;
	private IBDSHelper ds;
	protected TmpAttribute(IBDSHelper ds, String name, String value)throws IBDOMException
	{
		if(ds == null)
			throw new IBDOMException((short)0, "IBDS instance passed is null.");
		if(name == null || name.equals(""))
			throw new IBDOMException((short)0, "null passed as attribute name.");
		this.name = name;
		this.value = value;
		this.ds = ds;
	}

	public String getName() {
		return name;
	}
	public String getLocalName() {
		return getName();
	}
	public String getValue() {
		return value;
	}
	public boolean isId() {
		return "ID".equalsIgnoreCase(name);
	}
	public void setValue(String value) throws DOMException {
		this.value = value;
	}
	public String getNodeName() {
		return getName();
	}
	public short getNodeType() {
		return Node.ATTRIBUTE_NODE;
	}
	public String getNodeValue() throws DOMException {
		return getValue();
	}
	public Document getOwnerDocument() 
	{
		try{
			return ds.getOwnerDocument();
		}
		catch (Exception e){
			// TODO: throw e;
			return null;
		}
	}
	public String getTextContent() throws DOMException {
		return getValue();
	}
	public void setNodeValue(String arg0) throws DOMException {
		setValue(arg0);
	}
	public void setTextContent(String arg0) throws DOMException {
		setValue(arg0);
	}
	
	
	
	public Element getOwnerElement() {
		// TODO Auto-generated method stub
		return null;
	}
	public TypeInfo getSchemaTypeInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean getSpecified() {
		// TODO Auto-generated method stub
		return false;
	}
	public Node appendChild(Node arg0) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}
	public Node cloneNode(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public short compareDocumentPosition(Node arg0) throws DOMException {
		// TODO Auto-generated method stub
		return 0;
	}
	public NamedNodeMap getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getBaseURI() {
		// TODO Auto-generated method stub
		return null;
	}
	public NodeList getChildNodes() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getFeature(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	public Node getFirstChild() {
		// TODO Auto-generated method stub
		return null;
	}
	public Node getLastChild() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getNamespaceURI() {
		// TODO Auto-generated method stub
		return null;
	}
	public Node getNextSibling() {
		// TODO Auto-generated method stub
		return null;
	}
	public Node getParentNode() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}
	public Node getPreviousSibling() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getUserData(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean hasAttributes() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean hasChildNodes() {
		// TODO Auto-generated method stub
		return false;
	}
	public Node insertBefore(Node arg0, Node arg1) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isDefaultNamespace(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isEqualNode(Node arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isSameNode(Node arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isSupported(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	public String lookupNamespaceURI(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String lookupPrefix(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public void normalize() {
		// TODO Auto-generated method stub
	}
	public Node removeChild(Node arg0) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}
	public Node replaceChild(Node arg0, Node arg1) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPrefix(String arg0) throws DOMException {
		// TODO Auto-generated method stub
	}
	public Object setUserData(String arg0, Object arg1, UserDataHandler arg2) {
		// TODO Auto-generated method stub
		return null;
	}
}

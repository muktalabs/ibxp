package com.shashwat.ibxp.dom.tmp;

import org.w3c.dom.*;

import com.shashwat.ibxp.dom.IBDOMException;
import com.shashwat.ibxp.parser.IBDSHelper;

public class TmpElement implements Element
{
	private String name;
	private short nodeType;
	protected TmpElement(IBDSHelper ds, String name, short nodeType)throws IBDOMException
	{
		this.name = name;
		this.nodeType = nodeType;
	}

	public String getTagName() {
		return name;
	}
	public short getNodeType() {
		return nodeType;
	}
	
	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttributeNS(String arg0, String arg1) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public Attr getAttributeNode(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Attr getAttributeNodeNS(String arg0, String arg1)
			throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeList getElementsByTagName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public NodeList getElementsByTagNameNS(String arg0, String arg1)
			throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public TypeInfo getSchemaTypeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public boolean hasAttribute(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasAttributeNS(String arg0, String arg1) throws DOMException {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeAttribute(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void removeAttributeNS(String arg0, String arg1) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public Attr removeAttributeNode(Attr arg0) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAttribute(String arg0, String arg1) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setAttributeNS(String arg0, String arg1, String arg2)
			throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public Attr setAttributeNode(Attr arg0) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public Attr setAttributeNodeNS(Attr arg0) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdAttribute(String arg0, boolean arg1) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setIdAttributeNS(String arg0, String arg1, boolean arg2)
			throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setIdAttributeNode(Attr arg0, boolean arg1) throws DOMException {
		// TODO Auto-generated method stub
		
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

	public String getLocalName() {
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

	public String getNodeName() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public String getNodeValue() throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	public Document getOwnerDocument() {
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

	public String getTextContent() throws DOMException {
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

	public void setNodeValue(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setPrefix(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public void setTextContent(String arg0) throws DOMException {
		// TODO Auto-generated method stub
		
	}

	public Object setUserData(String arg0, Object arg1, UserDataHandler arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}

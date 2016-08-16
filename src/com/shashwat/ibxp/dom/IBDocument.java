package com.shashwat.ibxp.dom;

import org.w3c.dom.*;
import com.shashwat.ibxp.parser.IBDSHelper;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:03:58 PM
 * 
 * Document may contain-- Element (maximum of one), ProcessingInstruction, Comment, DocumentType (maximum of one)
 */
public class IBDocument extends IBNode implements Document
{
    public IBDocument(IBDSHelper ibds, int nodeIndex) throws IBDOMException {
        super(ibds, nodeIndex);
    }

    public DocumentType getDoctype() {
        return null;  // TODO: implementation...
    }

    public DOMImplementation getImplementation() {
        return null;  // TODO: implementation...
    }

    public IBElement getDocumentElement() 
    {
    	try
    	{
    		return dsHelper.getDocumentElement();
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Element createElement(String tagName) throws DOMException {
        return null;  // TODO: implementation...
    }

    public DocumentFragment createDocumentFragment() {
        return null;  // TODO: implementation...
    }

    public Text createTextNode(String data) {
        return null;  // TODO: implementation...
    }

    public Comment createComment(String data) {
        return null;  // TODO: implementation...
    }

    public CDATASection createCDATASection(String data) throws DOMException {
        return null;  // TODO: implementation...
    }

    public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
        return null;  // TODO: implementation...
    }

    public Attr createAttribute(String name) throws DOMException {
        return null;  // TODO: implementation...
    }

    public EntityReference createEntityReference(String name) throws DOMException {
        return null;  // TODO: implementation...
    }

    public NodeList getElementsByTagName(String tagname) {
        return null;  // TODO: implementation...
    }

    public Node importNode(Node importedNode, boolean deep) throws DOMException {
        return null;  // TODO: implementation...
    }

    public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
        return null;  // TODO: implementation...
    }

    public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException {
        return null;  // TODO: implementation...
    }

    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        return null;  // TODO: implementation...
    }

    public Element getElementById(String elementId) {
        return null;  // TODO: implementation...
    }

    public String getInputEncoding() {
        return null;  // TODO: implementation...
    }

    public String getXmlEncoding() {
        return null;  // TODO: implementation...
    }

    public boolean getXmlStandalone() {
        return false;  // TODO: implementation...
    }

    public void setXmlStandalone(boolean xmlStandalone) throws DOMException {
        // TODO: implementation...
    }

    public String getXmlVersion() {
        return null;  // TODO: implementation...
    }

    public void setXmlVersion(String xmlVersion) throws DOMException {
        // TODO: implementation...
    }

    public boolean getStrictErrorChecking() {
        return false;  // TODO: implementation...
    }

    public void setStrictErrorChecking(boolean strictErrorChecking) {
        // TODO: implementation...
    }

    public String getDocumentURI() {
        return null;  // TODO: implementation...
    }

    public void setDocumentURI(String documentURI) {
        // TODO: implementation...
    }

    public Node adoptNode(Node source) throws DOMException {
        return null;  // TODO: implementation...
    }

    public DOMConfiguration getDomConfig() {
        return null;  // TODO: implementation...
    }

    /** Note that, with the exceptions of Document.normalizeDocument() and Node.normalize(), 
     *  manipulating characters using DOM methods does not guarantee to preserve a fully-normalized text. 
     */
    public void normalizeDocument() {
        // TODO: implementation...
    }

    public Node renameNode(Node n, String namespaceURI, String qualifiedName) throws DOMException {
        return null;  // TODO: implementation...
    }
}

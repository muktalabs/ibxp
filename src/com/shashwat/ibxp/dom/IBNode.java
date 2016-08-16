package com.shashwat.ibxp.dom;

import org.w3c.dom.*;
import com.shashwat.ibxp.parser.IBDSHelper;

// Everything is a Node...
/**
 * This Class implements methods specified in org.w3c.dom.Node of JavaTM 2 Platform Standard Ed. 5.0
 * This is on-demand node representation... object of this Class or its sub-class will not be persisted
 * in the IBDS and hence, can be generated/ garbage-collected safely without any data loss.
 * 
 * Changes to a Node in the tree are reflected in all references to that Node in NodeList 
 * and NamedNodeMap  objects. All the references to a node shall always point to the latest data
 * 
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 11:26:24 AM  
 */
public abstract class IBNode implements Node
{
    /** Node Interface - Field Summary
     * static short     ATTRIBUTE_NODE          The node is an Attr.
     * static short 	CDATA_SECTION_NODE          The node is a CDATASection.
     * static short 	COMMENT_NODE          The node is a Comment.
     * static short 	DOCUMENT_FRAGMENT_NODE          The node is a DocumentFragment.
     * static short 	DOCUMENT_NODE          The node is a Document.
     * static short 	DOCUMENT_POSITION_CONTAINED_BY          The node is contained by the reference node.
     * static short 	DOCUMENT_POSITION_CONTAINS          The node contains the reference node.
     * static short 	DOCUMENT_POSITION_DISCONNECTED          The two nodes are disconnected.
     * static short 	DOCUMENT_POSITION_FOLLOWING          The node follows the reference node.
     * static short 	DOCUMENT_POSITION_IMPLEMENTATION_SPECIFIC          The determination of preceding versus following is implementation-specific.
     * static short 	DOCUMENT_POSITION_PRECEDING          The second node precedes the reference node.
     * static short 	DOCUMENT_TYPE_NODE          The node is a DocumentType.
     * static short 	ELEMENT_NODE          The node is an Element.
     * static short 	ENTITY_NODE            The node is an Entity.
     * static short 	ENTITY_REFERENCE_NODE          The node is an EntityReference.
     * static short 	NOTATION_NODE          The node is a Notation.
     * static short 	PROCESSING_INSTRUCTION_NODE          The node is a ProcessingInstruction.
     * static short 	TEXT_NODE   The node is a Text node.
     */

    // reference to the instance of data structure.
    protected IBDSHelper dsHelper = null;
    // index of the element (array) in the node list of IBDS
    protected int nodeIndex = 0;    
        
    protected IBNode(IBDSHelper helper, int index) throws IBDOMException
    {
        if(helper == null){
            throw new IBDOMException(IBDOMExceptionCodes.NODE_INIT_FAILURE, "NULL passed as DS reference.");
        }
        this.dsHelper = helper;

        if(index < -1){
            throw new IBDOMException(IBDOMExceptionCodes.NODE_INIT_FAILURE, "Negative value ["+index+"] provided for Node index.");
        }
        this.nodeIndex = index;
    }
    
    public String getNodeName() throws IBDOMException
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

    public String getNodeValue() throws DOMException 
    {
    	try
    	{
    		return dsHelper.getNodeValue(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public void setNodeValue(String nodeValue) throws DOMException 
    {
    	try
    	{
    		dsHelper.setNodeValue(nodeIndex, nodeValue);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public short getNodeType() 
    {
    	try
    	{
    		return dsHelper.getNodeType(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Node getParentNode() 
    {
    	try
    	{
    		return dsHelper.getParentNode(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public NodeList getChildNodes() 
    {
    	try
    	{
    		return dsHelper.getChildNodes(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Node getFirstChild() 
    {
    	try
    	{
    		return dsHelper.getFirstChild(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Node getLastChild() 
    {
    	try
    	{
    		return dsHelper.getLastChild(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Node getPreviousSibling() {
        throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public Node getNextSibling() {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public NamedNodeMap getAttributes() 
    {
    	try
    	{
    		return dsHelper.getAttributes(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Document getOwnerDocument() 
    {
    	try
    	{
    		return dsHelper.getOwnerDocument();
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public Node replaceChild(Node newChild, Node oldChild) throws DOMException 
    {
    	try
    	{
    		return dsHelper.replaceChild(nodeIndex, (IBNode)newChild, (IBNode)oldChild);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Node removeChild(Node oldChild) throws DOMException 
    {
    	try
    	{
    		return dsHelper.removeChild(nodeIndex, (IBNode)oldChild);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Node appendChild(Node newChild) throws DOMException 
    {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public boolean hasChildNodes() 
    {
    	try
    	{
    		return dsHelper.hasChildNodes(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public Node cloneNode(boolean deep) 
    {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    /** Note that, with the exceptions of Document.normalizeDocument() and Node.normalize(), 
     *  manipulating characters using DOM methods does not guarantee to preserve a fully-normalized text. 
     */
    public void normalize() 
    {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public boolean isSupported(String feature, String version) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public String getNamespaceURI() {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public String getPrefix() {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public void setPrefix(String prefix) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public String getLocalName() 
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

    public boolean hasAttributes() 
    {
    	try
    	{
    		return dsHelper.hasAttributes(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public String getBaseURI() {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public short compareDocumentPosition(Node other) throws DOMException {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public String getTextContent() throws DOMException 
    {
    	try
    	{
    		return dsHelper.getNodeValue(nodeIndex);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    // TODO: This should have specific implementation for Character Data nodes
    public void setTextContent(String textContent) throws DOMException 
    {
    	try
    	{
    		dsHelper.setNodeValue(nodeIndex, textContent);
    	}
    	catch (IBDOMException e){
    		throw e;
    	}
    	catch (Exception e){
    		throw new IBDOMException(e);
    	}
    }

    public boolean isSameNode(Node other) 
    {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public String lookupPrefix(String namespaceURI) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public boolean isDefaultNamespace(String namespaceURI) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public String lookupNamespaceURI(String prefix) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public boolean isEqualNode(Node arg) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public Object getFeature(String feature, String version) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public Object setUserData(String key, Object data, UserDataHandler handler) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

    public Object getUserData(String key) {
    	throw new IBDOMException(IBDOMExceptionCodes.NOT_IMPLEMENTED_YET, "Not implemented yet.");
    }

	public int getNodeIndex() {
		return nodeIndex;
	}
}

package com.shashwat.ibxp.dom;

import java.util.LinkedHashMap;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.DOMException;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:31:28 PM
 * 
 * changes to a Node in the tree are reflected in all references to that Node in NodeList and 
 * NamedNodeMap objects.
 */
public class IBNamedNodeMap implements NamedNodeMap
{
	// TODO: Exception handling
	// TODO: provision to freeze addition after adding all elements
	private LinkedHashMap<String, IBNode> hmNodes = null;
	protected IBNamedNodeMap()
	{
		hmNodes = new LinkedHashMap<String, IBNode>();
	}
	
    public Node getNamedItem(String name) {
        return hmNodes.get(name);
    }

    public Node setNamedItem(Node arg) throws DOMException 
    {
    	if(!(arg instanceof IBNode))
    		throw new IBDOMException((short)0, "Invalid node type ["+arg.getClass()+"] passed to add.");
        
    	IBNode node = (IBNode) arg;
    	return hmNodes.put(arg.getNodeName(), node);
    }

    public Node removeNamedItem(String name) throws DOMException {
        return hmNodes.remove(name);
    }

    public Node item(int index) {
        Object[] items = hmNodes.values().toArray();
        return (IBNode)items[index];
    }

    public int getLength() {
        return hmNodes.size();
    }

    public Node getNamedItemNS(String namespaceURI, String localName) throws DOMException {
        return getNamedItem(namespaceURI + ":" + localName);
    }

    public Node setNamedItemNS(Node arg) throws DOMException {
    	if(!(arg instanceof IBNode))
    		throw new IBDOMException((short)0, "Invalid node type ["+arg.getClass()+"] passed to add.");
        
    	IBNode node = (IBNode) arg;
    	String qName = new StringBuffer().append(arg.getNamespaceURI())
    		.append(':').append(arg.getNodeName()).toString();
    	return hmNodes.put(qName, node);
    }

    public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
        return hmNodes.remove(namespaceURI + ":" + localName);
    }
}

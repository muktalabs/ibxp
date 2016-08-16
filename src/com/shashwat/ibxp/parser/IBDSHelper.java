package com.shashwat.ibxp.parser;

import org.w3c.dom.Node;
import com.shashwat.ibxp.dom.*;
import com.shashwat.ibxp.dom.tmp.*;
import com.shashwat.ibxp.util.IBNodeArrayUtil;

// TODO: Synchronization of the DS.
public class IBDSHelper extends IBDS
{
	// TODO: proper exception handling
	// constructed only from IBXParser class
	protected IBDSHelper()
	{	
	}
	
	private final int[] getNodeArray(int nodeIndex) throws IBDSException
    {
        try
        {
            if(nodeList.size() <= nodeIndex) // array index out of bound
                throw new IBDSException("size of the Node list is smaller than node's index.");

            int[] arrThisNode = nodeList.get(nodeIndex);
            if(arrThisNode == null) // null pointer
                throw new IBDSException("NULL found at Node's index.");
            
            if(arrThisNode.length < IBDSConstants.Indexes.INDEX_COUNT)
                throw new IBDSException("Insufficient Length ["+arrThisNode.length+"] of node array found where ["+IBDSConstants.Indexes.INDEX_COUNT+"] or more was expected.");
            
            return arrThisNode;
        }
        catch(Throwable t)
        {
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, t);
        	throw new IBDSException(t.getMessage());
        }
    }
	private static final String substring(CharSequence str, int startIndex, String delims)throws Exception
	{
		try{
			int length = str.length();
			int i=0;
			for(i=startIndex; i<length; i++)
			{
				char t = str.charAt(i);
				if(delims.indexOf(t) != -1)
					break;
			}
			return str.subSequence(startIndex, i).toString();
		}catch(Exception e){
			throw e;
		}
	}
	private final String getToken(int index, String extraDelims, boolean useDefaultDelims)throws IBDSException
	{
		// TODO: implement for multiple delimiters
		try
		{
			String strToken = null;
			String delims = IBDSConstants.Meta.DELIMITER;
			if(extraDelims != null){
				delims = extraDelims;
				if(useDefaultDelims)
					delims = delims + IBDSConstants.Meta.DELIMITER;
			}
			if(index < parsedXML.length())
	        {
				//strToken = parsedXML.substring(index, parsedXML.indexOf(IBDSConstants.Meta.DELIMITER, index));// array index out of bound
				strToken = substring(parsedXML, index, delims);
	        }
	        else
	        {
	        	index = index - parsedXML.length();
	        	//strToken = modifyBuffer.substring(index, modifyBuffer.indexOf(IBDSConstants.Meta.DELIMITER, index));
	        	strToken = substring(modifyBuffer, index, delims);
	        }
			
			if(strToken != null)
			{
				strToken = strToken.trim();
			}
			return strToken;
		}
		catch(Exception e)
		{
			throw new IBDSException(e.getMessage());
		}
	}
	
	public final IBElement getDocumentElement()throws IBDSException
	{
		try
        {
			int[] arrThisNode;
			for(int i=0; i<nodeList.size(); i++)
			{
				arrThisNode = nodeList.get(i);
				if(arrThisNode == null)
					throw new IBDSException("Sevior Error: node array is null at index ["+i+"].");
				if(arrThisNode.length < IBDSConstants.Indexes.INDEX_COUNT)
					throw new IBDSException("Sevior Error: insufficient length ["+arrThisNode.length+"] of node array at index ["+i+"].");
				
				if(arrThisNode[IBDSConstants.Indexes.PARENT_NODE] == IBDSConstants.Directives.NO_VALUE
						&& arrThisNode[IBDSConstants.Indexes.NODE_TYPE] == Node.ELEMENT_NODE)
				{
					IBElement elem = IBDOMFactory.getNewIBElement(this, i);
					return elem;
				}
			}
			return null;
        }
		catch(IBDSException e)
        {
            throw e;
        }
        catch(Exception e)
        {
            throw new IBDSException(e);
        }
	}
	public final IBDocument getOwnerDocument()throws IBDSException
	{
		try
        {
			IBElement elem = this.getDocumentElement();
			return IBDOMFactory.getNewIBDocument(this, elem.getNodeIndex());
        }
		catch(IBDSException e)
        {
            throw e;
        }
        catch(Exception e)
        {
            throw new IBDSException(e);
        }
	}
	
	public final String getNodeName(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
            
			int nameIndex = arrThisNode[IBDSConstants.Indexes.NODE_NAME];
            if(nameIndex < 0)
            	throw new IBDSException("Invalid index ["+nameIndex+"] found for node name.");
            
            String nodeName = getToken(nameIndex, null, true);
            return nodeName;
        }
        catch(IndexOutOfBoundsException e)
        {
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, "Insufficient length of the source string.");
        	throw new IBDSException(e);
        }
        catch(Exception e)
        {
            throw new IBDSException(e);
        }
	}
	
	public final String getNodeValue(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
            
			int valueIndex = arrThisNode[IBDSConstants.Indexes.NODE_VALUE];
            if(valueIndex == IBDSConstants.Directives.NO_VALUE)
            	return "";
			if(valueIndex < 0)
            	throw new IBDSException("Invalid index ["+valueIndex+"] found for node value.");
            
            String nodeValue = getToken(valueIndex, "<", false);
            return nodeValue;
        }
        catch(IndexOutOfBoundsException e)
        {
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, "Insufficient length of the source string.");
        	throw new IBDSException(e.getMessage());
        }
        catch(Exception e)
        {
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final String getAttrName(int nodeIndex, int attrOffset)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
            
			if(arrThisNode.length < (attrOffset + 1))
                throw new IBDSException("Insufficient Length ["+arrThisNode.length+"] of node array found where ["+(attrOffset + 1)+"] or more was expected.");
			
			int nameIndex = arrThisNode[attrOffset];
            
			if(nameIndex < 0)
            	throw new IBDSException("Invalid index ["+nameIndex+"] found for attribute name.");
            
            String attrName = getToken(nameIndex, null, true);
            return attrName;
        }
        catch(IndexOutOfBoundsException e)
        {
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, "Insufficient length of the source string.");
        	throw new IBDSException(e.getMessage());
        }
        catch(Exception e)
        {
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final String getAttrValue(int nodeIndex, int attrOffset)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
            
			if(arrThisNode.length < (attrOffset + 2))
                throw new IBDSException("Insufficient Length ["+arrThisNode.length+"] of node array found where ["+(attrOffset + 2)+"] or more was expected.");
			
			int valueIndex = arrThisNode[attrOffset + 1];
			
			if(valueIndex == IBDSConstants.Directives.NO_VALUE)
            	return "";
			if(valueIndex < 0)
            	throw new IBDSException("Invalid index ["+valueIndex+"] found for attribute value.");
            
            String attrValue = getToken(valueIndex, "\"'", false);
            return attrValue;
        }
        catch(IndexOutOfBoundsException e)
        {
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, "Insufficient length of the source string.");
        	throw new IBDSException(e.getMessage());
        }
        catch(Exception e)
        {
            throw new IBDSException(e.getMessage());
        }
	}
	
	// Element interface
	public final String getAttribute(int nodeIndex, String attribName) throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			if(arrThisNode[IBDSConstants.Indexes.INDEX_COUNT] == IBDSConstants.Directives.ATTRIBUTE_START)
			{
				for(int i=IBDSConstants.Indexes.INDEX_COUNT+1; i < arrThisNode.length; i=i+2)
				{
					int attribNameIndex = arrThisNode[i];
					if(attribNameIndex == IBDSConstants.Directives.CHILDREN_START)
						break;
					
					if(attribName.equals(getToken(attribNameIndex, null, true)))
					{
						int attribValueIndex = arrThisNode[i+1];
						return getToken(attribValueIndex, "\"'", false);
					}
				}
				throw new IBDSException("No attribute found by name ["+attribName+"].");
			}
			else
			{
				throw new IBDSException("This node does not contain attributes.");
			}
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// Element interface
	public final boolean hasAttribute(int nodeIndex, String attribName) throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			if(arrThisNode[IBDSConstants.Indexes.INDEX_COUNT] == IBDSConstants.Directives.ATTRIBUTE_START)
			{
				for(int i=IBDSConstants.Indexes.INDEX_COUNT+1; i < arrThisNode.length; i=i+2)
				{
					int attribNameIndex = arrThisNode[i];
					if(attribNameIndex == IBDSConstants.Directives.CHILDREN_START)
						break;
					
					if(attribName.equals(getToken(attribNameIndex, null, true)))
					{
						return true;
					}
				}
				throw new IBDSException("No attribute found by name ["+attribName+"].");
			}
			else
			{
				throw new IBDSException("This node does not contain attributes.");
			}
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// Element interface
	public final boolean removeAttribute(int nodeIndex, String attribName) throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			if(arrThisNode[IBDSConstants.Indexes.INDEX_COUNT] == IBDSConstants.Directives.ATTRIBUTE_START)
			{
				for(int i=IBDSConstants.Indexes.INDEX_COUNT+1; i < arrThisNode.length; i=i+2)
				{
					int attribNameIndex = arrThisNode[i];
					if(attribNameIndex == IBDSConstants.Directives.CHILDREN_START)
						break;
					
					if(attribName.equals(getToken(attribNameIndex, null, true)))
					{
						int[] arrNewNode;
						// single attribute, no children
						if(arrThisNode.length == IBDSConstants.Indexes.INDEX_COUNT + 3)
						{
							arrNewNode = new int[IBDSConstants.Indexes.INDEX_COUNT];
						}
						// single attribute, has children
						else if(arrThisNode[IBDSConstants.Indexes.INDEX_COUNT + 3] == IBDSConstants.Directives.CHILDREN_START)
						{
							arrNewNode = new int[arrThisNode.length - 3];
							System.arraycopy(arrThisNode, IBDSConstants.Indexes.INDEX_COUNT + 3, arrNewNode, IBDSConstants.Indexes.INDEX_COUNT, arrThisNode.length - (IBDSConstants.Indexes.INDEX_COUNT + 3));
						}
						// attributes & children both
						else
						{
							arrNewNode = new int[arrThisNode.length - 2];
							// before attribute
							System.arraycopy(arrThisNode, IBDSConstants.Indexes.INDEX_COUNT, arrNewNode, IBDSConstants.Indexes.INDEX_COUNT, attribNameIndex - IBDSConstants.Indexes.INDEX_COUNT);
							// after attribute
							System.arraycopy(arrThisNode, attribNameIndex + 2, arrNewNode, attribNameIndex, arrNewNode.length - attribNameIndex);
						}
						// copy node information
						System.arraycopy(arrThisNode, 0, arrNewNode, 0, IBDSConstants.Indexes.INDEX_COUNT);
						
						synchronized(this.nodeList)
						{
							this.nodeList.remove(nodeIndex);
							this.nodeList.add(nodeIndex, arrNewNode);
						}
					}
				}
				throw new IBDSException("No attribute found by name ["+attribName+"].");
			}
			else
			{
				throw new IBDSException("This node does not contain attributes.");
			}
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// Element interface
	public final IBAttribute getAttributeNode(int nodeIndex, String attribName) throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			if(arrThisNode[IBDSConstants.Indexes.INDEX_COUNT] == IBDSConstants.Directives.ATTRIBUTE_START)
			{
				for(int i=IBDSConstants.Indexes.INDEX_COUNT+1; i < arrThisNode.length; i=i+2)
				{
					int attribNameIndex = arrThisNode[i];
					if(attribNameIndex == IBDSConstants.Directives.CHILDREN_START)
						break;
					
					if(attribName.equals(getToken(attribNameIndex, null, true)))
					{
						IBAttribute attr = IBDOMFactory.getNewIBAttribute(this, nodeIndex, attribNameIndex);
						return attr;
					}
				}
				throw new IBDSException("No attribute found by name ["+attribName+"].");
			}
			else
			{
				throw new IBDSException("This node does not contain attributes.");
			}
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final IBNamedNodeMap getAttributes(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			IBNamedNodeMap map = IBDOMFactory.getNewIBNamedNodeMap();
			
			for(int i = IBDSConstants.Indexes.INDEX_COUNT; i < arrThisNode.length; i++)
			{
				if(arrThisNode[i] == IBDSConstants.Directives.ATTRIBUTE_START)
				{
					IBAttribute attrib = null;
					for(int j=(i+1); j < arrThisNode.length; j=j+2)
					{
						if(arrThisNode[j] == IBDSConstants.Directives.CHILDREN_START)
							break;
						
						attrib = IBDOMFactory.getNewIBAttribute(this, nodeIndex, j);
						map.setNamedItem(attrib);
					}
					break;
				}
				else if(arrThisNode[i] == IBDSConstants.Directives.CHILDREN_START)
				{
					break;
				}
			}
			// TODO: map.freezeAddition();
            return map;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(IndexOutOfBoundsException e){
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, "Insufficient length of the source string.");
        	throw new IBDSException(e.getMessage());
        }
        catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final IBNodeList getChildNodes(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			IBNodeList list = IBDOMFactory.getNewIBNodeList();
			
			for(int i = IBDSConstants.Indexes.INDEX_COUNT; i < arrThisNode.length; i++)
			{
				if(arrThisNode[i] == IBDSConstants.Directives.CHILDREN_START)
				{
					IBElement elem = null;
					for(int j=(i+1); j < arrThisNode.length; j++)
					{
						//System.out.print(" "+arrThisNode[j]);
						elem = IBDOMFactory.getNewIBElement(this, arrThisNode[j]);
						list.add(elem);
					}
					break;
				}
			}
			// TODO: list.freezeAddition();
            return list;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(IndexOutOfBoundsException e){
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, "Insufficient length of the source string.");
        	throw new IBDSException(e.getMessage());
        }
        catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// TODO: other type of nodes??
	public final IBNode getFirstChild(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
						
			for(int i = IBDSConstants.Indexes.INDEX_COUNT; i < arrThisNode.length; i++)
			{
				if(arrThisNode[i] == IBDSConstants.Directives.CHILDREN_START)
				{
					int index = arrThisNode[i+1];
					IBElement elem = IBDOMFactory.getNewIBElement(this, index);
					return elem;
				}
			}
			return null;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(IndexOutOfBoundsException e){
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, "Insufficient length of the source string.");
        	throw new IBDSException(e.getMessage());
        }
        catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// TODO: other type of nodes??
	public final IBNode getLastChild(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
						
			for(int i = IBDSConstants.Indexes.INDEX_COUNT; i < arrThisNode.length; i++)
			{
				if(arrThisNode[i] == IBDSConstants.Directives.CHILDREN_START)
				{
					int index = arrThisNode[arrThisNode.length - 1];
					IBElement elem = IBDOMFactory.getNewIBElement(this, index);
					return elem;
				}
			}
			return null;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(IndexOutOfBoundsException e){
            //throw new IBDOMException(IBDOMExceptionCodes.NODE_LOCATE_FAILURE, "Insufficient length of the source string.");
        	throw new IBDSException(e.getMessage());
        }
        catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// TODO: check if wrong; also check getNodeName 
	public final String getLocalName(int nodeIndex)throws IBDSException
	{
		return getNodeName(nodeIndex);
	}
	
	public final short getNodeType(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			return (short)arrThisNode[IBDSConstants.Indexes.NODE_TYPE];
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final IBNode getParentNode(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			if(arrThisNode[IBDSConstants.Indexes.PARENT_NODE] == IBDSConstants.Directives.NO_VALUE)
				throw new IBDSException("root level nodes do not has a parent.");				

			IBNode node = IBDOMFactory.getNewIBElement(this, arrThisNode[IBDSConstants.Indexes.PARENT_NODE]);
			return node;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final boolean hasAttributes(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			for(int i=IBDSConstants.Indexes.INDEX_COUNT; i<arrThisNode.length; i++)
			{
				if(arrThisNode[i] == IBDSConstants.Directives.ATTRIBUTE_START)
					return true;
			}
			return false;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final boolean hasChildNodes(int nodeIndex)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			for(int i=IBDSConstants.Indexes.INDEX_COUNT; i<arrThisNode.length; i++)
			{
				if(arrThisNode[i] == IBDSConstants.Directives.CHILDREN_START)
					return true;
			}
			return false;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// *** Run time modifications this onwards ***
	
	// TODO: should this operation be recursive -- yes?
	public final IBNode removeChild(int nodeIndex, IBNode child)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			for(int i=IBDSConstants.Indexes.INDEX_COUNT; i<arrThisNode.length; i++)
			{
				if(arrThisNode[i] == IBDSConstants.Directives.CHILDREN_START)
				{
					for(int j=i+1; j<arrThisNode.length; j++)
					{
						if(arrThisNode[j] == child.getNodeIndex())
						{
							int[] arrNewNode = new int[arrThisNode.length - 1];
							System.arraycopy(arrThisNode, 0, arrNewNode, 0, j);
							if((j+1) < arrThisNode.length)
								System.arraycopy(arrThisNode, j+1, arrNewNode, j, arrNewNode.length - (j+1));
							synchronized(this.nodeList)
							{
								this.nodeList.remove(child.getNodeIndex());
								this.nodeList.add(child.getNodeIndex(), arrNewNode);
							}
							
							// INFO: JAXP recommends returning the node which does not exists now.
							// TODO: should this child node return node name and value now also?
							return child;
						}
					}
					throw new IBDSException("The child does not belongs to this node.");
				}
			}
			throw new IBDSException("This node does not contain children.");
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final IBNode replaceChild(int nodeIndex, IBNode newChild, IBNode oldChild) throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			int[] arrNewChild = getNodeArray(newChild.getNodeIndex());
			for(int i=IBDSConstants.Indexes.INDEX_COUNT; i<arrThisNode.length; i++)
			{
				if(arrThisNode[i] == IBDSConstants.Directives.CHILDREN_START)
				{
					for(int j=i+1; j<arrThisNode.length; j++)
					{
						if(arrThisNode[j] == oldChild.getNodeIndex())
						{
							synchronized(arrThisNode)
							{
								arrThisNode[j] = newChild.getNodeIndex();
							}
							synchronized(arrNewChild)
							{
								arrNewChild[IBDSConstants.Indexes.PARENT_NODE] = nodeIndex;
							}
							// INFO: JAXP recommends returning the node which does not exists now.
							// TODO: should the old node be removed from the DS?
							return oldChild;
						}
					}
					throw new IBDSException("The old child does not belongs to this node.");
				}
			}
			throw new IBDSException("This node does not contain children.");
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e);
        }
	}
	
	public final void setNodeValue(int nodeIndex, String nodeValue)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			int valueIndex = parsedXML.length() + modifyBuffer.length();
			modifyBuffer.append(nodeValue);
			modifyBuffer.append(IBDSConstants.Meta.DELIMITER);
			arrThisNode[IBDSConstants.Indexes.NODE_VALUE] = valueIndex;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// Element Interface
	public final boolean setAttribute(int nodeIndex, String name, String value) throws IBDSException
	{
		try
        {
			if(name == null || name.equals(""))
				throw new IBDSException("The attribute name passed is null.");
			
			int[] arrThisNode = getNodeArray(nodeIndex);
			if(arrThisNode[IBDSConstants.Indexes.INDEX_COUNT] == IBDSConstants.Directives.ATTRIBUTE_START)
			{
				for(int i=IBDSConstants.Indexes.INDEX_COUNT+1; i < arrThisNode.length; i=i+2)
				{
					int attribNameIndex = arrThisNode[i];
					if(attribNameIndex == IBDSConstants.Directives.CHILDREN_START)
						break;
					
					// Found attribute by name
					if(name.equals(getToken(attribNameIndex, null, true)))
					{
						if(value == null || value.equals("")){
							arrThisNode[attribNameIndex + 1] = IBDSConstants.Directives.NO_VALUE;
						}
						else{
							// TODO: appending quotes is a must for attributes ?? NO
							int valueIndex = this.modifyBuffer.length();
							this.modifyBuffer.append(value);
							this.modifyBuffer.append(IBDSConstants.Meta.DELIMITER);
							arrThisNode[attribNameIndex + 1] = valueIndex;
							
							return true;
						}
					}
				}
			}
			// No attribute found by name; or This node does not contain attributes.
			return this.addAttribute(nodeIndex, name, value);
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	public final boolean addAttribute(int nodeIndex, String name, String value)throws IBDSException
	{
		try
        {
			int[] arrThisNode = getNodeArray(nodeIndex);
			int[] arrNewNode = IBNodeArrayUtil.addAttribute(arrThisNode, name, value);
			synchronized(this.nodeList)
			{
				this.nodeList.remove(nodeIndex);
				this.nodeList.add(nodeIndex, arrNewNode);
			}
			return true;
        }
		catch(IBDSException e){
        	throw e;
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	
	// Dummy Attributes & Nodes
	public final TmpAttribute createTmpAttribute(String name, String value)throws IBDSException
	{
		try
        {
			TmpAttribute attr = TmpNodeFactory.getNewTmpAttribute(this, name, value);
			return attr;
        }
		catch(IBDOMException e){
        	throw new IBDSException(e);
        }
		catch(Exception e){
            throw new IBDSException(e);
        }
	}
	public final TmpElement createTmpElement(String name)throws IBDSException
	{
		try
        {
			TmpElement elem = TmpNodeFactory.getNewTmpElement(this, name);
			return elem;
        }
		catch(IBDOMException e){
        	throw new IBDSException(e);
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
	public final String printNodeIndexes()throws IBDSException
	{
		try
        {
			StringBuffer sb = new StringBuffer();
			int[] node;
			for(int i=0; i<nodeList.size(); i++)
			{
				node = nodeList.get(i);
				sb.append("\n");
				for(int j=0; j<node.length; j++)
					sb.append(node[j]).append("  ");
			}
			return sb.toString();
        }
		catch(IBDOMException e){
        	throw new IBDSException(e);
        }
		catch(Exception e){
            throw new IBDSException(e.getMessage());
        }
	}
}
/** Points should be noted:
 *  1. Any token will COMPLETELY fall either in the parsed XML string or in the modify buffer but will never belong to both.
 *  2. Attributes should always arrive before the Children in the node array  
 */
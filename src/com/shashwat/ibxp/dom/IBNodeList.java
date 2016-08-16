package com.shashwat.ibxp.dom;

import java.util.ArrayList;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:30:28 PM
 * If a DOM user gets a NodeList  object containing the children of an Element, then subsequently 
 * adds more children to that element (or removes children, or modifies them), those changes are 
 * automatically reflected in the NodeList, without further action on the user's part. Likewise, 
 * changes to a Node in the tree are reflected in all references to that Node in NodeList and 
 * NamedNodeMap  objects.
 */
// TODO: exception handling
//TODO: list.freezeAddition();
public class IBNodeList implements NodeList
{
    ArrayList<IBNode> list = null;
	protected IBNodeList()
    {
    	list = new ArrayList<IBNode>();
    }
	
	public boolean add(IBNode node)
	{
		return list.add(node);
	}
    
	public Node item(int index) {
        return list.get(index);
    }

    public int getLength() {
        return list.size();
    }
}

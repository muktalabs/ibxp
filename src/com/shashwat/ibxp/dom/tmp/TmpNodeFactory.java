package com.shashwat.ibxp.dom.tmp;

import com.shashwat.ibxp.dom.IBDOMException;
import com.shashwat.ibxp.parser.IBDSHelper;

import org.w3c.dom.Node;

public class TmpNodeFactory 
{
	// No instance needed.
	private TmpNodeFactory()
	{}
	
	public static TmpAttribute getNewTmpAttribute(IBDSHelper ds, String name, String value)throws IBDOMException
	{
		return new TmpAttribute(ds, name, value);
	}
	public static TmpElement getNewTmpElement(IBDSHelper ds, String name)throws IBDOMException
	{
		short nodeType = Node.ELEMENT_NODE;
		return new TmpElement(ds, name, nodeType);
	}	
}

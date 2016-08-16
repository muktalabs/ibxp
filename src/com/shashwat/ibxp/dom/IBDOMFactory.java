package com.shashwat.ibxp.dom;

import com.shashwat.ibxp.parser.IBDSHelper;

/*
 * Most of the APIs defined by DOM specification are interfaces rather than classes. 
 * That means that ordinary constructors (in the Java or C++ sense) cannot be used to create 
 * DOM objects, since the underlying objects to be constructed may have little relationship to 
 * the DOM interfaces. 
 * The conventional solution to this in object-oriented design is to define factory methods that 
 * create instances of objects that implement the various interfaces. 
 * Objects implementing some interface "X" are created by a "createX()" method on the Document 
 * interface; this is because all DOM objects live in the context of a specific Document.
 */
public class IBDOMFactory 
{
	// No instance needed.
	private IBDOMFactory()
	{}
	
	public static final IBNamedNodeMap getNewIBNamedNodeMap()
	{
		return new IBNamedNodeMap();
	}
	public static final IBNodeList getNewIBNodeList()
	{
		return new IBNodeList();
	}
	public static final IBDocument getNewIBDocument(IBDSHelper ds, int nodeIndex)
	{
		return new IBDocument(ds, nodeIndex);
	}
	
	public static final IBElement getNewIBElement(IBDSHelper ds, int nodeIndex)
	{
		return new IBElement(ds, nodeIndex);
	}
	public static final IBAttribute getNewIBAttribute(IBDSHelper ds, int nodeIndex, int nodeOffset)
	{
		return new IBAttribute(ds, nodeIndex, nodeOffset);
	}
}

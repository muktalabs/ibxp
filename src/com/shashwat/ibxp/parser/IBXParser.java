package com.shashwat.ibxp.parser;

//import java.io.File;

import org.w3c.dom.Node;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.apache.xerces.parsers.SAXParser;

import com.shashwat.ibxp.dom.IBDocument;
import com.shashwat.ibxp.util.IntStack;

public class IBXParser extends DefaultHandler
{
	IBDSHelper ds;
	StringBuffer sbXML;
	public static final int parentIndex = IBDSConstants.Directives.NO_VALUE;
	int [] currentNode = null;
	IntStack nodeStack;
	
	public void startDocument()
	{
		//System.out.println("start document");
	}
	
	public void endDocument() 
	{
		ds.parsedXML = sbXML.toString();
		ds.lastUpdated = System.nanoTime();
		//System.out.println("end document " + sbXML.length());
	}
	
	public void startElement(String uri, String localName,
			String qName, Attributes attributes)
	{
		try
		{
			// initial array size = no. of fixed indexes
			int parentIndex = -1;
			int arrSize = IBDSConstants.Indexes.INDEX_COUNT;
			if(attributes != null && attributes.getLength() > 0)
				arrSize = arrSize + 1 + attributes.getLength() * 2; // +1 => for the ATTRIBUTE_START directive '-2'
			
			// Initialize the node array
			currentNode = new int[arrSize];
			// early addition of node to the list
			ds.nodeList.add(currentNode);
			
			// Index: assigning parent's index to the node array 
			currentNode[IBDSConstants.Indexes.PARENT_NODE] = nodeStack.peek();
			// Index: assigning node type to the node array
			currentNode[IBDSConstants.Indexes.NODE_TYPE] = Node.ELEMENT_NODE;
			// Index: assigning index of name-space to the node array
			// TODO: implementation pending in version 2.1
			currentNode[IBDSConstants.Indexes.NAMESPACE] = 0;
			
			// get parent index in local variable
			parentIndex = nodeStack.peek();
			
			// Stack: push current node's index in the stack
			nodeStack.push(ds.nodeList.size() - 1);
			
			// Meta: appending '<' before node start
			sbXML.append(IBDSConstants.Meta.ELEMENT_PREFIX);
			// Index: assigning node name's index to the node array
			currentNode[IBDSConstants.Indexes.NODE_NAME] = sbXML.length();
			// Data: appending the Node Name
			sbXML.append(qName);
			// Meta: appending '<' before node's position
			sbXML.append(IBDSConstants.Meta.ELEMENT_PREFIX);
			// Meta: appending the Node's index
			sbXML.append(nodeStack.peek());
			// Meta: appending " " after Node Name
			sbXML.append(IBDSConstants.Meta.DELIMITER);
			
			// Index: assign 'no value' to node value
			currentNode[IBDSConstants.Indexes.NODE_VALUE] = IBDSConstants.Directives.NO_VALUE;
			
			int nAttribs = attributes.getLength();
			// adding node attributes to the data structure
			if(attributes != null && nAttribs > 0)
			{
				// Index/Meta: adding '-2' as the attribute start directive
				currentNode[IBDSConstants.Indexes.INDEX_COUNT] = IBDSConstants.Directives.ATTRIBUTE_START;
				// iterate through all the attributes
				for (int i=0; i<nAttribs; i++)
				{
					// +1: INDEX_COUNT position contains the '-2' directive
					int index = IBDSConstants.Indexes.INDEX_COUNT + 1 + i*2;
					// Index: assigning attribute name's index to the node array
					currentNode[index] = sbXML.length();
					// Data: append node name
					sbXML.append(attributes.getQName(i));
					// Meta: append delimiter
					sbXML.append(IBDSConstants.Meta.DELIMITER);
					
					// Meta: adding quotes '"' around attribute value
					sbXML.append(IBDSConstants.Meta.QUOTE);
					// Index: assigning attribute value's index to the node array
					currentNode[index + 1] = sbXML.length();
					// Data: appending node value
					if(attributes.getValue(i) != null)
						sbXML.append(attributes.getValue(i).trim());
					// Meta: adding quotes '"' around attribute value
					sbXML.append(IBDSConstants.Meta.QUOTE);
					
					// Meta: append delimiter
					sbXML.append(IBDSConstants.Meta.DELIMITER);
				}
			}
			
			// adding child index to the parent
			if(parentIndex != -1)
			{
				int[] parentNode = (int []) ds.nodeList.get(parentIndex);
				int length = parentNode.length;
				// null pointer above
				int childStart = -1;
				int indexCount = IBDSConstants.Indexes.INDEX_COUNT;
				for(int i=length-1; i>=indexCount; i--)
				{
					if(parentNode[i] == -3)
					{
						childStart = i;
						break;
					}
				}
				int[] newArray;
				if(childStart == -1)
				{
					newArray = new int[length+2];
					System.arraycopy(parentNode, 0, newArray, 0, length);
					newArray[newArray.length - 2] = -3;
				}
				else
				{
					newArray = new int[length+1];
					System.arraycopy(parentNode, 0, newArray, 0, length);
				}
				
				newArray[newArray.length - 1] = nodeStack.peek();
				synchronized(ds.nodeList)
				{
					ds.nodeList.remove(parentIndex);
					ds.nodeList.add(parentIndex, newArray);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void endElement(String uri, String localName, String qName) 
	{
		// System.out.println("end element: " + qName);
		// Stack: pop current node's index from the stack
		nodeStack.pop();
	}
	
	public void ignorableWhitespace(char[] ch, int start, int length) 
	{
		// System.out.println("whitespace, length " + length);
	}
	
	public void processingInstruction(String target, String data)
	{
		// System.out.println("processing instruction: " + target);
	}
	
	public void characters(char[] ch, int start, int length)
	{
		String strChars = new String(ch,start,length);
		// System.out.println("character data, length " + length);
		// System.out.println("Characters = " + strChars);
		
		// Trimming the character sequence
		if(strChars != null)
			strChars = strChars.trim();
		
		if(strChars == null || strChars.equals(""))
			return;
		
		// Meta: adding quotes '"' around attribute value
		sbXML.append(IBDSConstants.Meta.QUOTE);
		// Index: assigning node value's index to the node array
		currentNode[IBDSConstants.Indexes.NODE_VALUE] = sbXML.length();
		// Data: append node value
		sbXML.append(strChars);
		// Meta: adding quotes '"' around attribute value
		sbXML.append(IBDSConstants.Meta.QUOTE);
		// Meta: append delimiter
		sbXML.append(IBDSConstants.Meta.DELIMITER);
	}
	
	private IBXParser()
	{
		ds = new IBDSHelper();
		sbXML = new StringBuffer(256);
		nodeStack = new IntStack(10, 10);
	}
	
	public static IBXParser newInstance()
	{
		IBXParser instance = new IBXParser();
		return instance;
	}
	
	public IBDocument parse(String fileName)throws Exception
	{
		//System.out.println("IBXP: "+fileName);
		SAXParser p = new SAXParser();
		//Runtime rt = Runtime.getRuntime();
		p.setContentHandler(this);
		try
		{
			//File fin = new File(fileName);
						
			//long startMem = rt.totalMemory() - rt.freeMemory();
			
			long time = System.currentTimeMillis();
			p.parse(fileName);
			time = System.currentTimeMillis() - time;
			
//			Thread.currentThread().sleep(50);
//			rt.gc();
//			rt.gc();
//			rt.gc();
//			rt.gc();
//			Thread.currentThread().sleep(200);
			
			//long endMem = rt.totalMemory() - rt.freeMemory();
			
			System.out.println("time elapsed = " + time + " ms.");
			System.out.println(ds.printNodeIndexes());
//			System.out.println("Memory Use: " + ((float) endMem - startMem)/(1<<20) + " MB.");
//			System.out.println("Multiplying factor: " + ((float) endMem - startMem)/fin.length() );
			
			//System.out.println(this.sbXML.toString());
			//this.ds.printNodeIndexes(System.out);
			return ds.getOwnerDocument();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String[] args)
	{
		try{
			IBXParser t = IBXParser.newInstance();
			if(args.length > 0)
				t.parse(args[0]);
			else
				t.parse("D:\\workspace\\IBXP\\test\\sample.xml");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

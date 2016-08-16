package com.shashwat.ibxp.test;

import org.w3c.dom.*;
import com.shashwat.ibxp.parser.IBXParser;

public class IBXPTest 
{
	public static void main(String[] args)
	{
		try{
			String fileName = "D:/workspace/IBXP/test/test2.xml";
			IBXParser parser = IBXParser.newInstance();
			Document doc = parser.parse(fileName);
			Element elem = doc.getDocumentElement();
			printDetail(elem, true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void printDetail(Element elem, boolean recursive)
	{
		try{
			System.out.println("\nStarting Node: "+elem.getNodeName());
			System.out.println("Node Value: "+elem.getNodeValue());
			NamedNodeMap attribs = elem.getAttributes();
			Attr attrib = null;
			System.out.println("Attributes:");
			for(int i=0; i<attribs.getLength(); i++){
				attrib = (Attr)attribs.item(i);
				System.out.println(attrib.getName()+" = "+attrib.getValue());
			}
			if(recursive){
				NodeList children = elem.getChildNodes();
				System.out.println("No. of children: "+children.getLength());
				for(int j=0; j<children.getLength(); j++)
				{
					printDetail((Element)children.item(j), true);
				}
			}
			System.out.println("Ending Node: "+elem.getNodeName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

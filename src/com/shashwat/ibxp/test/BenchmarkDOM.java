package com.shashwat.ibxp.test;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



public class BenchmarkDOM 
{
	static Runtime rt;
	
	static void evaluateDOM(String fileName)
	{
		//System.out.println("DOM: "+fileName);
		File f = new File(fileName);
		try
		{
			FileInputStream fis = new FileInputStream(f);
			rt = Runtime.getRuntime();
			byte[] ba = new byte[(int)f.length()];
			fis.read(ba); 
			long startMem = rt.totalMemory() - rt.freeMemory();
				    
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//factory.setNamespaceAware(true);
			//factory.setExpandEntityReferences(false);
			DocumentBuilder parser = factory.newDocumentBuilder();
			ByteArrayInputStream bais = new ByteArrayInputStream(ba);
			
			long time = System.currentTimeMillis();
			parser.parse(bais);
			time = System.currentTimeMillis() - time;
			
//			Thread.currentThread().sleep(50);
//			rt.gc();
//			rt.gc();
//			rt.gc();
//			rt.gc();
//			Thread.currentThread().sleep(200);
			
			long endMem = rt.totalMemory() - rt.freeMemory();
			System.out.println("Time elapsed: "+ time +" ms.");
//			System.out.println("Memory Use: " + ((float) endMem - startMem)/(1<<20) + " MB.");
//			System.out.println("Multiplying factor: " + ((float) endMem - startMem)/f.length() );
		}
		catch (Exception e)
		{
			System.out.println("exception ==> "+e);
		}
	}
	
	public static void main(String[] args)
	{
		if(args.length > 0)
			evaluateDOM(args[0]);
		else
			evaluateDOM("D:/workspace/IBXP/test/sample.xml");
	}
}
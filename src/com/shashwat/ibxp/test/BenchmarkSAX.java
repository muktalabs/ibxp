package com.shashwat.ibxp.test;

import org.apache.xerces.parsers.SAXParser;

public class BenchmarkSAX {
	static Runtime rt;
		
	public void evaluateSAX(String fileName)
	{
		//System.out.println("SAX: "+fileName);
		try
		{
			rt = Runtime.getRuntime();
			long startMem = rt.totalMemory() - rt.freeMemory();
				    
			SAXParser p = new SAXParser();
			//p.setContentHandler(this);
			
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
			System.out.println("Time elapsed: "+ time +" ms.");
			//System.out.println("Memory Use: " + ((float) endMem - startMem)/(1<<20) + " MB.");
		}
		catch (Exception e)
		{
			System.out.println("exception ==> "+e);
		}
	}
		
	public static void main(String[] args)
	{
		BenchmarkSAX bx = new BenchmarkSAX();
		if(args.length > 0)
			bx.evaluateSAX(args[0]);
		else
			bx.evaluateSAX("D:/workspace/IBXP/test/sample.xml");
	}
}


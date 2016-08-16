package com.shashwat.ibxp.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * com.shashwat.ibxp.parser.IBDS
 * @author: Upendra Jariya
 * @date: May 20, 2008
 * @time: 3:17:19 AM
 */

public abstract class IBDS
{
    // Used to store the modified XML string (input) and metadata.
    // indexed from 0.
	protected String parsedXML = null;
    // Buffer for runtime modifications in the DOM. Only space characters, no other delimeters :)
    // Indexed after the source string.
    protected StringBuffer modifyBuffer = null;
    // Array of Objects... Used to save element/attribute values if they are objects and not string.
    // Indexed by -ve values after reserved ones.
    //ArrayList objectArray = null;
    // array of int/short arrays
    protected ArrayList<int []> nodeList = null;
    // TODO: not in use now
    long lastUpdated = 0;

    // constructed only from wrapper class IBDSHelper
    protected IBDS()
    {
    	this.modifyBuffer = new StringBuffer(300); // all update operations belong to this only
        this.nodeList = new ArrayList<int []>(50);
        this.lastUpdated = System.nanoTime();
        //this.objectArray = new ArrayList();
    }
    
    public final void serialize(OutputStream out){
        // TODO: implementation... XMLSerializer ???
    }
    
    public String toString(){
        // TODO: use serialize() method
    	return "todo: use serialize() method";
    }
    
    public final List<int []> getAllNodes(){
        return this.nodeList;
    }
    
    public void printNodeIndexes(PrintStream pw)
    {
    	Iterator<int []> iter = nodeList.iterator();
    	while(iter.hasNext())
    	{
    		int [] node = iter.next();
    		for (int i=0; i<node.length; i++)
    		{
    			pw.print(node[i]);
    			pw.print("\t");
    		}
    		pw.println("");
    	}
    }
    /*public long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}*/
}

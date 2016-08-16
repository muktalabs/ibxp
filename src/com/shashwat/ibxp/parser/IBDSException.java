package com.shashwat.ibxp.parser;

import com.shashwat.ibxp.IBXPException;

public class IBDSException extends IBXPException 
{
	static final long serialVersionUID = 5445;
	
	public IBDSException(String str)
	{
		super(str);
	}
	public IBDSException(Throwable t)
	{
		super(t.getMessage());
		t.printStackTrace();
	}
}

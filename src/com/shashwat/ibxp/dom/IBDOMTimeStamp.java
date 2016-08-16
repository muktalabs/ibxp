package com.shashwat.ibxp.dom;

public class IBDOMTimeStamp
{
	private long timeStamp;

	public IBDOMTimeStamp() {
		this(System.currentTimeMillis());
		// TODO: use Nano-Seconds??
		//this(System.nanoTime());
	}
	public IBDOMTimeStamp(long timeStamp) {
		super();
		this.timeStamp = timeStamp;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}

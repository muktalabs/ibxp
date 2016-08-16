package com.shashwat.ibxp.util;

public class IntStack
{
	private int size;
	private int emptyStack;
	private int increment;
	private int top;
	private int[] items;
	
	public IntStack(int initialSize, int increment)
	{
		this.size= initialSize;
		this.increment = increment;
		emptyStack = -1;
		top = emptyStack;
		items = new int[size];
	}
	
	public void push(int in)
	{
		if(this.full())
		{
			int [] newArr = new int[items.length + increment];
			System.arraycopy(items, 0, newArr, 0, items.length);
			size = items.length + increment;
			items = newArr;
		}
		
		items[++top] = in;
	}
	
	public int pop()
	{
		if (top < 0)
		{
			// TODO: throw exception.
			// throw new IBXPException("Failed to pop, the Stack is empty.");
		}
		return items[top--];
	}
	
	public int peek()
	{
		if(top < 0)
			return -1;
		
		return items[top];
	}
	
	public boolean empty()
	{
		return top == emptyStack;
	}
	
	public boolean full()
	{
		return top + 1 == size;
	}
}

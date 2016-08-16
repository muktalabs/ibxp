package com.shashwat.ibxp.parser;

public interface IBDSConstants
{
	public static interface Indexes
    {
        // Indexes...
        public static final short PARENT_NODE = 0;
        public static final short NODE_TYPE = 1;
        public static final short NAMESPACE = 2;
        public static final short NODE_NAME = 3;
        public static final short NODE_VALUE = 4;
        
        public static final short INDEX_COUNT = 5;
    }

    public static interface Directives
    {
        // Directives...
        public static final short MAX_DIRECTIVE = -10;
        public static final short NO_VALUE = -1;
        public static final short ATTRIBUTE_START = -2;
        public static final short CHILDREN_START = -3;
    }
    
    public static interface Meta
    {
    	public static final char ELEMENT_PREFIX = '<';
    	public static final char POSITION_PREFIX = '<';
    	public static final char QUOTE = '"';
    	public static final String DELIMITER = " <";
    }
}

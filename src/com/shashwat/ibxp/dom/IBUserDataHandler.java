package com.shashwat.ibxp.dom;

import org.w3c.dom.UserDataHandler;
import org.w3c.dom.Node;

/**
 * @author: ujariya
 * @date: Mar 14, 2008
 * @time: 12:43:08 PM
 */
public class IBUserDataHandler implements UserDataHandler
{
    public void handle(short operation, String key, Object data, Node src, Node dst) {
        /** org.w3c.dom.UserDataHandler Field Summary
         * static short 	NODE_ADOPTED          The node is adopted, using Document.adoptNode().
         * static short 	NODE_CLONED          The node is cloned, using Node.cloneNode().
         * static short 	NODE_DELETED          The node is deleted.
         * static short 	NODE_IMPORTED          The node is imported, using Document.importNode().
         * static short 	NODE_RENAMED          The node is renamed, using Document.renameNode().
         */
        // TODO: implementation...
    }
}

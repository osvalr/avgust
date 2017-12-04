package com.sakerk.generador.fdb;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.FromBaseTable;
import com.foundationdb.sql.parser.FromList;
import com.foundationdb.sql.parser.SelectNode;
import com.foundationdb.sql.parser.Visitable;
import com.foundationdb.sql.parser.Visitor;

public class QueryVisitor implements Visitor {
	
         public int beginOffSetFrom = -1;
         public int EndOffSetFrom = -1;
         
         public int beginOffSetSelect = -1;
         public int EndOffSetSelect = -1;

         public Visitable visit(Visitable node) throws StandardException {

             if(node instanceof FromList) {
            	 FromList sn = (FromList)node;
                 beginOffSetFrom = sn.getBeginOffset();
                 EndOffSetFrom = sn.getEndOffset();
             }
             
             if(node instanceof SelectNode) {
            	 FromBaseTable sn = (FromBaseTable)node;
            	 beginOffSetSelect = sn.getBeginOffset();
            	 EndOffSetSelect = sn.getEndOffset();
             }

             return node;
         }
 
         public boolean visitChildrenFirst(Visitable node) {
             return false;
         }
 
         public boolean stopTraversal() {
             return false;
         }
 
         public boolean skipChildren(Visitable node) throws StandardException {
             return false;
         }
     }
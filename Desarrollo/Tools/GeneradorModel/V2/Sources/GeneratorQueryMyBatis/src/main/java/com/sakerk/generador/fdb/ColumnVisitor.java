package com.sakerk.generador.fdb;

import java.util.HashSet;
import java.util.Set;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.ColumnReference;
import com.foundationdb.sql.parser.Visitable;
import com.foundationdb.sql.parser.Visitor;

public class ColumnVisitor implements Visitor {
         public Set<String> columns = new HashSet<String>();

         public Visitable visit(Visitable node) throws StandardException {
        	 
        	 
             if(node instanceof ColumnReference) {
            	 ColumnReference sn = (ColumnReference)node;
                 columns.add(sn.getColumnName()); 
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
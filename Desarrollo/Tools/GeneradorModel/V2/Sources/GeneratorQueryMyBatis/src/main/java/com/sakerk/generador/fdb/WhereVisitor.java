package com.sakerk.generador.fdb;

import java.util.ArrayList;
import java.util.List;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.SelectNode;
import com.foundationdb.sql.parser.ValueNode;
import com.foundationdb.sql.parser.Visitable;
import com.foundationdb.sql.parser.Visitor;

public class WhereVisitor implements Visitor {
         public List<ValueNode> whereClauses = new ArrayList<ValueNode>();

         public Visitable visit(Visitable node) throws StandardException {
        	 
        	 
             if(node instanceof SelectNode) {
                 SelectNode sn = (SelectNode)node;
                 whereClauses.add(sn.getWhereClause()); 
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
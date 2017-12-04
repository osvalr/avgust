/**
 * Copyright (c) 2013 Nathan Williams
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package pe.com.jrtotem.app.generator.util;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.BinaryComparisonOperatorNode;
import com.foundationdb.sql.parser.ColumnReference;
import com.foundationdb.sql.parser.FromBaseTable;
import com.foundationdb.sql.parser.NodeTypes;
import com.foundationdb.sql.parser.QueryTreeNode;
import com.foundationdb.sql.parser.SelectNode;
import com.foundationdb.sql.parser.ValueNode;
import com.foundationdb.sql.parser.Visitable;
import com.foundationdb.sql.parser.Visitor;

public class QueryTreeVisitor implements Visitor {
    private boolean onFirst = true;
    @SuppressWarnings("unused")
	private boolean didPrint = false;

    private static String qualify(String s) {
        return (s != null) ? s + "." : "";
    }

    @SuppressWarnings("unused")
	@Override
    public Visitable visit(Visitable visitable) throws StandardException {
        QueryTreeNode node = (QueryTreeNode)visitable;

        if(onFirst) {
//            System.out.println("Statement: " + node.getClass().getSimpleName());
            onFirst = false;
        }

        String column = null;
        if(node.getNodeType() == NodeTypes.COLUMN_REFERENCE) {
            ColumnReference ref = (ColumnReference)node;
            column = qualify(ref.getSchemaName()) + qualify(ref.getTableName()) + ref.getColumnName();
        } else if(node.getNodeType() == NodeTypes.ALL_RESULT_COLUMN) {
            column = "*";
        }
        
        if(node.getNodeType() == NodeTypes.BINARY_EQUALS_OPERATOR_NODE) {
        	BinaryComparisonOperatorNode ref = (BinaryComparisonOperatorNode)node;
//        	System.out.println(ref.getColumnName());
        }

        if(column != null) {
//            System.out.print(didPrint ? ", " : "  ");
//            System.out.print(column);
            didPrint = true;
        }
        
//        System.out.println("Tables: ");
        if (node.getNodeType() == NodeTypes.FROM_BASE_TABLE) {
        	
            FromBaseTable table = (FromBaseTable)node;
//            System.out.println(table.getTableName() +" : "+ table.getOrigTableName());
         } 
        
        if(node instanceof SelectNode) {
            SelectNode sn = (SelectNode)node;
//            whereClauses.add(sn.getWhereClause());
            ValueNode vn = sn.getWhereClause();
            System.out.println(sn.getWhereClause().getColumnName());
        }

        return visitable;
    }

    @Override
    public boolean visitChildrenFirst(Visitable node) {
        return false;
    }

    @Override
    public boolean stopTraversal() {
        return false;
    }

    @Override
    public boolean skipChildren(Visitable node) throws StandardException {
        return false;
    }
}

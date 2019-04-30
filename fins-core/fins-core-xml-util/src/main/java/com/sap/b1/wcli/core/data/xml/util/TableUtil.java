package com.sap.b1.wcli.core.data.xml.util;

import com.sap.b1.wcli.core.data.xml.schema.tables.Column;
import com.sap.b1.wcli.core.data.xml.schema.tables.Domain;
import com.sap.b1.wcli.core.data.xml.schema.tables.Key;
import com.sap.b1.wcli.core.data.xml.schema.tables.Table;
import com.sap.b1.wcli.core.data.xml.schema.tables.ViewType;

public class TableUtil 
{
	public static boolean isCompositeKey(Table table)
	{
		Key pk = getPrimaryKey(table);
		if(pk == null) return false;
		return pk.getColumn().size()>1;
		
	}
	
	public static Key getPrimaryKey(Table table)
	{
		for(Key key:table.getKey())
		{
			if(key.getId().equals("PRIMARY"))
			{
				return key;
			}
		}
		if(table.getKey().size()==1 && table.getKey().get(0).getUnique()!=null)
		{
			return table.getKey().get(0);
		}
		return null;
	}
	public static boolean isIdColumn(Table table, Column col)
	{
		return col.getId().equals("Id");
	}
	public static boolean isTable(Table table)
	{
		if(table.getViewType()==ViewType.INVISIBLE)
		{
			return false;
		}
		if(table.getVirtual()!=null)
		{
			return false;
		}
		return true;
	}
	public static Column getColumn(Table table, String colName)
	{
		return table.getColumn().stream()
				.filter(a->a.getId().equals(colName)).findFirst()
				.get();	
	}
}

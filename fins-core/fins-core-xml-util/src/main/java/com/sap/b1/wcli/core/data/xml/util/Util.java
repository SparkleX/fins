package com.sap.b1.wcli.core.data.xml.util;

import java.beans.Introspector;

import com.sap.b1.wcli.core.data.xml.schema.tables.DbType;


public class Util 
{
	public static boolean isKeyWords(String name)
	{
		switch(name)
		{
		case "protected":
		case "break":
		case "class":
		case "default":
		case "import":
		case "final":
			return true;
		}
		return false;
	}
	public static String decapitalize(String name)
	{
		String value = Introspector.decapitalize(name);
		return value + (isKeyWords(value)?"Z":"");
	}
	
	public static String convertDbType(DbType type)
	{
		switch(type)
		{
	    case ALPHA_NUMERIC:
	    case TEXT:
	    	return "String";
	    case INTEGER:
	    case IDENTITY:
	    	return "Integer";
	    case FLOAT:
	    	return "BigDecimal";
	    case DATE:
	    	return "Timestamp";
		}
	    throw new RuntimeException(String.format("Unkonwn dbType", type));

	}
	public static String toSqlType(DbType type)
	{
		switch(type)
		{
	    case ALPHA_NUMERIC:
	    case TEXT:
	    	return "varchar(50)";
	    case INTEGER:
	    case IDENTITY:
	    	return "int";
	    case FLOAT:
	    	return "decimal(19,6)";
	    case DATE:
	    	return "date";
		}
	    throw new RuntimeException(String.format("Unkonwn dbType", type));

	}
}

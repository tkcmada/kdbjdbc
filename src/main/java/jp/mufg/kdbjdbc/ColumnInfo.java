package jp.mufg.kdbjdbc;

import java.sql.Types;

public class ColumnInfo {

	private final String name;
	private final String typename;
    private final boolean nullable;
    private final int type;
    public final int actualColumnNumber;

	public ColumnInfo(String name, String typename, boolean nullable, int actualColumnNumber) {
		super();
        this.name = name;
		this.typename = typename;
        if(typename.equals("int4") || typename.equals("i"))
            this.type = Types.INTEGER;
        else if(typename.equals("b"))
            this.type = Types.BIT;
        else if(typename.equals("x"))
            this.type = Types.TINYINT;
        else if(typename.equals("h"))
            this.type = Types.SMALLINT;
        else if(typename.equals("j"))
            this.type = Types.BIGINT;
        else if(typename.equals("e"))
            this.type = Types.REAL;
        else if(typename.equals("f"))
            this.type = Types.FLOAT;
        else if(typename.equals("p"))
            this.type = Types.TIMESTAMP;
        else if(typename.equals("d"))
            this.type = Types.DATE;
        else
            this.type = Types.VARCHAR;
        this.nullable = nullable;
        this.actualColumnNumber = actualColumnNumber;
    }

	public int getColumnType() {
        return this.type;
	}

	/**
	 * text, name, int4
	 * 
	 * @return
	 */
	public String getColumnTypeName() {
		return typename;			
	}

	public String getColumnLabel() {
		return name;
	}

	public String getColumnName() {
		return name;
	}

	public int getScale() {
		return 0;
	}

	public int getPrecision() {
		if(typename.equals("int4"))
			return 10;
		return ResultSetMetaDataImpl.MAX;
	}

	public int isNullable() {
		return nullable ? 2 : 0;
	}

	public int getColumnDisplaySize() {
		if(typename.equals("int4"))
			return 11;
		return ResultSetMetaDataImpl.MAX;
	}
	
}
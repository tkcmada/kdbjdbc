package jp.mufg.kdbjdbc;

public class ColumnInfo {

	private final String name;
	private final String typename;
	private final boolean nullable;
	
	public ColumnInfo(String name, String typename, boolean nullable) {
		super();
		this.name = name;
		this.typename = typename;
		this.nullable = nullable;
	}

	public int getColumnType() {
		if(typename.equals("int4"))
			return 4;
		return 12;
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
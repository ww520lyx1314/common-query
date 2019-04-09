package com.tfkj.common.domain;

import java.util.LinkedList;
import java.util.List;


public class Where {

	private String columnName;
	
	private Condition.Codemun operation;
	
	private List<Object> vals = new LinkedList<Object>();

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Condition.Codemun getOperation() {
		return operation;
	}

	public void setOperation(Condition.Codemun operation) {
		this.operation = operation;
	}

	public List<Object> getVals() {
		return vals;
	}

	public void setVals(List<Object> vals) {
		this.vals = vals;
	}
	
	public void addVals(Object...vals) {
		if(vals != null && vals.length > 0) {
			for(Object val:vals) {
				this.vals.add(val);
			}
		}
	}
}

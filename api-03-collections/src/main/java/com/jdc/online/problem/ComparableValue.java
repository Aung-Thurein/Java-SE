package com.jdc.online.problem;

public record ComparableValue(int data, String name) implements Comparable<ComparableValue> {

	@Override
	public int compareTo(ComparableValue other) {
		
		int dataResult= data - other.data;
		
		if(dataResult == 0)
		{
			
		
			if(null == name && null == other.name)
			{
				return 0;
			}
			if(null != name && null == other.name)
			{
				return 1;
			}
			
			if(null == name && null != other.name)
			{
				return -1;
			}
			return name.compareTo(other.name);

		}
		return dataResult;
		
	}

}

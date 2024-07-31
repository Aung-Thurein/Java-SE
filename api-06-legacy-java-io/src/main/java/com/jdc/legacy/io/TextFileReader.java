package com.jdc.legacy.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

	public List<String> read (String path)
	{
		ArrayList<String> list = new ArrayList<String>();
		
		try(var reader = new BufferedReader(new FileReader(path)))
		{
			String line = null;
			
			while(null != (line = reader.readLine()))
			{
				list.add(line);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return list;
	}
}

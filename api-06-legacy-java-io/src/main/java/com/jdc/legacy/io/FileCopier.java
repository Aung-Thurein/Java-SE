package com.jdc.legacy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopier {

	public boolean copy(File original, File copy)
	{
		try (var input = new FileInputStream(original);
				var output = new FileOutputStream(copy))
		{
				byte[] array = new byte[1024];
				
				while(input.read(array) != -1)
				{
					output.write(array);
				}
				
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}

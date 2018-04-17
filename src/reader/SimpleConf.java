package reader;

import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class SimpleConf 
{
	public static void write(Map<String,String> map,String filename)
	{
		try(PrintWriter out=new PrintWriter(Files.newOutputStream(Paths.get(filename), CREATE)))
		{
			for (Map.Entry<String, String> entry : map.entrySet()) {    
			    out.println(entry.getKey() + "=" + entry.getValue());
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static Map<String,String> read(String filename)
	{
		try(BufferedReader reader=new BufferedReader(new FileReader(new File(filename))))
		{
			Map<String,String> output=new TreeMap<String,String>();
			String line=null;
			while((line=reader.readLine())!=null)
			{
				String[] temp=line.split("=");
				if(temp.length!=2)
				{
					System.out.println("The filetype is not support");
					return null;
				}
				else
				{
					output.put(temp[0], temp[1]);
				}
			}
			return output;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Map<String,String> initFile(Map<String,String> def,String filename)
	{
		//if can't find file
		Path path=Paths.get(filename);
		if(!Files.exists(path))
		{
			write(def,filename);
		}
		return read(filename);
	}
}

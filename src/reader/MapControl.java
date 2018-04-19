package reader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MapControl 
{
	private Map<String,String> map;
	private boolean needChange;
	private String filename;
	
	public MapControl(String filename,Map<String,String> defaultMap)
	{
		this.filename=filename;
		needChange=false;
		map=filterRead(SimpleConf.read(filename),defaultMap);
	}
	public String read(String key)
	{
		return map.get(key);
	}
	public void change(String key,String value)
	{
		if(map.containsKey(key))
		{
			map.put(key, value);
			needChange=true;
		}
	}
	public void write()
	{
		if(needChange)
		{
			//if no file add new file
			if(!Files.exists(Paths.get(filename)))
			{
				SimpleConf.write(map, filename);
			}
			//add file by addition
			else
			{
				Map<String,String> fileData=SimpleConf.read(filename);
				for(Entry<String,String> entry:map.entrySet())
				{
					fileData.put(entry.getKey(), entry.getValue());
				}
				SimpleConf.write(fileData, filename);
			}
		}
	}
	public static Map<String,String> filterRead(Map<String,String> input,Map<String,String> filter)
	{
		TreeMap<String,String> output = new TreeMap<String,String>();
		for (Entry<String, String> entry : filter.entrySet())
		{
			String data=input.get(entry.getKey());
			if(data!=null)
			{
				output.put(entry.getKey(), data);
			}
			else
			{
				output.put(entry.getKey(),entry.getValue());
			}
		}
		return output;
	}
}

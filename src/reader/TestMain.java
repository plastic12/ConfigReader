package reader;

import java.util.Map;
import java.util.TreeMap;

public class TestMain 
{
	public static String testfile="data.txt";
	public static void main(String[] args)
	{
		checkInit();
	}
	/*
	public static void checkWrite()
	{
		Map<String,String> data=new TreeMap<String,String>();
		data.put("a", Integer.toString(10));
		data.put("b", Integer.toString(20));
		data.put("c", Integer.toString(30));
		SimpleConf.write(data, testfile);
	}
	*/
	/*
	public static void checkRead()
	{
		SimpleConf.read(testfile);
		for(Map.Entry<String, String> entry:map.entrySet())
		{
			System.out.println("Key="+entry.getKey()+" Value="+entry.getValue());
		}
	}
	*/
	public static void checkInit()
	{
		Map<String,String> data=new TreeMap<String,String>();
		data.put("a", Integer.toString(10));
		data.put("b", Integer.toString(20));
		data.put("c", Integer.toString(30));
		Map<String,String> map=SimpleConf.initFile(data, testfile);
		for(Map.Entry<String, String> entry:map.entrySet())
		{
			System.out.println("Key="+entry.getKey()+" Value="+entry.getValue());
		}
	}

}

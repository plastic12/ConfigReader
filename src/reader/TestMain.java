package reader;

import java.util.Map;
import java.util.TreeMap;

public class TestMain 
{
	public static String testfile="data.txt";
	public static void main(String[] args)
	{
		//checkInit();
		test();
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
	public static void test()
	{
		TreeMap<String,String>  map= new TreeMap<String,String>();
		map.put("a", "20");
		map.put("b", "20");
		map.put("c", "20");
		MapControl mc=new MapControl("data.txt",map);
		Map<String,String> prompt=mc.read();
		promptMap(prompt);
		mc.change("a", "200");
		prompt=mc.read();
		promptMap(prompt);
		mc.write();
	}
	public static void promptMap(Map<String,String> map)
	{
		for(Map.Entry<String, String> entry:map.entrySet())
		{
			System.out.println("Key:"+entry.getKey()+" Value:"+entry.getValue());
		}
	}

}

package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class TestMain 
{
	public static String testfile="data.txt";
	public static void main(String[] args)
	{
		//checkInit();
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
	public static void test()
	{

		if(!Files.exists(Paths.get(testfile)))
		{
			return;
		}
		try(BufferedReader reader=new BufferedReader(new FileReader(new File(testfile))))
		{
			Map<String,String> output=new TreeMap<String,String>();
			String line=null;
			while((line=reader.readLine())!=null)
			{
				System.out.println(line);
				System.out.println(line.length());
				String[] temp=line.split("=");
				if(temp.length!=2)
				{
					System.out.println("The filetype is not support");
				}
				/*
				String[] temp=line.split("=");
				if(temp.length!=2)
				{
					System.out.println("The filetype is not support");
				}
				else
				{
					output.put(temp[0], temp[1]);
				}*/
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void promptMap(Map<String,String> map)
	{
		for(Map.Entry<String, String> entry:map.entrySet())
		{
			System.out.println("Key:"+entry.getKey()+" Value:"+entry.getValue());
		}
	}

}

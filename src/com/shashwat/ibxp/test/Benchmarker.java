package com.shashwat.ibxp.test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Benchmarker {
	static void evaluate(String classname)
	{
		String line;
		try
		{
			for(int i=0; i<5; i++)
			{
				Process p = Runtime.getRuntime().exec(
						"java -classpath \"D:/workspace/IBXP/bin;D:/workspace/IBXP/lib/xml-apis.jar;D:/workspace/IBXP/lib/xercesImpl-2.6.2.jar;\" " + classname);
				BufferedReader bin = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while((line = bin.readLine()) != null)
					System.out.println(line);
				bin = new BufferedReader(new InputStreamReader(p.getErrorStream()));
				while((line = bin.readLine()) != null)
					System.out.println(line);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		PrintStream ps = null;
		try
		{
			System.out.println("Started Benchmarking...");
			File fout = File.createTempFile("output", ".txt", new File("D:/workspace/IBXP"));
			FileOutputStream fos = new FileOutputStream(fout);
			ps = new PrintStream(fos);
			System.setOut(ps);
			System.setErr(ps);
			
			ArrayList arTests = getAllFiles(new File("D:/workspace/IBXP/test"), false);
			Iterator it = arTests.iterator();
			while(it.hasNext())
			{
				File file = (File) it.next();
				String fileName = file.getAbsolutePath();
				ps.println();
				ps.println();
				System.out.println("Testing for ["+fileName+"] file size is ["+file.length()+"] bytes or ["+(file.length()/1000)+"] KB...");
								
				//System.out.println("evaluate com.shashwat.ibxp.test.BenchmarkSAX " + fileName);
				ps.println("SAX Parser");
				evaluate("com.shashwat.ibxp.test.BenchmarkSAX " + fileName);
				//System.out.println("evaluate com.shashwat.ibxp.parser.IBXParser " + fileName);
				ps.println("IBXP");
				evaluate("com.shashwat.ibxp.parser.IBXParser " + fileName);
				//System.out.println("evaluate com.shashwat.ibxp.test.BenchmarkDOM " + fileName);
				ps.println("DOM Parser");
				evaluate("com.shashwat.ibxp.test.BenchmarkDOM " + fileName);				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps != null)
			{
				ps.flush();
				ps.close();
			}			
		}
	}
	public static ArrayList getAllFiles(File directory, boolean processSubFolders) throws Exception
    {
        ArrayList listValidFiles  = new ArrayList();
        try
        {
            File[] arrFiles = null;
            int arrFilesSize = 0;
            if(directory != null && directory.isDirectory())
            {
                arrFiles = directory.listFiles();
                arrFilesSize = arrFiles.length;
            }
            else if(directory != null && directory.isFile())
            {
                // comment this line if the behavior is not desired...
                listValidFiles.add(directory);
            }
            
            File currentFile = null;
            for(int i=0; i < arrFilesSize; i++)
            {
                try
                {
                    currentFile = arrFiles[i];
                    
                    if(currentFile != null && currentFile.isFile())
                    {
                        listValidFiles.add(currentFile);
                    }
                    else if(processSubFolders && currentFile != null && currentFile.isDirectory())
                    {
                        listValidFiles.addAll(getAllFiles(currentFile, processSubFolders));
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    //todo: log - Can not process the subdirectory["+currentFile+"]."
                }
            }       
            return listValidFiles;
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}

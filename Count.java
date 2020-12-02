import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
class Count
{
	public static void main(String args[])throws IOException
	{
		File file=new File("output2.txt");
		File outputFile = new File("output3.txt");
		    if (outputFile.exists()) 
		    	outputFile.delete();     
			FileWriter out = new FileWriter("output3.txt");
		   	
    
		    
		String line;
		BufferedReader reader=new BufferedReader(new FileReader(file));
		while((line=reader.readLine())!=null)
		{
			
			if(!line.equals("")) 
			{
				
				String[] words=line.split(" ");
				int k=words.length;
				for(int i=0;i<k;i++)
				{
					out.write(words[i].replaceAll("[^\\dA-Za-z ]", ""));	
					out.write("\r\n");
				}
					
				
				

		
				
			}
			
		}
	}
}

		
		

		
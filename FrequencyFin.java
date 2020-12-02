import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
class FrequencyFin
{
	public static void main(String args[])throws IOException
	{
		File file=new File("output3.txt");
		File outputFile = new File("output4.txt");
		    if (outputFile.exists()) 
		    	outputFile.delete();   
		File outputFile1 = new File("output5.txt");
		    if (outputFile1.exists()) 
		    	outputFile1.delete();     
		FileWriter out1 = new FileWriter("output5.txt");
		  
		FileWriter out = new FileWriter("output4.txt");
		   	
   		String[] words1=new String[100000];  
  		String[] words=new String[100000];   
		String line;
		BufferedReader reader=new BufferedReader(new FileReader(file));
		int i=0,t;
		while((line=reader.readLine())!=null)
		{
			
			if(!line.equals("")) 
			{
				words[i]=line;
				i++;
			}
		}
		int c[]=new int[100000];
		int c1[]=new int[100000];
		int k,l,p=i,z;
		i=0;
		for(k=0,t=0;k<p;k++,i++)
		{
			c[i]=1;
			
			if(words[k]==" ")
				continue;
			for(l=k+1;l<p;l++)
			{
				if(words[l]==" ")
					continue;
				if(words[k].equalsIgnoreCase(words[l]))
				{
					words[l]=" ";	
					c[i]++;
				}
			}
			c1[t]=c[i];
			words1[t]=words[i];
			out.write(String.valueOf(c[i]));
			out.write("\t");
			out.write(words[k]);
			out.write("\r\n");
			t++;	
		}
		int max;
		for(int u=0;u<30;u++)
		{
			max=c1[0];
			z=0;
			for(int v=0;v<t;v++)
			{
				if(c1[v]>max)
				{
					max=c1[v];
					z=v;
				}
			}
			//out1.write(String.valueOf(c1[z]));
			//out1.write("\t");
			out1.write(words1[z]);
			out1.write("\r \n");
			c1[z]=0;
		}
		out1.close();
		out.close();
		reader.close();
	}
}
		
				
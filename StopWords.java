
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
class StopWords
{
	public static void main(String args[])throws IOException
	{

		List<String> stopwords = readStopWords("stopList.txt");
		File reviews=new File("reviews.txt");
		String outputFileName = "output1.txt";
		FileWriter out = null;
		Scanner fip1 = null;
		BufferedReader reader = null;
		try{
			File outputFile = new File(outputFileName);
		    if (outputFile.exists()) {
		    	outputFile.delete();     
		    }
			out = new FileWriter(outputFileName);
				reader = new BufferedReader(new FileReader(reviews));
				String line;
				while ((line = reader.readLine()) != null) {
					if(!line.equals("")) {
						String[] words = line.split(" ");
						int i=0;
						for(String rwWord : words) {
							rwWord = rwWord.trim();
							if(!rwWord.equals("")){
								boolean flag=true;
								for(String stWrd:stopwords)
							    {
							        if(rwWord.equalsIgnoreCase(stWrd))
									{
									    flag=false;
								    	break;
									}
							    }
								
								if(flag) {
									if(i>0) {
										out.write(" ");
									}
									out.write(rwWord.replaceAll("[^\\dA-Za-z ]", ""));
									i++;
								}
							}
						}
						out.write("\r\n");
					}
				}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally { 
			try{
				if(null!=reader) {
					reader.close();
				}
				if(null!=fip1)
					fip1.close();
				if(null!=out) {
					out.close();
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static List<String> readStopWords(String fileName) {

		List<String> words = new ArrayList<String>();
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				if(!line.equals(""))
					words.add(line.trim());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally { 
			try{
				if(null!=reader) {
					reader.close();
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		return words;
	}
}
		
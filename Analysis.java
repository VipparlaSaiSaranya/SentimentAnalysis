import java.util.*;
import java.io.*;
class Analysis
{
	public static void main(String args[])throws IOException
	{

		List<String> stopwords = readStopWords("output5.txt");
		File reviews=new File("reviews.txt");
		String outputFileName = "output6.txt";
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
				for(String stWrd:stopwords)
				{
					out.write(stWrd);
					out.write(" ");
				}
				while ((line = reader.readLine()) != null) {
					if(!line.equals("")) {
						String[] words = line.split(" ");
						int i=0;
						for(String stWrd:stopwords)
						{
							stWrd = stWrd.trim();
							if(!stWrd.equals(""))
							{
								boolean flag=true;
								for(String rwWord : words)
							        {
							        if(rwWord.equalsIgnoreCase(stWrd))
									{
									    flag=false;
									    out.write(String.valueOf(1));
									    out.write(" ");
								    	    break;
									}
							        }
								
								if(flag) {
									
									out.write(String.valueOf(0));
									out.write(" ");
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
		
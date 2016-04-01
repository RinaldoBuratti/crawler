package bing;

import java.io.*;
import java.util.ArrayList;

public class BufferReader {
	private ArrayList<String> names;
	
	public BufferReader(){
		
	}
	
	public ArrayList<String> getNames() {
		return this.names;
	}
	
	public void FileReader(File file) {
		this.names = new ArrayList<String>();
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				this.names.add(line);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

package bing;
import java.io.*;

public class TestFileReader {
	
	public static void main(String[] args) {
		BufferReader o = new BufferReader();
		File f = new File("C:/Users/lucav_000/git/Marilu1/Marilu/src/Nominativi/FileCompleto.txt"); //change path for test file
		o.FileReader(f);
	}

}

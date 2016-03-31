package bing;
import java.io.*;

public class TestFileReader {
	
	public static void main(String[] args) {
		BufferReader o = new BufferReader();
		File f = new File("/Users/rinaldoburatti/Desktop/provaFile.txt"); //change path for test file
		o.FileReader(f);
	}

}

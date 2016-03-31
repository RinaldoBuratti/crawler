package bing;
import java.io.*;

public class TestFileReader {
	
	public static void main(String[] args) {
		BingSearchApi o = new BingSearchApi();
		File f = new File("/Users/rinaldoburatti/Desktop/provaFile.txt");
		o.FileReader(f);
	}

}

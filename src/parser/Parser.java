package parser;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;


public class Parser {

	public static void main(String[] args) {
		File dir = new File("/Volumes/PENDRIVE/docs");
		String[] children = dir.list();
		
		FileOutputStream fos = null;
		String filename;
		Documento d = new Documento();
		
		File f;
		
		try {
			for(int i=2; i< children.length; i++) {
				String nomefile = children[i];
			
			filename = "json/"+ nomefile + ".json";
			f = new File("/Volumes/PENDRIVE/docs/" + nomefile); 
			Document fi = Jsoup.parse(f,null);
			d.setText(fi.text());
			d.setTitle(fi.title());
			Gson gson = new Gson();			
			FileWriter w = new FileWriter(filename);
			BufferedWriter b = new BufferedWriter(w);
			b.write(gson.toJson(d));
			b.flush();
			b.close();
			
			System.out.println(gson.toJson(d));
			}
			
		} catch (Exception e) {
			System.out.println("Errore");
		}
		}
}


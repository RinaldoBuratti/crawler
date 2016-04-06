package bing;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("jsse.enableSNIExtension", "false");
		BufferReader br = new BufferReader(); 					// per leggere da file di testo
		ArrayList<String> names = new ArrayList<String>();		// nomi degli atleti recuperati dal br
		ArrayList<Object> urls = new ArrayList<Object>();		// lista degli URL per nome
		String filename;										// nome del file dove salvare la pagina
		String userAgent;										// per effttuare il download della pagina html

		/* Recupera i nomi dal file di testo e li salva nella variabile names **
		 * Guardare bene la directory dove viene salvato*/	
		File f = new File("C:/Users/lucav_000/git/Marilu1/Marilu/src/Nominativi/Luca.txt");
		br.FileReader(f);
		names = br.getNames();

		/* Effettua due query su bing prendendo nome per nome e ne salva il contenuto delle pagine */
		for (String s: names) {
			System.out.println(s);
			int i=0;								//variabile per contare i documenti
			for (int n=0; n<6; n++){
				urls = UrlRetriever.getURLQuery(s,n*50);
				userAgent = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/532.5 (KHTML, like Gecko) Chrome/4.0.249.0 Safari/532.5";
				if (n==0){ 
					i = 1;
				} else {
					i = i+1;
				}
				//per i nomi delle pagine
				for (Object o: urls) {
					URL url = new URL(o.toString());
					filename = "docs/"+ s + i +  ".html";
					try {
						PageDownloader.downloadFromUrl(url, filename, userAgent);
						i++;
					} catch (Exception e) {
						System.out.println("ERRORE per la pagina: " + url);
						System.out.println("Tipo di errore: JSSE creates SSLProtocolException on (common) warning: unrecognized_name for SNI.");
						System.out.println("Continuo il download delle restanti pagine");
					};
				}
			}
		}

	}

}

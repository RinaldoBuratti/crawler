package bing;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PageDownloader {

	public static void downloadFromUrl (URL url, String localFilename, String userAgent)
		    throws IOException
		{
		    InputStream is = null;
		    FileOutputStream fos = null;

		    try
		    {
		        URLConnection urlConn = url.openConnection ();
		        urlConn.setRequestProperty ("User-Agent", userAgent);

		        is = urlConn.getInputStream ();
		        fos = new FileOutputStream (localFilename);

		        byte[] buffer = new byte[1024];
		        int len;

		        while ((len = is.read (buffer)) > 0)
		            fos.write (buffer, 0, len);
		    }
		    finally
		    {
		        try {
		            if (is != null)
		                is.close ();
		        } finally {
		            if (fos != null)
		                fos.close ();
		        }
		    }
		}

	/* prova */
	public static void main(String[] args){
		String s = "docs/google.txt";
		String userAgent = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/532.5 (KHTML, like Gecko) Chrome/4.0.249.0 Safari/532.5";
		
		try {
		URL url = new URL("http://www.google.it");
		downloadFromUrl(url, s, userAgent);
		} catch (Exception e){
			System.out.println("Errore");
		}
	}
}

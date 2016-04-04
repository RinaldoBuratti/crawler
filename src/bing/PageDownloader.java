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
		        urlConn.setConnectTimeout(30000);

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
}

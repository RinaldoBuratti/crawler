package bing;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.net.URL;
	import java.net.URLConnection;
	import java.net.URLEncoder;
	import java.nio.charset.Charset;
	import java.util.ArrayList;
	import java.util.Base64;

	import org.json.JSONArray;
	import org.json.JSONObject;

	public class UrlRetriever {
		
		
	    public static ArrayList<Object> getURLQuery(String search, int skip) throws Exception {
	    	ArrayList<Object> urls = new ArrayList<Object>();
	    	
	        final String accountKey = "r+xh8vO80uC/uHVxOB6da566NXSOsloMrD7y4vfuJQM";
	        final String bingUrlPattern = "https://api.datamarket.azure.com/Bing/Search/Web?Query=%%27%s%%27&Market='it-IT'&$format=JSON&$skip=" + skip;

	        final String query = URLEncoder.encode(search, Charset.defaultCharset().name());
	        final String bingUrl = String.format(bingUrlPattern, query);

	        final String accountKeyEnc = Base64.getEncoder().encodeToString((accountKey + ":" + accountKey).getBytes());

	        final URL url = new URL(bingUrl);
	        final URLConnection connection = url.openConnection();
	        connection.setRequestProperty("Authorization", "Basic " + accountKeyEnc);

	        try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	            String inputLine;
	            final StringBuilder response = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            final JSONObject json = new JSONObject(response.toString());
	            final JSONObject d = json.getJSONObject("d");	
	            System.out.println(d.toString());
	            final JSONArray results = d.getJSONArray("results");
	            final int resultsLength = results.length();
	            for (int i = 0; i < resultsLength; i++) {
	                final JSONObject aResult = results.getJSONObject(i);
	                urls.add(aResult.get("Url"));
	            }
	        }
			return urls;
	    }

	}


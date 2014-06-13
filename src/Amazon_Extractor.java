import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;

public class Amazon_Extractor implements Extractor {

	@Override
	public Integer getPriceFromName(String product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPriceFromBarcode(Integer barcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getBarcode(String product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProductName(Integer barcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<String, Double>> AllBookNameAndPrices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<String, Double>> AllDVDNameAndPrices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<Integer, Double>> AllBookBarcodesAndPrices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<Integer, Double>> AllDVDBarcodesAndPrices() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getASINS(Integer page, String query) throws IOException {
		String searchAddress = "http://www.amazon.co.uk/s/ref=sr_pg_2?rh=i%3Aaps%2Ck%3Advd&page="
				+ page + "&keywords=" + query + "&ie=UTF8&qid=1402617922";
		
		return ExtractAndPopulate(searchAddress);
	}

	private List<String> ExtractAndPopulate(String address) throws IOException {
		URL url = new URL(address);
		BufferedReader reader = null;
		File file = new File("Test");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		StringBuffer sb = new StringBuffer();
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		List<String> results = final_matcher(sb.toString());		
		System.out.println(results);
		return results;
	}	
	
	private List<String> final_matcher(String html_body) {
		List<String> result = new ArrayList<String>();
		
		String s = "";
		
		Pattern p3 = Pattern.compile("/product-reviews/([A-Z]|[0-9])+");
		Matcher m3 = p3.matcher(html_body);
		
		while (m3.find()) {
			s = m3.group();
			result.add(s.replaceFirst("/product-reviews/",""));
		}
		
		return result;
	}

}

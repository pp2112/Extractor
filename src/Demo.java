import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) throws IOException {
		Extractor cex = new CEX_Extractor();
		Amazon_Extractor amazon = new Amazon_Extractor();
		Extractor play = new Play_Extractor();

		List<Pair<Integer, Double>> cex_books = cex.AllBookBarcodesAndPrices();
		List<Pair<Integer, Double>> cex_dvds = cex.AllDVDBarcodesAndPrices();

		List<Pair<Integer, Double>> amazon_books = amazon.AllBookBarcodesAndPrices();
		List<Pair<Integer, Double>> amazon_dvds = amazon.AllDVDBarcodesAndPrices();

		List<Pair<Integer, Double>> play_books = play.AllBookBarcodesAndPrices();
		List<Pair<Integer, Double>> play_dvds = play.AllDVDBarcodesAndPrices();

		
		List<String> dvd_ASINS = new ArrayList<String>();
		
		for(int i=0; i<20; i++){
		 List<String> result = amazon.getASINS(i,"DVD");
		 dvd_ASINS.addAll(result);
		}
		
		StringBuffer final_result = new StringBuffer();
		for(String s : dvd_ASINS){
			final_result.append(s + ";");
		}
		
		System.out.println(final_result);
		
		/*
		System.out.println("Profits of all the books (CEX): ");
		for (Pair<Integer, Double> book : cex_books) {
			Double amazon_difference = amazon.getPriceFromBarcode(book.getX())
					- book.getY();
			Double play_difference = amazon.getPriceFromBarcode(book.getX())
					- book.getY();
			if (amazon_difference >= 1) {
				System.out.println("<" + amazon.getProductName(book.getX()) + ", "
						+ amazon_difference + "> " + "Amazon");
			}
			if(play_difference >= 1){
				System.out.println("<" + play.getProductName(book.getX()) + ", "
						+ play_difference + "> " + "Play");
			}
			*/
		}
	}

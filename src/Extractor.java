import java.util.List;


public interface Extractor {
	
	//Returns the price of a product given the string representation.
	public Integer getPriceFromName(String product);
	
	//Returns the price of a product given the barcode value.
	public Integer getPriceFromBarcode(Integer barcode);
	
	//Returns the barcode value given a product name.
	public Integer getBarcode(String product);

	//Returns the product name given a barcode value.
	public String getProductName(Integer barcode);

	//Returns and array of mapping of all the Book names and their Prices.
	public List<Pair<String,Double>> AllBookNameAndPrices();
	
	//Returns and array of mapping of all the DVD names and their Prices.
	public List<Pair<String,Double>> AllDVDNameAndPrices();
	
	//Returns an array of mapping of all Book Barcodes and their Prices.
	public List<Pair<Integer,Double>> AllBookBarcodesAndPrices();
	
	//Returns an array of mapping of all the DVD Barcodes and their Prices.
	public List<Pair<Integer,Double>> AllDVDBarcodesAndPrices();
	
}

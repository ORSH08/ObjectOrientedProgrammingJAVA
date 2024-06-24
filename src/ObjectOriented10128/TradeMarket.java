package ObjectOriented10128;

public interface TradeMarket {
	public boolean addBuyer(Buyer buyer);

	public boolean addSeller(Seller seller);

	public void addProductToSeller(Product pr, int index);

	public boolean addProductToBuyer(String productToAdd, int sellerIndex, int buyerIndex);

	public void payment(int buyerIndex);

	public Buyer[] getBuyers();

	public Seller[] getSellers();

	public int isExist(String userName, String choice);

	public Product[] getSellerProducts(int index);

}

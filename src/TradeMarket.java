public interface TradeMarket {
	public boolean addBuyer(Buyer buyer);

	public boolean addSeller(Seller seller);

	public void addProductToSeller(String itemName, String price, Category category, int index);

	public boolean addProductToBuyer(String productToAdd,int sellerIndex, int buyerIndex);

	public void payment(int buyerIndex);

	public Buyer[] getBuyers();

	public Seller[] getSellers();

	public Buyer[] doubleBuyersArraySize();
	
	public Seller[] doubleSellersArraySize();
	
	public int isExist(String userName,String choice);
	
	public Product[] getSellerProducts(int index);

}

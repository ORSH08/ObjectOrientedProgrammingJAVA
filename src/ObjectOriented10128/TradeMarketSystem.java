package ObjectOriented10128;

import java.util.Optional;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class TradeMarketSystem implements TradeMarket {
	private Buyer[] buyers;
	private Seller[] sellers;
	private int countBuyers;
	private int countSellers;

	public TradeMarketSystem() {
		this.buyers = new Buyer[2];
		this.sellers = new Seller[2];
		this.countBuyers = 0;
		this.countSellers = 0;
	}

	//@Override
	private Buyer[] doubleBuyersArraySize() {
		// TODO Auto-generated method stub
		Buyer[] newArray = new Buyer[this.countBuyers * 2];
		for (int i = 0; i < this.countBuyers; i++) {
			newArray[i] = this.buyers[i];
		}

		return newArray;
	}

	//@Override
	private Seller[] doubleSellersArraySize() {
		// TODO Auto-generated method stub
		Seller[] newArray = new Seller[this.countSellers * 2];
		for (int i = 0; i < this.countSellers; i++) {
			newArray[i] = this.sellers[i];
		}

		return newArray;

	}

	@Override
	public boolean addBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		if (this.countBuyers == this.buyers.length) {
			this.buyers = doubleBuyersArraySize();
		}
		for (int i = 0; i < this.countBuyers; i++) {
			if (buyer.getUserName().equals(this.buyers[i].getUserName())) {
				return false;
			}
		}
		this.buyers[countBuyers] = buyer;
		countBuyers++;

		return true;
	}

	@Override
	public boolean addSeller(Seller seller) {
		// TODO Auto-generated method stub
		if (this.countSellers == this.sellers.length) {
			this.sellers = doubleSellersArraySize();
		}
		for (int i = 0; i < this.countSellers; i++) {
			if (seller.getUserName().equals(this.sellers[i].getUserName())) {
				return false;
			}
		}
		this.sellers[countSellers] = seller;
		countSellers++;

		return true;
	}

	@Override
	public void addProductToSeller(Product pr, int index) {
		// TODO Auto-generated method stub
		//Product pr = new Product(itemName, Double.valueOf(price), category);
		sellers[index].setProduct(pr);

	}

	@Override
	public boolean addProductToBuyer(String productToAdd, int sellerIndex, int buyerIndex) {
		// TODO Auto-generated method stub
		Optional<Product> pr = sellers[sellerIndex].getProductByName(productToAdd);
		if (pr.isPresent()) {
			buyers[buyerIndex].setProductToCart(pr.get());
			return true;

		} else {
			return false;
		}

	}

	@Override
	public void payment(int buyerIndex) {
		// TODO Auto-generated method stub

		buyers[buyerIndex].setBalance(0);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String formatedDate = dtf.format(LocalDateTime.now());
		buyers[buyerIndex].getCurrentCart().setDate(formatedDate);
		buyers[buyerIndex].addCart();

	}

	@Override
	public Buyer[] getBuyers() {
		// TODO Auto-generated method stub
		Buyer[] copyOfBuyers = new Buyer[countBuyers];
		for (int index = 0; index < countBuyers; index++) {
			copyOfBuyers[index] = buyers[index];
		}
		return copyOfBuyers;

	}

	@Override
	public Seller[] getSellers() {
		// TODO Auto-generated method stub
		Seller[] copyOfSellers = new Seller[countSellers];
		for (int index = 0; index < countSellers; index++) {
			copyOfSellers[index] = sellers[index];
		}
		return copyOfSellers;

	}

	@Override
	public int isExist(String userName, String choice) {
		// TODO Auto-generated method
		if (choice == "buyers") {
			for (int i = 0; i < this.countBuyers; i++) {
				if (userName.equals(this.buyers[i].getUserName())) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < this.countSellers; i++) {
				if (userName.equals(this.sellers[i].getUserName())) {
					return i;
				}
			}
		}

		return -1;

	}

	@Override
	public Product[] getSellerProducts(int index) {
		// TODO Auto-generated method stub
		return sellers[index].getAllProducts();

	}

}

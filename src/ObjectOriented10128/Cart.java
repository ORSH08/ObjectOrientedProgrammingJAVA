package ObjectOriented10128;

public class Cart {

	private ProductListNode first;
	private int productCount;
	private String date;
	private double cartPrice;

	public Cart() {
		this.productCount = 0;
		this.date = null;
		this.first = null;
		this.cartPrice = 0;

	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public void addProduct(Product pr) {
		if (this.first == null) {
			this.first = new ProductListNode(pr);
		} else {
			ProductListNode node = this.first;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new ProductListNode(pr));
		}
		this.productCount++;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Product[] getAllProducts() {
		Product[] rv = new Product[this.productCount];
		int i = 0;
		for (ProductListNode node = this.first; node != null; node = node.getNext()) {
			rv[i++] = node.getProduct();
		}
		return rv;
	}

	@Override
	public String toString() {
		return "Payment Date: " + date + "\nCart price: " + cartPrice;
	}

}
package ObjectOriented10128;

public class Buyer extends Person {
	private CartListNode first;
	private CartListNode last;
	private double balance;
	private int ordersCount;

	public Buyer(String buyerUserName) {
		super(buyerUserName);
		this.first = new CartListNode();
		this.last = first;
		this.ordersCount = 0;
		this.balance = 0;

	}

	public void addCart() {
		if (this.balance == 0) {
			CartListNode node = this.last;
			node.setNext(new CartListNode());
			this.last = node.getNext();

		}
		this.ordersCount++;
	}

	public void setProductToCart(Product pr) {
		this.last.getCart().addProduct(pr);
		this.balance += pr.getPrice();

	}

	public Cart[] getAllCarts() {
		Cart[] rv = new Cart[this.ordersCount];
		int i = 0;
		for (CartListNode node = this.first; node != this.last; node = node.getNext()) {
			rv[i++] = node.getCart();
		}
		return rv;
	}

	public Cart getCurrentCart() {
		return this.last.getCart();
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public int getOrdersCount() {
		return ordersCount;
	}

	public void setOrdersCount(int ordersCount) {
		this.ordersCount = ordersCount;
	}

}

package ObjectOriented10128;

public class CartListNode {

	private Cart cr;
	private CartListNode next; // = null

	public CartListNode() {
		this.cr = new Cart();
		this.next = null;
	}

	public Cart getCart() {
		return cr;
	}

	public CartListNode getNext() {
		return next;
	}

	public void setNext(CartListNode next) {
		this.next = next;
	}

}

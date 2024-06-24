package ObjectOriented10128;

public class ProductListNode {
	private Product pr;
	private ProductListNode next; // = null

	public ProductListNode(Product pr) {
		this.pr = pr;
		this.next = null;
	}

	public Product getProduct() {
		return pr;
	}

	public ProductListNode getNext() {
		return next;
	}

	public void setNext(ProductListNode next) {
		this.next = next;
	}

}

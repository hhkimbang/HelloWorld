package helloWorld.model;

public class BookInfo {

	/**
	 * book_id
	 */
	private Integer id;

	/**
	 * book_price
	 */
	private Double price;

	/**
	 * book_quantity
	 */
	private Integer quantity;

	/**
	 * book_company
	 */
	private String company;

	/**
	 * book_state
	 */
	private int state;

	/**
	 * book_class_id
	 */
	private int classId;

	/**
	 * book_tax
	 */
	private Double tax;

	public BookInfo() {
	}

	public BookInfo(Integer id, Double price, Integer quantity, String company, int state, int classId, Double tax) {
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.company = company;
		this.state = state;
		this.classId = classId;
		this.tax = tax;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

}

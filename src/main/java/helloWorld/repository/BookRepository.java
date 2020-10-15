package helloWorld.repository;

import java.util.List;

import helloWorld.model.BookInfo;

public interface BookRepository {

	/**
	 * insert data to book table
	 * @param id
	 * @param price
	 * @param quantity
	 * @param company
	 * @param state
	 * @param classId
	 * @param tax
	 * @return 0-failed or 1-success
	 */
	public int insertIntoBook(Integer id, Double price, Integer quantity, String company, int state, int classId, Double tax);

	/**
	 * insert data to book_class table
	 * @param classId Integer class_id
	 * @param classType Integer class_type
	 * @param description Integer class_description
	 * @return 0-failed or 1-success
	 */
	public int insertIntoBookClass(Integer classId, Integer classType, String description);

	/**
	 * SELECT * FROM book
	 * @return bookList
	 */
	public List<BookInfo> getBookInfoList();

	/**
	 * SELECT b.* FROM book b INNER JOIN book_class bc ON b.class_id = bc.class_id  
	 * WHERE bc.class_type = ?
	 * @return null if not found any match or bookList
	 */
	public List<BookInfo> getBookByType(Integer classType);

	/**
	 * SELECT b.* FROM book b 
	 * WHERE b.book_company = ?
	 * @param company String book_company
	 * @return null if not found any match or bookList
	 */
	public List<BookInfo> getBookByCompany(String company);
}

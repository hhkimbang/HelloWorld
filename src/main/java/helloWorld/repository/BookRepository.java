package helloWorld.repository;

import java.util.List;

import helloWorld.model.BookInfo;

public interface BookRepository {

	public int insertIntoBook(Integer id, Double price, Integer quantity, String company, int state, int classId, Double tax);

	public int insertIntoBookClass(Integer classId, Integer classType, String description);

	public List<BookInfo> getBookInfoList();

	public List<BookInfo> getBookByType(Integer classType);

	public List<BookInfo> getBookByCompany(String company);
}

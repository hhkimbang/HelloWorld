package helloWorld.service;

import java.util.List;

import helloWorld.model.BookInfo;
import helloWorld.repository.BookRepository;
import helloWorld.repository.BookRepositoryImpl;

public class BookService {

	private BookRepository bookRepo = new BookRepositoryImpl();

	public int insertIntoBook(Integer id, Double price, Integer quantity, String company, int state, int classId,
			Double tax) {
		return this.bookRepo.insertIntoBook(id, price, quantity, company, state, classId, tax);
	}

	public int insertIntoBookClass(Integer classId, Integer classType, String description) {
		return this.bookRepo.insertIntoBookClass(classId, classType, description);
	}

	public Double sumBookPriceByBookClass(Integer classType) {
		Double sum = 0.0;
		List<BookInfo> bookList = this.bookRepo.getBookByType(classType);
		for (BookInfo book : bookList) {
			sum = sum + book.getQuantity() * book.getPrice();
			sum = sum + (classType == 2 ? book.getTax() : 0.0);
		}
		if (classType == 1) {
			sum = sum / 2;
		}

		return sum;
	}

	public Double averageBookPrice() {
		Double sum = 0.0;
		List<BookInfo> bookList = this.bookRepo.getBookByType(2);
		for (BookInfo book : bookList) {
			sum += book.getPrice();
		}
		return sum = sum / bookList.size();
	}
	
	public List<BookInfo> getBookByCompany(String company){
		return this.bookRepo.getBookByCompany(company);
	}
	
	public List<BookInfo> getBookInfoList(){
		return this.bookRepo.getBookInfoList();
	}
}
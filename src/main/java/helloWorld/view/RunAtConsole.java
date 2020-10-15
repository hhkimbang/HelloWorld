package helloWorld.view;

import java.util.List;
import java.util.Scanner;

import helloWorld.model.BookInfo;
import helloWorld.repository.BookRepositoryImpl;
import helloWorld.service.BookService;
import helloWorld.utils.ConnectionUtils;
import helloWorld.utils.ConstUtils;

public class RunAtConsole {

	public static void main(String[] args) {
		// intial BookService
		BookService bookService = new BookService(new BookRepositoryImpl(new ConnectionUtils()));
		// list all book available in db
		System.out.println("book available are: ");
		for (BookInfo book : bookService.getBookInfoList()) {
			String state = book.getState() == ConstUtils.BOOK_OLD ? "sach cu" : "sach moi";
			System.out
					.println(book.getCompany() + " \t" + book.getPrice() + " \t" + state + " \t" + book.getQuantity());
		}
		
		// show application menu
		System.out.println("Application menu: ");
		System.out.println("1. insert book class");
		System.out.println("2. sum price by kind of book");
		System.out.println("3. calculate average price 'sach tham khao'");
		System.out.println("4. get book info by company");
		System.out.println("enter any key to close");
		
		// user choice option
		Scanner sc = new Scanner(System.in);
		Integer option = 0;
		option = sc.nextInt();
		while (option == ConstUtils.INSERT_KIND_OF_BOOK || option == ConstUtils.SUM_PRICE_BY_TYPE
				|| option == ConstUtils.AVERAGE_PRICE_SACH_THAM_KHAO || option == ConstUtils.GET_BOOK_BY_COMPANY) {
			switch (option) {
			// them loai sach
			case 1:
				System.out.println("enter kind of book info");
				System.out.println("class id: ");
				Integer classId = sc.nextInt();
				System.out.println("class type");
				Integer classType = sc.nextInt();
				System.out.println("class description ");
				sc = new Scanner(System.in);
				String description = sc.nextLine();
				int rs = bookService.insertIntoBookClass(classId, classType, description);
				System.out.println(rs == 0 ? "failed" : "successful\nPlease checking database");
				break;
			// tinh tong tien theo loai sach	
			case 2:
				System.out.println("sum price of 'sach giao khoa'");
				System.out.println(bookService.sumBookPriceByBookClass(1));
				System.out.println("sum price of 'sach tham khao'");
				System.out.println(bookService.sumBookPriceByBookClass(2));
				break;
			//tinh trung binh gia tien cua sach tham khao
			case 3:
				System.out.println("average price of 'sach tham khao'");
				System.out.println(bookService.averageBookPrice());
				break;
			// tim sach theo ten nha xuat ban
			case 4:
				System.out.println("enter company name");
				sc = new Scanner(System.in);
				String company = sc.nextLine();
				List<BookInfo> booklist = bookService.getBookByCompany(company);
				if (booklist.size() == 0)
					System.out.println("khong tim thay");
				for (BookInfo book : booklist) {
					System.out.println("book id: " + book.getId());
				}
				break;
			// in case option not available
			default:
				System.out.println("invalid option!!!");
				break;
			}
			System.out.println("choose option 1 or 2 or 3 or 4 or any key to close");
			option = sc.nextInt();
		}
		sc.close();
	}

}

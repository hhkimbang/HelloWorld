package helloWorld.view;

import java.util.List;
import java.util.Scanner;

import helloWorld.model.BookInfo;
import helloWorld.service.BookService;

public class RunAtConsole {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		System.out.println("book available are: ");
		for (BookInfo book : bookService.getBookInfoList()) {
			String state = book.getState() == 0 ? "sach cu" : "sach moi";
			System.out
					.println(book.getCompany() + " \t" + book.getPrice() + " \t" + state + " \t" + book.getQuantity());
		}
		System.out.println("Application menu: ");
		System.out.println("1. insert book class");
		System.out.println("2. sum price by kind of book");
		System.out.println("3. calculate average price 'sach tham khao'");
		System.out.println("4. get book info by company");
		System.out.println("enter any key to close");
		Scanner sc = new Scanner(System.in);
		Integer option = 0;
		option = sc.nextInt();
		while (option == 1 || option == 2 || option == 3 || option == 4) {
			switch (option) {
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
			case 2:
				System.out.println("sum price of 'sach giao khoa'");
				System.out.println(bookService.sumBookPriceByBookClass(1));
				System.out.println("sum price of 'sach tham khao'");
				System.out.println(bookService.sumBookPriceByBookClass(2));
				break;
			case 3:
				System.out.println("average price of 'sach tham khao'");
				System.out.println(bookService.averageBookPrice());
				break;
			case 4:
				System.out.println("enter company name");
				sc = new Scanner(System.in);
				String company = sc.nextLine();
				List<BookInfo> booklist = bookService.getBookByCompany(company);
				if(booklist.size() == 0)
					System.out.println("khong tim thay");
				for (BookInfo book : booklist) {
					System.out.println("book id: " + book.getId());
				}
				break;
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

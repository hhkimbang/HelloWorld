package helloWorld.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helloWorld.model.BookInfo;
import helloWorld.utils.ConnectionUtils;

public class BookRepositoryImpl implements BookRepository {

	private ConnectionUtils utils;

	public BookRepositoryImpl(ConnectionUtils utils) {
		this.utils = utils;
	}

	@Override
	public int insertIntoBook(Integer id, Double price, Integer quantity, String company, int state, int classId,
			Double tax) {
		String sql = "INSERT INTO book (book_id, book_price, book_company, book_quantity, book_state, class_id, tax) VALUE (?,?,?,?,?,?,?)";
		Connection conn = utils.getConnection();
		PreparedStatement stmt;
		int rs = 0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setDouble(2, price);
			stmt.setString(3, company);
			stmt.setInt(4, quantity);
			stmt.setInt(5, state);
			stmt.setInt(6, classId);
			stmt.setDouble(7, tax);
			rs = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			utils.silentKillConnection(conn);
		}
		return rs;
	}

	@Override
	public int insertIntoBookClass(Integer classId, Integer classType, String description) {
		String sql = "INSERT INTO book_class (class_id, class_type, class_description) VALUE (?,?,?)";
		Connection conn = utils.getConnection();
		PreparedStatement stmt;
		int rs = 0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, classId);
			stmt.setInt(2, classType);
			stmt.setString(3, description);
			rs = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			utils.silentKillConnection(conn);
		}
		return rs;
	}

	@Override
	public List<BookInfo> getBookInfoList() {
		String sql = "select b.book_id , b.book_price, b.book_quantity ,b.book_company , b.book_state , b.class_id, b.tax from book b;";
		Connection conn = utils.getConnection();
		PreparedStatement stmt;
		List<BookInfo> bookList = new ArrayList<BookInfo>();
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				BookInfo book = new BookInfo(rs.getInt("book_id"), rs.getDouble("book_price"),
						rs.getInt("book_quantity"), rs.getString("book_company"), rs.getInt("book_state"),
						rs.getInt("class_id"), rs.getDouble("tax"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			utils.silentKillConnection(conn);
		}
		return bookList;
	}

	@Override
	public List<BookInfo> getBookByType(Integer classType) {
		String sql = "SELECT b.book_id , b.book_price, b.book_quantity ,b.book_company , b.book_state , b.class_id, b.tax FROM book b INNER JOIN book_class bc ON b.class_id = bc.class_id  WHERE bc.class_type = ?";
		Connection conn = utils.getConnection();
		PreparedStatement stmt;
		List<BookInfo> bookList = new ArrayList<BookInfo>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, classType);
			ResultSet rs = stmt.executeQuery();
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				BookInfo book = new BookInfo(rs.getInt("book_id"), rs.getDouble("book_price"),
						rs.getInt("book_quantity"), rs.getString("book_company"), rs.getInt("book_state"),
						rs.getInt("class_id"), rs.getDouble("tax"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			utils.silentKillConnection(conn);
		}
		return bookList;
	}

	@Override
	public List<BookInfo> getBookByCompany(String company) {
		String sql = "SELECT b.book_id , b.book_price, b.book_quantity ,b.book_company , b.book_state , b.class_id, b.tax FROM book b WHERE b.book_company = ?";
		Connection conn = utils.getConnection();
		PreparedStatement stmt;
		List<BookInfo> bookList = new ArrayList<BookInfo>();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, company);
			ResultSet rs = stmt.executeQuery();
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				BookInfo book = new BookInfo(rs.getInt("book_id"), rs.getDouble("book_price"),
						rs.getInt("book_quantity"), rs.getString("book_company"), rs.getInt("book_state"),
						rs.getInt("class_id"), rs.getDouble("tax"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			utils.silentKillConnection(conn);
		}
		return bookList;
	}

}

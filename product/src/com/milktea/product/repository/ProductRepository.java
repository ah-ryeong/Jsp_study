package com.milktea.product.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.milktea.product.db.DBConn;
import com.milktea.product.model.Product;

public class ProductRepository {
	private static final String TAG = "ProductRepository : ";
	
	private static ProductRepository instance = new ProductRepository();
	
	private ProductRepository() {	}
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Product> All() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * ");
		sb.append("FROM product ");
		sb.append("ORDER BY id ");
		
		final String SQL = sb.toString();
		List<Product> products = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			// while 돌려서 rs -> java 오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			System.out.println(TAG + "All() : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return null;

	} // end of All()
	
	public List<Product> Price() {
		
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY price DESC";
		List<Product> products = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			// while 돌려서 rs -> java 오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			System.out.println(TAG + "Price() : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return null;

	} // end of Price
	
	public List<Product> Count() {
		
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY count DESC";
		
		List<Product> products = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			// while 돌려서 rs -> java 오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			
			return products;
		} catch (Exception e) {
			System.out.println(TAG + "Count(); : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return null;

	}// end of Count
	
public int Delete(int id) {
		
		final String SQL = "DELETE FROM product WHERE id= ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, id);

			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(TAG + "Delete(); : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;

	}
}

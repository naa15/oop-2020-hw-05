package ManagerPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.MyDBInfo;

public class ProductManager {
	private List<Product> products= new ArrayList<Product>();
	private Connection connection;
	public ProductManager(){
		initProducts();
	}
	private Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MyDBInfo.MYSQL_DATABASE_SERVER + "/" + MyDBInfo.MYSQL_DATABASE_NAME;
			connection = DriverManager.getConnection(url, MyDBInfo.MYSQL_USERNAME, MyDBInfo.MYSQL_PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private void initProducts() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MyDBInfo.MYSQL_DATABASE_SERVER + "/" + MyDBInfo.MYSQL_DATABASE_NAME;
			connection = DriverManager.getConnection(url, MyDBInfo.MYSQL_USERNAME, MyDBInfo.MYSQL_PASSWORD);

			PreparedStatement statement = connection.prepareStatement("Select * from products");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String image = rs.getString(3);
				Double price = rs.getDouble(4);
				System.out.println(id);
				System.out.println(name);
				System.out.println(image);
				System.out.println(price);

				products.add(new Product(id, name, price, image));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Product getById(String id) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement("Select * from products where productid=?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(2);
				String image = rs.getString(3);
				Double price = rs.getDouble(4);
				return new Product(id, name, price, image);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Product> getProducts(){
		return products;
	}
}

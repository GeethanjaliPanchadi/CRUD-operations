package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/anju";
	private static final String username="root";
	private static final String password="Geethu@2212";
	private static Connection conn;
	private static PreparedStatement pmst;

	public static void main(String[] args) {
		try {
			Scanner scr = new Scanner(System.in);
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("enter table name: ");
			String sql = "delete from " +scr.next()+" where branch = ?";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter branch");
			pmst.setString(1, scr.next());
			int i = pmst.executeUpdate();
			if( i>0) {
				System.out.println("succesfully");
			}
			else {
				System.out.println("error");
			}
			pmst.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

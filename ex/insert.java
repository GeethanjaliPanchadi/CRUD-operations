package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert {
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
			String sql = "insert into ex(name,email,branch) values(?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter name");
			pmst.setString(1, scr.next());
			System.out.println("enter email");
			pmst.setString(2, scr.next());
			System.out.println("enter branch");
			pmst.setString(3, scr.next());
			int i = pmst.executeUpdate();
			if(i>0) {
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

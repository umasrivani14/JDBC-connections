package inserting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class adding {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/crudoperations";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection conn;
	private static PreparedStatement pmst;

	public static void main(String[] args) {

		try {
			Scanner src = new Scanner(System.in);
			Class.forName(Driver);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "insert into student(name,email,password,branch)values(?,?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter name: ");
			pmst.setString(1, src.next());
			System.out.println("enter email:");
			pmst.setString(2, src.next());
			System.out.println("enter password:");
			pmst.setString(3, src.next());
			System.out.println("enter branch:");
			pmst.setString(4, src.next());

			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("data inseted");
			} else {
				System.out.println("data not inserted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
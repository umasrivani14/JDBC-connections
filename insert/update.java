package inserting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String Username="root";
	private static final String Password="root";
	private static final String url="jdbc:mysql://localhost:3306/crudoperations";
	private static Connection conn;
	private static PreparedStatement pmst;	
	public static void main(String[] args) {
		
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, Username, Password);
			String sql="update student set  name=?,email=?,password=?,branch=? where branch=?";
			pmst=conn.prepareStatement(sql);
			
			System.out.println("enter new name:");
			pmst.setString(1, src.next());
			System.out.println("enter new email:");
			pmst.setString(2, src.next());
			System.out.println("enter new password:");
			pmst.setString(3, src.next());
			System.out.println("enter new branch:");
			pmst.setString(4, src.next());
			System.out.println("enter old  branch:");
			pmst.setString(5, src.next());
			
			int i =pmst.executeUpdate();
			if(i>0) {
				System.out.println("succesfully updated");
			}
			else {
				System.out.println("not updated");
				
			}
			conn.close();
			pmst.close();
			src.close();		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
	}

}

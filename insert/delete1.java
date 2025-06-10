package inserting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class delete1 {
	
		private static final String Driver="com.mysql.cj.jdbc.Driver";
		private static final String Username="root";
		private static final String Password="root";
		private static final String url="jdbc:mysql://localhost:3306/crudoperations";
		private static Connection conn;
		private static PreparedStatement pmst;	
		public static void main(String[] args) {
			
			try {
				Class.forName(Driver);
				conn=DriverManager.getConnection(url, Username, Password);
				System.out.println("Enter the colunm name to be deleted : ");
				String sql="delete from student where id=?";
				pmst=conn.prepareStatement(sql);
				int i = pmst.executeUpdate();
				if(i==0) {
					System.out.println("database deleted");
				}
				else {
					System.out.println("database not deleted");
				}
				conn.close();
				pmst.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



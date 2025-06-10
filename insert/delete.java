package inserting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class delete {
	
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
				String sql="delete from student where id=?";
				pmst=conn.prepareStatement(sql);
				
				System.out.println("enter id to be deleted:");
				pmst.setInt(1, src.nextInt());
								
				int i =pmst.executeUpdate();
				if(i==0) {
					System.out.println("succesfully deleted");
				}
				else {
					System.out.println("not deleted");
					
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



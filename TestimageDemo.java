package Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestimageDemo {

	public static void main(String[] args) throws FileNotFoundException, SQLException{
		
		Connection con = DoctorPortal.DBUtil.getConnect();
		FileInputStream fin = new FileInputStream("D://Users//pexels-pixabay-268533.jpg");
		String inserQuery = "insert into User_Details values(?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id");
		int id = sc.nextInt();
		PreparedStatement ps = con.prepareStatement(inserQuery);
		ps.setInt(1, id);
		ps.setBinaryStream(2, fin);
		int status = ps.executeUpdate();
		if(status>0)
		{
			System.out.println("saved details");
		}
		else {
			System.out.println("Not able to save");
		}
	}

}

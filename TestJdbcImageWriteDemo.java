package Image;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJdbcImageWriteDemo {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con = DoctorPortal.DBUtil.getConnect();
		FileOutputStream fout = new FileOutputStream("./src/db.pexels-pixabay-268533.jpg");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		PreparedStatement ps = con.prepareStatement("select user_photo from User_Details where user_id =?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			byte[] imageBytes=rs.getBytes(1);
			fout.write(imageBytes);
			System.out.println("file fetched and written to db-image.png file");
		}

	}

}

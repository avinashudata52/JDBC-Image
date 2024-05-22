package Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;

public class TestInsertInfoDemo {

	public static void main(String[] args) throws SQLException, ParseException {
	
		Connection con = DoctorPortal.DBUtil.getConnect();
		final String sqlQuery="insert into Account_Info values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number");
		long acc= sc.nextLong();
		System.out.println("Enter account balance");
		double acc1 = sc.nextDouble();
		System.out.println("Enter account holder name");
		String name = sc.next();
		System.out.println("Enter account opening date yyyy--mm--dd");
		String dateOfOpening = sc.next();		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date d = sdf.parse(dateOfOpening);
			System.out.println(d);
			
		
	}

}

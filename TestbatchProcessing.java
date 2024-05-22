package Image;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class TestbatchProcessing {

	public static void main(String[] args) throws SQLException {

		Connection con = DoctorPortal.DBUtil.getConnect();
		final String INSERT_INTO_DOCTOR_TABLE
		="insert into Doctor_Table values(108,'Avinash','avin@123','Pass@123','heart',18)";
		final String STUDENT_TABLE = "insert into student_table values(109,'Ram')";
		final String UPDATE_EMP_TABLE1 = "UPDATE EMP_TABLE1 SET SALARY = SALARY+5000 WHERE ID=2";
	
		Statement stmt = con.createStatement();
		
		stmt.addBatch(INSERT_INTO_DOCTOR_TABLE);
		stmt.addBatch(UPDATE_EMP_TABLE1);
		stmt.addBatch(STUDENT_TABLE);
		
		int[] batchStatus = stmt.executeBatch();
		System.out.println("The array status is"+" "+Arrays.toString(batchStatus));
		
	}

}

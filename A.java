
import java.sql.*;

public class DONOR {
    public static void main(String[] args) {
        try {

            Class.forName("org.postgresql.Driver");


            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/bcs", "bcs", "bcs");

            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from donor");

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("\t-------------------------------------------------");

            int count = rsmd.getColumnCount();
            System.out.println("\t No. of Columns: " + rsmd.getColumnCount());
            System.out.println("\t-------------------------------------------------");
            for (int i = 1; i <= count; i++) 
            {
                System.out.println("\t\tColumn No : " + i);
                System.out.println("\t\tColumn Name : " + rsmd.getColumnName(i));
                System.out.println("\t\tColumn Type : " + rsmd.getColumnTypeName(i));
                System.out.println("\t\tColumn Display Size : " + rsmd.getColumnDisplaySize(i));
                System.out.println();
            } // for
            System.out.println("\t--------------------------------------------------");

            rs.close();
            stmt.close();
            conn.close();
        } // try
        catch (Exception e) {
            System.out.println(e);
        } // catch
    }
}

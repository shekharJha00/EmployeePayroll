import java.sql.*;


public class JDBCOperations {
    public static void main(String[] args) {

        Connection con = null;
        Statement stmt = null;
        String qry = "update employee_payroll set basic_pay=3000000.00 where name='Shekhar'";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Driver Class Loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");

            System.out.println("Connection Establish with db server");

            stmt = con.createStatement();
            System.out.println("Platform Created");

            stmt.executeUpdate(qry);
            System.out.println("Data Update");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                    System.out.println("Closed All Resources");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Closed All Resources");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}


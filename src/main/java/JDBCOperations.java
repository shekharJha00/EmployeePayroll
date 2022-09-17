import java.sql.*;


public class JDBCOperations {
    static Connection con;
    static Statement statement;
    static ResultSet rs;
    public static void main(String[] args) throws Exception {


        String qry = "select avg(basic_pay), sum(basic_pay), min(basic_pay), max(basic_pay) from employee_payroll where gender = 'F' group by gender; ";
        try {

            System.out.println("Driver Class Loaded");

            con = DBConnection.createCP();

            System.out.println("Connection Establish with db server");

            statement = con.createStatement();
            System.out.println("Data Update");

            rs = statement.executeQuery(qry);

            while (rs.next()) {
                double sum = rs.getDouble(1);
                System.out.println("average of basic_pay : " + sum);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (statement != null) {
                try {
                    statement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Closed All Resources");
        }
    }

}


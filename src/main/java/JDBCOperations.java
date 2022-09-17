import java.sql.*;


public class JDBCOperations {
    public static void main(String[] args) {

            String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
            String userName = "root";
            String password = "eGain@123";
            Statement stmt = null;
            Connection con = null;
            ResultSet rs = null;

            String qry = "select * from employee_payroll";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Class Loaded");

                con = DriverManager.getConnection(jdbcURL, userName, password);
                System.out.println("Connection Establish with db server");

                stmt = con.createStatement();

                rs = stmt.executeQuery(qry);

                System.err.println("id-> " + "EmployeesName-> " + "mobileNumber-> " + "address-> " + "gender-> " + " basic_pay-> " + "deductions-> " + "taxable_pay-> " + "tax-> " + "net_pay-> "
                        + "start");

                while (rs.next()) {
                    int id = rs.getInt("EmpId");
                    String EmployeesName = rs.getString(2);
                    long mobileNumber = rs.getLong(3);
                    String address = rs.getString(4);
                    String gender = rs.getString(5);
                    double basic_pay = rs.getDouble(6);
                    double deductions = rs.getDouble(7);
                    double taxable_pay = rs.getDouble(8);
                    double tax = rs.getDouble(9);
                    double net_pay = rs.getDouble(10);
                    Date start = rs.getDate(11);

                    System.out.println();

                    System.out.println(id + "->" + EmployeesName + "->" + mobileNumber + "->" + address + "->"
                            + "->" + gender + "->" + basic_pay + "->" + deductions + " ->" + taxable_pay + "->" + tax + "->"
                            + net_pay + "->" + start);
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
                if (stmt != null) {
                    try {
                        stmt.close();

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
            }
    }
}


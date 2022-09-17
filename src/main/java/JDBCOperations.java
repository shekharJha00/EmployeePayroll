import java.sql.*;


public class JDBCOperations {
    static Connection con;
    public static void main(String[] args) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String qry = "select * from employee_payroll where Emp_Name='Shekhar'";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Driver Class Loaded");

            con = DBConnection.createCP();

            System.out.println("Connection Establish with db server");

            preparedStatement = con.prepareStatement(qry);
            System.out.println("Data Update");

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                long phone_number = rs.getLong(3);
                String address = rs.getString(4);
                String department = rs.getString(5);
                String gender = rs.getString(6);
                double basic_pay = rs.getDouble(7);
                double deductions = rs.getDouble(8);
                double taxable_pay = rs.getDouble(9);
                double tax = rs.getDouble(10);
                double met_pay = rs.getDouble(11);
                Date state = rs.getDate(12);

                System.out.println("EmpId :-" + id + "  " + "EmpName :- " + name + " " + "Emp_PhoneNo. :-"
                        + phone_number + " " + "EmpAddress :- " + address + " " + " EmpDepartment :-" + department + " "
                        + "Gender :- " + gender + " " + "Basic_Pay " + basic_pay + " " + " Deduction :- " + deductions
                        + " " + "Taxable_pay :- " + taxable_pay + " " + "Tax :-" + tax + " " + "Met_Pay :- " + met_pay
                        + " " + "Date :-" + state);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

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



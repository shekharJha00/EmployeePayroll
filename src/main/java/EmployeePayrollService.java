import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    private final List<EmployeePayrollData> employeePayrollList;
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
            EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
            employeePayrollService.readEmployeePayrollData(scanner);
            employeePayrollService.writeEmployeePayrollData();
        }

        public void readEmployeePayrollData(Scanner scanner) {
            System.out.println("Enter Employee ID");
            int id = scanner.nextInt();
            System.out.println("Enter Employee Name");
            String name = scanner.next();
            System.out.println("Enter Employee Salary");
            int salary = scanner.nextInt();
            employeePayrollList.add(new EmployeePayrollData(id, name, salary));
        }

        private void writeEmployeePayrollData() {
            System.out.println("Employee Payroll\n" + employeePayrollList);
        }
    }


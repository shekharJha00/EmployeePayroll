import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public EmployeePayrollService() {

        employeePayrollList = null;
    }

    public void printData() {
        try {
            Files.lines(new File(EmployeePayrollFileIO.PAYROLL_FILE).toPath()).forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(EmployeePayrollFileIO.PAYROLL_FILE).toPath()).count();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return entries;
    }

    public enum IOService {
        CONSOLE_IO, FILE_IO
    }
    private final List<EmployeePayrollData> employeePayrollList;
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
            EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
            employeePayrollService.readEmployeePayrollData(scanner);
            employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
        }

        public void readEmployeePayrollData(Scanner scanner) {
            System.out.println("Enter Employee ID :");
            int id = scanner.nextInt();
            System.out.println("Enter Employee Name :");
            String name = scanner.next();
            System.out.println("Enter Employee Salary :");
            int salary = scanner.nextInt();
            employeePayrollList.add(new EmployeePayrollData(id, name, salary));
        }
    public void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("Employee Payroll\n" + employeePayrollList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIO().writeData(employeePayrollList);
    }
    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIO().printData();
    }
    public int countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIO().countEntries();
        return 0;
    }
}



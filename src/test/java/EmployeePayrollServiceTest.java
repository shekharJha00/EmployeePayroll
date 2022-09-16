import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class EmployeePayrollServiceTest {
    @Test
    public void givenEmployeesPayrollWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayrollData[] payrollData = {
                new EmployeePayrollData(1, "Shekhar", 400000),
                new EmployeePayrollData(2, "Goku", 600000),
                new EmployeePayrollData(3, "Nuts", 500000),
                new EmployeePayrollData(4, "Naman", 800000),
        };
        EmployeePayrollService employeePayrollService= new EmployeePayrollService(Arrays.asList(payrollData));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(4, entries);
    }
    @Test
    public void givenFileShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assert.assertEquals(4, entries);
    }
}

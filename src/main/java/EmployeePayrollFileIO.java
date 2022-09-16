import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIO {
    public static String PAYROLL_FILE = "Employee_Payroll.txt";
    public void writeData(List<EmployeePayrollData> employeePayrollDataList) {
        StringBuffer stringBuffer = new StringBuffer();
        employeePayrollDataList.forEach(employeePayrollData -> {
            String employeeDataString = employeePayrollData.toString().concat("\n");
            stringBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE),stringBuffer.toString().getBytes());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

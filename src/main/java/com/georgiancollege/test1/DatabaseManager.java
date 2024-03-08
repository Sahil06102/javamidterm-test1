import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java-midterm";
    private static final String DB_USERNAME = "Root";
    private static final String DB_PASSWORD = "sahil321";

    public List<Employee> getEmployeesFromDatabase() {
        List<Employee> employees = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM midTermEmployee");

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String province = resultSet.getString("province");
                String phone = resultSet.getString("phone");

                Employee employee = new Employee(employeeId, firstName, lastName, address, city, province, phone);
                employees.add(employee);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
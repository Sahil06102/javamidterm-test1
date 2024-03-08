package com.georgiancollege.test1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee, Integer> employeeIdColumn;

    @FXML
    private TableColumn<Employee, String> firstNameColumn;

    @FXML
    private TableColumn<Employee, String> lastNameColumn;

    @FXML
    private TableColumn<Employee, String> addressColumn;

    @FXML
    private TableColumn<Employee, String> cityColumn;

    @FXML
    private TableColumn<Employee, String> provinceColumn;

    @FXML
    private TableColumn<Employee, String> phoneColumn;

    @FXML
    private CheckBox ontarioOnlyCheckBox;

    @FXML
    private ComboBox<String> areaCodeComboBox;

    @FXML
    private Label noOfEmployeesLabel;

    private DatabaseManager databaseManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        areaCodeComboBox.getItems().add("All","519","506","604","905","902");
        databaseManager = new DatabaseManager();
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        List<Employee> employees = databaseManager.getEmployeesFromDatabase();
        tableView.getItems().addAll(employees);
        updateTableView();
    }

    private void updateTableView() {
        List<Employee> filteredEmployees = tableView.getItems();
        if (ontarioOnlyCheckBox.isSelected()) {
            filteredEmployees = filteredEmployees.stream()
                    .filter(employee -> employee.getProvince().equals("ON"))
                    .toList();
        }
        String selectedAreaCode = areaCodeComboBox.getValue();
        if (!selectedAreaCode.equals("All")) {
            filteredEmployees = filteredEmployees.stream()
                    .filter(employee -> employee.getPhone().startsWith(selectedAreaCode))
                    .toList();
        }

        tableView.setItems(filteredEmployees);
        noOfEmployeesLabel.setText("Total Employees: " + filteredEmployees.size());
    }

    @FXML
    void ontarioOnlyCheckBox_OnClick(ActionEvent event) {
        updateTableView();
    }

    @FXML
    void areaCodeComboBox_OnClick(ActionEvent event) {
        updateTableView();
    }
}
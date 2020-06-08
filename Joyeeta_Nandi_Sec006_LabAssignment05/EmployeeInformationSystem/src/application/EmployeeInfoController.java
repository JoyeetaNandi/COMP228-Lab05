package application;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeInfoController {
	
	List <Employee> employeeList = new ArrayList<Employee>();
	

    @FXML
    private TextField textEmployeeID;

    @FXML
    private TextField textEmployeeName;

    @FXML
    private TextField textSalary;

    @FXML
    private DatePicker datePicketDateOfJoining;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonDisplayAll;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField textSearchEmployee;

    @FXML
    private TextField textSearchResult;

    @FXML
    private TextArea textListEmployee;
    
    //@FXML
    
    
    
    @FXML
    void buttonAddClicked(ActionEvent event) {    	
    	
    	int employeeID = Integer.parseInt(textEmployeeID.getText());
    	String employeeName = (textEmployeeName.getText());
    	LocalDate dateOfJoining = datePicketDateOfJoining.getValue();
		double salary = Double.parseDouble(textSalary.getText());
		
		//textListEmployee.getText() = textListEmployee.getText() + "Dina";
		//textListEmployee.getText() = textListEmployee.getText() + "Sally";
		
		try {
						
			if(textEmployeeID.getText().length()==3) {
				//employeeID = Integer.parseInt(textEmployeeID.getText());
				textSearchResult.setText("Employee Id: "+ employeeID + ", Employee name: " + employeeName);
			}
			else {    			
    			throw new Exception("Employee Id must be 3 disit"); 
    		}
		}			
		catch(Exception ex) {
    		textSearchResult.setText("Error: "+ ex.getMessage());
		}
		
    	Employee employee = new Employee(employeeID, employeeName, dateOfJoining, salary);
		employeeList.add(employee);
    	
    	 }

    @FXML
    void buttonClearClicked(ActionEvent event) {  	
    	
    	textEmployeeID.setText(" ");
    	textEmployeeName.setText(" ");
    	datePicketDateOfJoining.setValue(null);
    	
    	textSalary.setText(" ");
    	textSearchResult.setText(" ");

    }

    @FXML
    void buttonDisplayAllClicked(ActionEvent event) {
    	textListEmployee.setText("EmployeeID  Employtee Name  Date Of Joining  Salary" + "\n");
    	for(Employee emp : employeeList) {
    		textListEmployee.setText(textListEmployee.getText() + emp.toString() + "\n");
    	}
    }

    @FXML
    void buttonSearchClick(ActionEvent event) {
    	
    	boolean answer = false;
    	try {
	      for (Employee employee: employeeList){
	    	  if(employee.getName().equals(textSearchEmployee.getText())) {	    	 
	    		  answer = true;
	    	  }
		      else if (employee.getEmployeeId()== Integer.parseInt(textSearchEmployee.getText())) {
		    	  answer = true;
		      }		      
		  }	      
	      if(answer) {	    	  
	    	  textSearchResult.setText("Employee Exists");			 
	      }
	      else {
	    	  //textSearchResult.setText("Employee does not Exists");
	    	  throw new Exception ("Employee does not Exists ");
	      } 
    	}
    	catch(Exception ex) {
    		textSearchResult.setText("Employee does not Exists");
    		//textSearchResult.setText("Error: "+ ex.getMessage());
    	}
    }

}

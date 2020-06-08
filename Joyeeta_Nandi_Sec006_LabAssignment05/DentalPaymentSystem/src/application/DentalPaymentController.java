package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DentalPaymentController {
	
	 @FXML
	    private double discount;
	    double tax=1;	    
	    
	    Alert alert = new Alert(AlertType.ERROR);
	    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField patientName;

    @FXML
    private TextField address;

    @FXML
    private ComboBox<String> provincesComboBox;
    
    
    private void getProvince(){
    	boolean provinceNotSelected = provincesComboBox.getSelectionModel().isEmpty();
    	
    	if(provinceNotSelected) {    		
        	alert.setTitle("Alart!");
        	alert.setHeaderText("Province is not Selected");
        	alert.setContentText("Please select a province!");
        	alert.showAndWait();
    	}
    	else {        	
    		String provinceSelection = provincesComboBox.getSelectionModel().getSelectedItem().toString();
        	
        	switch(provinceSelection){
        	case "Alberta - 7%":
        		tax = .07;
        		break;
        	case "Ontario - 13%":
        		tax = .13;
        		break;
        	case "Quebec - 6%":
        		tax = .06;
        		break;
        	}
    	}
    }

    @FXML
    private RadioButton seniorRadioButton;

    @FXML
    private ToggleGroup ageTaggleGroup;

    @FXML
    private RadioButton kidsYouthRadioButton;

    @FXML
    private RadioButton adultRadioButton;

    @FXML
    private CheckBox flossingCheckBox;
   

    @FXML
    private Label calculateLabel;

    @FXML
    private Button calculateButton;

    @FXML
    private CheckBox fillingCheckBox;
    

    @FXML
    private CheckBox rootCanalCheckBox;
   
   
    @FXML
    void kidsYouthChecked(ActionEvent event) {
        	discount = .10;
    }

    @FXML
    void seniorChecked(ActionEvent event) {
        	discount = .15;
    }
    
    @FXML
    void adultChecked(ActionEvent event) {
        	discount = .00;
    }
    
    @FXML
    void buttonCalculateClick(ActionEvent event) {
    	
    	int flossing = 20, filling = 75, rootCanal = 150, totalBeforeDiscount = 0;
    	double tax = 1;
    	
    	try {      		
    		getProvince();
        	if(ageTaggleGroup.getSelectedToggle() == null) {
            	alert.setTitle("Alart!");
            	alert.setHeaderText("Age group is not selected");
            	alert.setContentText("Please select Age group!");
            	alert.showAndWait();
        	}
        	else {
        		
        		if(flossingCheckBox.isSelected()) {
    				totalBeforeDiscount = totalBeforeDiscount + flossing;
    			}
    		
    			if(fillingCheckBox.isSelected()) {
    				totalBeforeDiscount = totalBeforeDiscount + filling;
    			}
    		
    			if(rootCanalCheckBox.isSelected()) {
    				totalBeforeDiscount = totalBeforeDiscount + rootCanal;
    			}    	
        		
    			if(provincesComboBox.getValue() == "Alberta - 7%"){
    				tax = 1.07;
    			}
    			else if(provincesComboBox.getValue() == "Ontario - 13%")
    			{
    				tax = 1.13;
    			}
    			else if(provincesComboBox.getValue() == "Quebec - 6%")
    			{
    				tax = 1.06;
    			}
    			
    		    		
    		double total = totalBeforeDiscount * tax;
    		
    		if(kidsYouthRadioButton.isSelected()) {
				total = total - total*0.15;    			
			}
			else if(seniorRadioButton.isSelected()) {
				total = total - total*0.10;
			}
		
			else if(adultRadioButton.isSelected()) {
				total = total;
			}
    			
    			
        		calculateLabel.setText(String.format("%.2f", total));
        	}  		   
    	}
    
    	catch(Exception ex) {
    		calculateLabel.setText("Error:" + ex.getMessage());
    	
    		}
    	
    	}
    

    @FXML
    void initialize() {
    	provincesComboBox.getItems().addAll("Alberta - 7%", "Ontario - 13%", "Quebec - 6%");
        
    }
}

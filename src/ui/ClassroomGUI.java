package ui;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;

public class ClassroomGUI {
	
	private Classroom classroom;
	
	private Stage primaryStage;
	
	@FXML
    private BorderPane mainPane;	

    @FXML
    private TextField logUser;
    
    @FXML
    private PasswordField logPassword;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPhoto;
    
    @FXML
    private RadioButton btnMale;

    @FXML
    private RadioButton btnFemale;

    @FXML
    private RadioButton btnOther;

    @FXML
    private CheckBox btnSoftware;

    @FXML
    private CheckBox btnTelematic;

    @FXML
    private CheckBox btnIndustrial;

    @FXML
    private DatePicker btnBirthday;   

    @FXML
    private ComboBox<String> btnFavBrowser;
    
    public void logIn() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		 fxmlLoader.setController(this);
		 Parent root = fxmlLoader.load();
		 mainPane.getChildren().clear();
		 mainPane.setCenter(root);
		 primaryStage.close();
		 primaryStage.show();

	 }
    
    @FXML
    public void singUp(ActionEvent event) throws IOException {
    	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));		 
		 fxmlLoader.setController(this);
		 Parent root = fxmlLoader.load();
		 mainPane.getChildren().clear();
		 mainPane.setCenter(root);
		 primaryStage.close();
		 primaryStage.show();
		 btnFavBrowser.getItems().addAll(
			 "Firefox",
			 "Chrome",
			 "Edge",
			 "Safari",
			 "Opera",
			 "Thor"
		 );		
	}
    
    @FXML
    public void selectMale(ActionEvent event) {
    	btnMale.setSelected(true);
		btnFemale.setSelected(false);
		btnOther.setSelected(false);
    }
    
    @FXML
    public void selectFemale(ActionEvent event) {    	
    	btnFemale.setSelected(true);
		btnMale.setSelected(false);
		btnOther.setSelected(false);
    }
    
    @FXML
    public void selectOther(ActionEvent event) {
    	btnOther.setSelected(true);
		btnFemale.setSelected(false);
		btnMale.setSelected(false);

    }
    
    @FXML
    public void browsePhoto(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
		File file = fileChooser.showOpenDialog(primaryStage);
		if (file != null) {
			txtPhoto.setText(file.getAbsolutePath());
		}

    }

    
    @FXML
    public void verifyCredentials(ActionEvent event) {

    }
    
    @FXML
    public void verifyInformation(ActionEvent event) throws IOException {    	
    	if((!btnFemale.isSelected()&&!btnMale.isSelected()&&!btnOther.isSelected()) || 
				 ((!btnSoftware.isSelected())&&(!btnTelematic.isSelected())&&(!btnIndustrial.isSelected())||
				 txtUserName.getText().trim().equals("") || txtPassword.getText().trim().equals("") || 
				 txtPhoto.getText().trim().equals("") || btnBirthday.getValue()==null || btnFavBrowser.getValue()==null)){
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Alert");
    		alert.setHeaderText("Error");
    		alert.setContentText("You must fill each field in the form");
    		alert.showAndWait();
    				
				
			} else if(classroom.verifyUsername(txtUserName.getText())){
				Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setTitle("Alert");
	    		alert.setHeaderText("Error");
	    		alert.setContentText("This username already exist");
	    		alert.showAndWait();
			} else {
				createAccount();
			}

	    }

    
    private void createAccount() throws IOException {
		 String gender = "";
		 if(btnFemale.isSelected()) {
			 gender = "Female";
		 } else if(btnMale.isSelected()) {
			 gender = "Male";
		 } else if(btnOther.isSelected()) {
			 gender = "Other";
		 }
		 
		 String career = "";
		 if(btnSoftware.isSelected()) {
			 career+=btnSoftware.getText()+"\n";
		 }
		 if(btnTelematic.isSelected()) {
			 career+=btnTelematic.getText()+"\n";
		 }
		 if(btnSoftware.isSelected()) {
			 career+=btnIndustrial.getText()+"\n";
		 }
		 classroom.createAccount(txtUserName.getText().trim(), txtPassword.getText().trim(), txtPhoto.getText(), gender, 
					career, btnBirthday.getValue(), btnFavBrowser.getValue());
			
		
		 
		 logIn();
			
			
			
	}
    
   
    
   

    @FXML
    public void loadLogIn(ActionEvent event) throws IOException {
    	logIn();

    }
    
   
   
    
    
      


	private void loadList() {
		// TODO Auto-generated method stub
		
	}



	public void setStage(Stage stage) {
		primaryStage= stage;
		
	}
	public ClassroomGUI(Classroom cm) {
		classroom = cm;
		
	}
	
	

}

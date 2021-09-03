package quiz_teacher;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	@FXML Button login;
	@FXML TextField id;
	@FXML PasswordField pwd;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		login.setOnAction(e-> {
			userCheck();
		});
		
	}

	public void userCheck() {
		
		if(check()) {
			
		}
	}
	
	public void msgBox(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	
	public boolean check() {
		if(id.getText().isEmpty()) {
			msgBox("아이디를 입력하세요");
			id.requestFocus();
			pwd.clear();
			return false;
		} else if (pwd.getText().isEmpty()) {
			msgBox("비밀번호를 입력하세요");
			pwd.requestFocus();
			return false;
		}
		return true;
	}
}

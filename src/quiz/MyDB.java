package quiz;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MyDB implements Initializable {

	@FXML private Button login;
	@FXML private TextField id;
	@FXML private PasswordField pass;
	
	
	private HashMap<String,String> table;
	
	public MyDB() {
		
		table = new HashMap<>();
		table.put("if", "if1234");
		table.put("else","else1234");
		table.put("while", "while1234");
		table.put("for", "for1234");
		table.put("admin", "admin1234");
		
	}
	
	@Override	//초기화 용도
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		login.setOnAction(e-> {
		
			switch(checkTxtField()) {
			case 1 :
				noneError();
				break;
			case 2 :
				nonePassError();
				break;
			case 3 :
				if(login()==0) {
					loginFail();
				} else {
					loginSuccess();
				}
				break;
			}
			
		});
		
	}
	
	public int checkTxtField() {
		if (id.getText().isEmpty() && pass.getText().isEmpty()) {
			return 1;
		} else if (id.getText()!=null && pass.getText().isEmpty()) {
			return 2;
		} else {
			return 3;
		}
	}
	
	public void noneError() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("아이디와 비밀번호를 입력하세요");
		alert.show();
	}
	
	public void nonePassError() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("비밀번호를 입력해야합니다");
		alert.show();
	}
	
	public void loginFail() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("로그인 실패 : 로그인 정보가 일치하지 않습니다");
		alert.show();
	}
	
	public void loginSuccess() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("로그인 성공 : 환영합니다! ");
		id.clear();
		pass.clear();
		alert.show();
	}
	
	public int login() {
		if (table.containsKey(id.getText()) && table.get(id.getText()).equals(pass.getText())) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

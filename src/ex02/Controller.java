package ex02;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable{

	@FXML 				//eventTest.fxml에서 만든 Button을 받아오는 것
	private Button btn;	//eventTest.fxml에서 설정한 변수명과 동일해야한다	
	@FXML
	private TextField txtField;
	@FXML
	private TextField txtField02;
	
	@Override	//초기화 용도
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		System.out.println("초기화 목적으로 사용합니다");
		
		btn.setOnAction(e-> {
			txtMove();
			alert();
		});
		
	}
	
	public void txtPrint() {
		System.out.println(txtField.getText());
	}
	
	public void txtMove() {
		txtField02.setText(txtField.getText());
		txtField.setText(null);
	}
	
	public void alert() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("조심하세요");
		alert.show();
	}
	
}

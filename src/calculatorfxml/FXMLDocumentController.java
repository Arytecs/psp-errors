/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author araceliteruel
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField number1;
    @FXML
    private ChoiceBox<?> cbox;
    @FXML
    private TextField number2;
    @FXML
    private Button btn;
    @FXML
    private TextField result;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> items=FXCollections.observableArrayList("+","-","*","/");
        cbox=new ChoiceBox(items);
    }    

    @FXML
    private void calculate(ActionEvent event) {
        try{
            switch((String) cbox.getValue()){
            case "+":
                result.setText(Integer.toString(Integer.parseInt(number1.getText())+Integer.parseInt(number2.getText())));
                break;
            case "-":
                result.setText(Integer.toString(Integer.parseInt(number1.getText())-Integer.parseInt(number2.getText())));
                break;
            case "*":
                result.setText(Integer.toString(Integer.parseInt(number1.getText())*Integer.parseInt(number2.getText())));
                break;
            case "/":
                if(Integer.parseInt(number2.getText())==0)
                    result.setText("Math Error");
                else{
                    result.setText(Integer.toString(Integer.parseInt(number1.getText())/Integer.parseInt(number2.getText())));
                }
                break;
            default: result.setText("No selection");
                break;
            }
        }
        catch (Exception ex){
            result.setText("Math Error");
        }
    }
    
}

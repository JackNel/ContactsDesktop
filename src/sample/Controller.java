package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jodd.json.JsonSerializer;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    TextField nameField;
    @FXML
    TextField phoneField;
    @FXML
    TextField emailField;
    @FXML
    ListView listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {listView.setItems(contacts);}

    public void addContact() {
        Contact contact = new Contact(nameField.getText(),phoneField.getText(), emailField.getText());
        if (nameField.getText().isEmpty() || phoneField.getText().isEmpty() || emailField.getText().isEmpty()) {

        } else {
            contacts.add(contact);
            nameField.setText("");
            phoneField.setText("");
            emailField.setText("");
        }

        JsonSerializer serializer = new JsonSerializer();
        String s = serializer.serialize(contacts);
        System.out.println();

    }//method addContact

    public void removeContact() {
        Contact contact = (Contact) listView.getSelectionModel().getSelectedItem();
        if (contact != null) {
            contacts.remove(contact);

        }
    }//method removeContact

    public void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addContact();
            nameField.requestFocus();
        }
    }//method onKeyPressed


}//class Controller

package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ComboBoxController {
    public ComboBox<Integer> cmbNumbers;
    public Button btnAdd;
    public Button btnRemove;

    public void initialize(){

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ObservableList<Integer> olNumbers = cmbNumbers.getItems();
                olNumbers.add((int)(Math.random()*10));
                //System.out.println("Add");
            }
        });

        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ObservableList<Integer> olNumbers = cmbNumbers.getItems();
                olNumbers.remove(0);
                //System.out.println("Remove");
            }
        });
    }
}

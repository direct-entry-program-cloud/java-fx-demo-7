package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerTM;

import java.util.Optional;

public class TableFormController {
    public TableView<CustomerTM> tblCustomers;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSaveCustomer;
    public Button btnNewCustomer;
    public Button btnDeleteCustomer;

    public void initialize() {

        //tblCustomers.setDisable(true);
        //btnDeleteCustomer.setDisable(true);

        btnDeleteCustomer.setDisable(true);

        /*Let's map column names*/
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList<CustomerTM> olRows = tblCustomers.getItems();
        olRows.add(new CustomerTM("C001", "Kasun", "Panadura"));
        olRows.add(new CustomerTM("C002", "Ruwan", "Colombo"));
        olRows.add(new CustomerTM("C003", "Amal", "Galle"));


        tblCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observableValue, CustomerTM previouslySelectedCustomer, CustomerTM currentlySelectedCustomer) {
                //System.out.println("Previous:"+previouslySelectedCustomer);
                //System.out.println("Current:"+currentlySelectedCustomer);
                if (currentlySelectedCustomer == null) {
                    btnDeleteCustomer.setDisable(true);
                    txtId.setEditable(true);
                    txtId.clear();
                    txtName.clear();
                    txtAddress.clear();
                    btnSaveCustomer.setText("Save Customer");
                    return;
                }
                btnDeleteCustomer.setDisable(false);
                txtId.setText(currentlySelectedCustomer.getId());
                txtName.setText(currentlySelectedCustomer.getName());
                txtAddress.setText(currentlySelectedCustomer.getAddress());

                //txtId.setDisable(true);
                txtId.setEditable(false);
                btnSaveCustomer.setText("Update Customer");
            }
        });


    }

    public void btnSaveCustomer_OnAction(ActionEvent actionEvent) {

        ObservableList<CustomerTM> olCustomers = tblCustomers.getItems();

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();

        if (id.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Customer id can not be empty").showAndWait();
            txtId.requestFocus();
            return;
        } else if (name.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Customer name can not be empty").showAndWait();
            txtName.requestFocus();
            return;
        } else if (address.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Customer address can not be empty").showAndWait();
            txtAddress.requestFocus();
            return;
        }

        if (btnSaveCustomer.getText().equalsIgnoreCase("Save Customer")) {
            for (CustomerTM customer : olCustomers) {
                if (customer.getId().equals(txtId.getText())) {
                    new Alert(Alert.AlertType.ERROR, "Duplicate customer ids are not allowed").showAndWait();
                    txtId.requestFocus();
                    return;
                }
            }

            olCustomers.add(new CustomerTM(id, name, address));

            txtId.clear();
            txtName.clear();
            txtAddress.clear();

            txtId.requestFocus();
        } else {
            CustomerTM selectedItem = tblCustomers.getSelectionModel().getSelectedItem();
            selectedItem.setName(name);
            selectedItem.setAddress(address);
            tblCustomers.refresh();
        }


    }

    public void btnNewCustomer_OnAction(ActionEvent actionEvent) {
        /*txtId.clear();
        txtName.clear();
        txtAddress.clear();*/
        tblCustomers.getSelectionModel().clearSelection();
        txtId.requestFocus();

    }

    public void btnDeleteCustomer_OnAction(ActionEvent actionEvent) {
                        /*CustomerTM selectedCustomer = tblCustomers.getSelectionModel().getSelectedItem();
                System.out.println(selectedCustomer);
                int selectedIndex = tblCustomers.getSelectionModel().getFocusedIndex();
                System.out.println(selectedIndex);*/

        //tblCustomers.getSelectionModel().select(2);

        //tblCustomers.getSelectionModel().clearSelection();

        ObservableList<CustomerTM> olCustomer = tblCustomers.getItems();
        CustomerTM selectedCustomer = tblCustomers.getSelectionModel().getSelectedItem();

        if (selectedCustomer == null) {
            return;
        }

        Optional<ButtonType> selectionOption = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this customer?", ButtonType.YES, ButtonType.NO).showAndWait();

        if (selectionOption.get() == ButtonType.YES) {
            olCustomer.remove(selectedCustomer);
            //tblCustomers.getSelectionModel().clearSelection();
        }

    }
}

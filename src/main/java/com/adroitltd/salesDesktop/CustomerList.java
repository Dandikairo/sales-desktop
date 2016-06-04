
package com.adroitltd.salesDesktop;

import com.adrotltd.sales.Customer;
import java.sql.ParameterMetaData;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author Okello
 */
public class CustomerList extends BorderPane {
    private TableView<Customer> customersTable = new TableView<Customer>();
    private ObservableList<Customer> customersObservableList;
    

    public CustomerList(List<Customer> customerList) {
        customersObservableList = FXCollections.observableArrayList(customerList);
        customersTable.setItems(customersObservableList);
        
        TableColumn<Customer,String> customerNumberColumn = new TableColumn<>("No.");
        customerNumberColumn.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getNumber()));
        
        TableColumn<Customer,String> customerNameColumn = new TableColumn<>("Name");
        customerNameColumn.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getName()));
        
        TableColumn<Customer,String> customerAddressColumn = new TableColumn<>("Address");
        customerAddressColumn.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getAddress()));
        
        TableColumn<Customer,String> customerCurrencyColumn = new TableColumn<>("Currency");
        customerCurrencyColumn.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getCurrency()));
        
        TableColumn<Customer,Double> customerBalanceColumn = new TableColumn<>("Balance");
        customerBalanceColumn.setCellValueFactory((param) -> new SimpleObjectProperty<Double>(param.getValue().getBalance()));
        
        customersTable.getColumns().addAll(Arrays.asList(customerNumberColumn,customerNameColumn,customerAddressColumn,
                customerCurrencyColumn,customerBalanceColumn));
        
        this.setCenter(customersTable);
        
    }
}

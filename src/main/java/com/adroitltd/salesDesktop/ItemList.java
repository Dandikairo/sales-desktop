
package com.adroitltd.salesDesktop;

import com.adrotltd.sales.Customer;
import com.adrotltd.sales.Item;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Okello
 */
public class ItemList extends BorderPane {
    private TableView<Item> ItemsTable = new TableView<Item>();
    private ObservableList<Item> ItemsObservableList;
    
    public ItemList(List<Item> ItemList){
    ItemsObservableList = FXCollections.observableArrayList(ItemList);
    ItemsTable.setItems(ItemsObservableList);
    
         TableColumn<Item,String> itemNoColumn = new TableColumn<>("No.");
        itemNoColumn.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getItemNo()));
        
        TableColumn<Item,String> ItemdescriptionColumn = new TableColumn<>("Description");
        ItemdescriptionColumn.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getDescription()));
        
        TableColumn<Item,Double> ItemPriceColumn = new TableColumn<>("Unit Price");
        ItemPriceColumn.setCellValueFactory((param) -> new SimpleObjectProperty<Double>(param.getValue().getUnitPrice()));
        
        ItemsTable.getColumns().addAll(Arrays.asList(itemNoColumn,ItemdescriptionColumn,ItemPriceColumn));
    
    this.setCenter(ItemsTable);
    }
}


package com.adroitltd.salesDesktop;

import com.adroitltd.metadata.TableViewMetaData;
import com.adroitltd.metadata.TableViewMetaData.Column;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
public class DataTableView extends BorderPane{
   private TableView<Object> dataTableView = new TableView<>();
   private ObservableList<Object> observableDataList;
   
public DataTableView(TableViewMetaData metaData, List<?> dataList){
   for(Column column :metaData.getColumns()){
    TableColumn<Object,Object> tableColumn = new TableColumn<>(column.getCaption());
    //tableColumn.setPrefWidth(column.getWidth());
    tableColumn.setCellValueFactory((param)-> new SimpleObjectProperty<Object>(getCellValue(param.getValue(), column.getBinding())));
    dataTableView.getColumns().add(tableColumn);
    }
   observableDataList = FXCollections.observableArrayList(dataList);
   dataTableView.setItems(observableDataList);
   this.setCenter(dataTableView);
}
   
  
   private Object getCellValue(Object rowItem, String binding){
       Class<?> rowItemClass = rowItem.getClass();
       try {
        Method getterMethod = rowItemClass.getMethod("get"+ Character.toUpperCase(binding.charAt(0))+binding.substring(1));
        return getterMethod.invoke(rowItem);
       } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
       }
   return null;
   }
}

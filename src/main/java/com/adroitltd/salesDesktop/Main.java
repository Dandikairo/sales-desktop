
package com.adroitltd.salesDesktop;

import com.adroitltd.metadata.TableViewMetaData;
import com.adrotltd.sales.Sales;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Okello
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
//        primaryStage.setTitle("Customers-Details");
//        primaryStage.setScene(new Scene(new CustomerList(Sales.getCustomer())));
//        primaryStage.show();
        
//        primaryStage.setTitle("Items-Details");
//        primaryStage.setScene(new Scene(new ItemList(Sales.getItems())));
//        primaryStage.show();
        
        //for Customers
        
//        TableViewMetaData tableViewMetaData = new TableViewMetaData();
//        tableViewMetaData.addColumn("No.", 100, "numbers");
//        tableViewMetaData.addColumn("Name", 100, "name");
//        tableViewMetaData.addColumn("Address", 100, "address");
//        tableViewMetaData.addColumn("Currency", 100, "currency");
//        tableViewMetaData.addColumn("Balance", 100, "balance");
//        
//        primaryStage.setScene(new Scene(new DataTableView(tableViewMetaData,Sales.getCustomer())));
//        primaryStage.show();
        
        // for Items
//        TableViewMetaData tableViewMetaData = new TableViewMetaData();
//        tableViewMetaData.addColumn("No.", 100, "itemNo");
//        tableViewMetaData.addColumn("Description", 200, "description");
//        tableViewMetaData.addColumn("Unit Price", 300, "unitPrice");
//        
//        
//        primaryStage.setScene(new Scene(new DataTableView(tableViewMetaData,Sales.getItems())));
//        primaryStage.show();
        
        //MainWindows
        primaryStage.setScene(new Scene(new MainWindow()));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

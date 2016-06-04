
package com.adroitltd.salesDesktop;

import com.adroitltd.metadata.MenuGroup;
import com.adroitltd.metadata.MenuItem;
import com.adroitltd.metadata.TableViewMetaData;
import com.adrotltd.sales.Sales;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Okello
 */
public class MainWindow extends SplitPane{
    
    TreeView<MenuItem> navigationMenu = new TreeView<>();
    BorderPane contentPane  =new BorderPane();

    public MainWindow() {
        this.setOrientation(Orientation.HORIZONTAL);
        this.getItems().addAll(navigationMenu, contentPane);
        this.setDividerPositions(0.3,0.7);
        
     
        
        navigationMenu.setRoot(new NavigationMenuTreeItem(Sales.getNavigationMenu()));
        navigationMenu.setOnMouseClicked((event) -> {
            NavigationMenuTreeItem selectedItem = (NavigationMenuTreeItem) navigationMenu.getSelectionModel().getSelectedItem();
            if(selectedItem != null){
                openTarget(selectedItem.getValue().getTarget());
            }
        });
       }
    
    private void openTarget(int targetId){
        TableViewMetaData targetViewMetaData = Sales.getTarget(targetId);
        
        if(targetViewMetaData != null){
        contentPane.setTop(new Label(targetViewMetaData.getTitle()));
        contentPane.setCenter(new DataTableView(targetViewMetaData, Sales.getTargetData(targetId)));
        }
    }

    
    
    class NavigationMenuTreeItem extends TreeItem<MenuItem>{
        private boolean childrenLoaded  = false;

        public NavigationMenuTreeItem(MenuItem menuItem) {
            this.setValue(menuItem);
        }

        @Override
        public boolean isLeaf() {
            return !(this.getValue() instanceof MenuGroup);
        }

        @Override
        public ObservableList<TreeItem<MenuItem>> getChildren() {
            if(!childrenLoaded){
                for(MenuItem menuItem :((MenuGroup)this.getValue()).getChildren()){
                super.getChildren().add(new NavigationMenuTreeItem(menuItem));
                }
                childrenLoaded = true;
            }
            return super.getChildren();
        }
        
        
    }
}

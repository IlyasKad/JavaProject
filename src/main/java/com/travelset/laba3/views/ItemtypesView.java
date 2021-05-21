package com.travelset.laba3.views;

import com.travelset.laba3.controllers.ItemtypeController;
import com.travelset.laba3.model.entity.Category;
import com.travelset.laba3.model.entity.Itemtype;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "itemtypes", layout = MainView.class)
@PageTitle("Itemtypes")
public class ItemtypesView extends Div{

    Grid<Itemtype> grid = new Grid<>(Itemtype.class);
    ItemtypeController itemtypeController;

    public ItemtypesView(ItemtypeController itemtypeController) {
        this.itemtypeController = itemtypeController;
        addClassName("itemtypes-view");
        setSizeFull();
        configureGrid();
        add(grid);
        updateList();
    }


    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("name");
        grid.addColumn(itemtype -> itemtype.getCategory().getName()).setHeader("Category");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        grid.setItems(itemtypeController.getAllItemtypes());
    }



}

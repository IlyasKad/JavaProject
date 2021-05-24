package com.travelset.laba3.views;

import com.travelset.laba3.controllers.CategoryController;
import com.travelset.laba3.model.entity.Category;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route(value = "categories", layout = MainView.class)
@PageTitle("Categories")
public class CategoriesView extends Div {

    Grid<Category> grid = new Grid<>(Category.class);
    CategoryController categoryController;
    CategoryForm form;

    public CategoriesView(CategoryController categoryController) {
        this.categoryController = categoryController;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        form = new CategoryForm();
        form.addListener(CategoryForm.SaveEvent.class, this::saveCategory);
        form.addListener(CategoryForm.DeleteEvent.class, this::deleteContact);
        form.addListener(CategoryForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, form);
        content.addClassName("content");
        content.setSizeFull();
        add(getToolBar(), content);
        updateList();
        closeEditor();
    }

    private void deleteContact(CategoryForm.DeleteEvent evt) {
        categoryController.deleteCategory(evt.getCategory().getId());
        updateList();
        closeEditor();
    }

    private void saveCategory(CategoryForm.SaveEvent evt) {
        categoryController.saveCategory(evt.getCategory());
        updateList();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        Button addContactButton = new Button("Add contact", click -> addCategory());
        HorizontalLayout toolbar = new HorizontalLayout(addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addCategory() {
        grid.asSingleSelect().clear();
        editCategory(new Category());
    }

    private void editCategory(Category category) {
        if (category == null) {
            closeEditor();
        } else {
            form.setContact(category);
            form.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        form.setContact(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void configureGrid() {
        grid.addClassName("entity-grid");
        grid.setSizeFull();
        grid.setColumns("name");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt -> editCategory(evt.getValue()));
    }

    private void updateList() {
        grid.setItems(categoryController.getAllCategories());
    }


}

package com.example.application;

import java.util.List;
import java.util.stream.Stream;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.react.ReactAdapterComponent;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@Menu
@Route
@Tag("my-view")
@JsModule("./MyView.tsx")
public class MyView extends ReactAdapterComponent {

    private boolean filterEnabled = true;

    private final Grid<String> grid = new Grid<>();

    public MyView() {
        grid.addColumn(x -> x).setHeader("Value");
        getContentElement("grid").appendChild(grid.getElement());
        getElement().addEventListener("toggle", data -> setFilter(!filterEnabled));
        setFilter(false);
    }

    private void setFilter(boolean enabled) {
        filterEnabled = enabled;

        List<String> items = Stream.of("One", "Two", "Three").filter(x -> !(filterEnabled && "Two".equals(x))).toList();

        setState("count", items.size());
        grid.setItems(items);
    }
}

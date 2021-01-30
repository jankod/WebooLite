package hr.ja.weboo.ui.table;

import hr.ja.weboo.Widget;
import j2html.TagCreator;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static j2html.TagCreator.*;

@Slf4j
@Getter
@Setter
public class Table<T> extends Widget {

    private List<TableColumn<T>> columns = new ArrayList<>();


    private DataProvider<T> dataProvider;

    private String caption;

    public Table() {
    }

    public void setDataProvider(Collection<T> data) {
    }


    @Override
    public String toHtml() {
        return table(

                TagCreator.caption(caption),

                thead(
                        tr(
                                each(columns, column -> th(column.header().label())))
                ),
                tbody(
                        each(dataProvider()
                                        .getData(0, 10), d -> tr(
                                each(columns, c -> td(rawHtml(
                                        render(c, d))
                                ))
                                )
                        )
                )).withClass("table").renderFormatted();
    }


    private String render(TableColumn<T> c, T data) {

        Object result = c.renderer().render(data);
        if (result instanceof Widget) {
            return ((Widget) result).toHtml();
        }
        return notNull(result);
    }

    private String notNull(Object apply) {
        if (apply == null) {
            return "";
        }
        return apply.toString();
    }


//    public Object renderCell(TableColumn<T> column, T data) {
//        try {
//            return column.getRenderer().render(data);
//        } catch (Exception e) {
//            log.error("", e);
//            return "??? ex " + e.getMessage();
//        }
//    }

//    public TableColumn<T> createColumn(ValueProvider<T, ?> valueProvider) {
//        TableColumn tableColumn = new TableColumn(valueProvider);
//        this.columns.add(tableColumn);
//        return tableColumn;
//    }

//    public TableColumn<T> createColumn(ColumnRenderer<T> renderer) {
//        TableColumn<T> column = new TableColumn<>();
//        columns.add(column);
//        column.setRenderer(renderer);
//        return column;
//    }

    public Table<T> addColumn(TableColumn<T> column) {
        this.columns.add(column);
        return this;
    }

    public TableColumn<T> column(String label) {
        TableColumn<T> column = new TableColumn<>();
        column.header(label);
        this.columns.add(column);
        return column;
    }
}

package hr.ja.weboo.ui.table;

import hr.ja.weboo.HtmlWidget;
import j2html.TagCreator;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static j2html.TagCreator.*;

@Slf4j
@Getter()
@Setter
@Accessors(fluent = true, chain = true)
public class Table<T> implements HtmlWidget {

    private List<TableColumn<T>> columns = new ArrayList<>();


    private DataProvider<T> dataProvider;

    private String caption;

    public Table() {
    }

    public void setData(Collection<T> data) {
        this.dataProvider = new CollectionDataProvider<>(data);
    }


    @Override
    public String toHtml() {
        return table(
                TagCreator.caption(caption),

                thead(
                        tr(
                                each(columns, column -> th(column.getHeader().getLabel())))
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
        Object result = c.getRenderer().render(data);
        if (result instanceof HtmlWidget) {
            return ((HtmlWidget) result).toHtml();
        }
        return notNull(result);
    }

    private String notNull(Object apply) {
        if (apply == null) {
            return "";
        }
        return apply.toString();
    }

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

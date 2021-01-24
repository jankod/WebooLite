package hr.ja.weboo.ui.table;

import lombok.Data;

@Data
public class TableColumn<T> {

    private TableHeader header = new TableHeader("???");

    private ColumnRenderer<T> renderer;

    public TableColumn<T> header(String label) {
        header = new TableHeader(label);
        return this;
    }

}

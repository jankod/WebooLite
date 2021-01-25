package hr.ja.weboo.ui;

import hr.ja.weboo.Widget;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GridLayout extends Widget {


    private String containerType = "container";

    private List<Row> rows = new ArrayList<>();

    public GridLayout() {
    }

    @Override
    public String toHtml() {
        return "";
    }

    public Row addRow() {
        Row row = new Row();
        rows.add(row);
        return row;
    }

    public Row row() {
        return addRow();
    }


    @Data
    public static class Row {
        private List<Col> columns = new ArrayList<>();

        public void addCol(Widget... widgets) {
            Col col = new Col();
            columns.add(col);
            for (Widget widget : widgets) {
                col.widgets().add(widget);
            }
        }

        public String classes() {
            return "row";
        }

        public Row cols(Object... widgets) {
            return this;
        }

        public Col getCol(int colIndex) {
            return columns.get(colIndex);
        }
    }

    @Data
    public static class Col extends CssHasSize {


        private List<Widget> widgets = new ArrayList<>();

        public String classes() {
            return "col";
        }

        public Col style(Css.Size size) {
            this.size(size);
            return this;
        }
    }


}

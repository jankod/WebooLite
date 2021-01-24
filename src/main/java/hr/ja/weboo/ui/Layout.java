package hr.ja.weboo.ui;

import hr.ja.weboo.Widget;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Layout extends Widget {

    private String containerType = "container";

    private List<Row> rows = new ArrayList<>();

    public Layout() {
    }

    @Override
    public String toHtml() {
        return "";
    }

    public Row newRow() {
        return new Row();
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
    }

    @Data
    public static class Col {

        private List<Widget> widgets = new ArrayList<>();
    }

    public static void main(String[] args) {

        String grid = """
                <div class="row">
                    <div class="col">
                      1 of 2
                    </div>
                    <div class="col">
                      2 of 2
                    </div>
                  </div>
                """;

    }
}

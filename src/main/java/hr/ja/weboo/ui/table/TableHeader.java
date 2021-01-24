package hr.ja.weboo.ui.table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableHeader  {
    private String label;

    public TableHeader(String label) {
        this.label = label;
    }
}

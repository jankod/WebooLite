package hr.ja.weboo.ui;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Page implements JteWidget {

    private String title;

    private List<Widget> widgets = new ArrayList<>();

    public Page add(Widget... widgets) {
        for (Widget widget : widgets) {
            this.widgets.add(widget);
        }
        return this;
    }
}

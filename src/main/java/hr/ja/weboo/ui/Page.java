package hr.ja.weboo.ui;

import hr.ja.weboo.Widget;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Page {

    private String title;

    private List<Widget> widgetList = new ArrayList<>();

    public Page add(Widget... widgets) {
        for (Widget widget : widgets) {
            widgetList.add(widget);
        }
        return this;
    }

   // public abstract void doGet();

    public String toHtml() {
        String h = "";
        for (Widget widget : widgetList) {
            h += widget.toHtml() + "\n";
        }
        return h;
    }
}

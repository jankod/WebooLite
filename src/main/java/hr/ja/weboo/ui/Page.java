package hr.ja.weboo.ui;

import gg.jte.Content;
import gg.jte.TemplateOutput;
import hr.ja.weboo.Weboo;
import hr.ja.weboo.Widget;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Page implements Content {

    private String title;

    private List<Widget> widgets = new ArrayList<>();


    @Override
    public void writeTo(TemplateOutput output) {
        String value = toHtml();
        if (value == null) {
            value = toString();
        }
        output.writeUserContent(value);
    }

    public Page add(Widget... widgets) {
        for (Widget widget : widgets) {
            this.widgets.add(widget);
        }
        return this;
    }

   // public abstract void doGet();

    public String toHtml() {
        if(widgets.isEmpty()) {
            return null;
        }
        String h = "";
        for (Widget widget : widgets) {
            h += widget.toHtml() + "\n";
        }
        return h;
    }

    public String toString() {
        String html = toHtml();
        if (html == null) {
            return Weboo.jteParseThis(this);
        }
        return html;
    }
}

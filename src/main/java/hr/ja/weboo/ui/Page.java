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
        String html = Weboo.jteParseThis(this);
        output.writeUserContent(html);
    }

    public Page add(Widget... widgets) {
        for (Widget widget : widgets) {
            this.widgets.add(widget);
        }
        return this;
    }
}

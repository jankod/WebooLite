package hr.ja.weboo.ui;

import gg.jte.Content;
import gg.jte.TemplateOutput;
import hr.ja.weboo.Weboo;

public interface JteWidget extends Widget, Content {

    @Override
    default void writeTo(TemplateOutput output) {
        Weboo.writeWidget(this, output);
    }

}

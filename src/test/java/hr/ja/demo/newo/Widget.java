package hr.ja.demo.newo;

import gg.jte.Content;
import gg.jte.TemplateOutput;

public interface Widget extends Content {

    @Override
    default void writeTo(TemplateOutput output) {
        TestNew.writeWidget(this, output);
    }
}

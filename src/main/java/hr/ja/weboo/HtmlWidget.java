package hr.ja.weboo;

import gg.jte.Content;
import gg.jte.TemplateOutput;
import hr.ja.weboo.ui.Widget;
import lombok.SneakyThrows;

public interface HtmlWidget extends Widget, Content {

    @SneakyThrows
    default void writeTo(TemplateOutput output) {
        output.getWriter().write(toHtml());
    }

    String toHtml();

}

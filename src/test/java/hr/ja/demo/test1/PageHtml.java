package hr.ja.demo.test1;

import gg.jte.TemplateOutput;
import hr.ja.weboo.ui.Label;
import hr.ja.weboo.ui.Page;
import hr.ja.weboo.ui.Route;
import lombok.SneakyThrows;

@Route("/ph")
public class PageHtml extends Page {

   public PageHtml() {
        add(new Label("Ovo ja page html"));
    }

    @SneakyThrows
    @Override
    public void writeTo(TemplateOutput output) {
        output.getWriter().write("Page HTML je ovo");
    }
}

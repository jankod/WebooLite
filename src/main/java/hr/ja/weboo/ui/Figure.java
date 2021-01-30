package hr.ja.weboo.ui;

import hr.ja.weboo.Template;
import lombok.Getter;
import lombok.Setter;
import org.intellij.lang.annotations.Language;

@Getter
@Setter
@Template(Figure.figure)
public class Figure extends WidgetLight {

    private String src = "";


    @Language("InjectedFreeMarker")
    final static String figure = """
            <figure class="figure">
              <img src="${src}" class="figure-img img-fluid rounded" alt="...">
              <figcaption class="figure-caption text-end">A caption for the above image.</figcaption>
            </figure>
            """;


    public static void main(String[] args) {

        Figure f = new Figure();
        System.out.println(f.toString());
    }
}

class WidgetLight {
    public String toString() {
        return getClass().getName();

    }
}

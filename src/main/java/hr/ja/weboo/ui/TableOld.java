package hr.ja.weboo.ui;

import hr.ja.weboo.Widget;
import j2html.tags.ContainerTag;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

@Data
public class TableOld<T> extends Widget {

    private List<T> data = new ArrayList<>(2);



    public String toString() {
        ContainerTag table = table(
                thead(
                        th("Naslov je"), th("Naslov 2")
                ),
                tbody(
                        each(data, i -> tr(
                                td(i.toString()), td("data 2 <b>")
                        ))
                )
        );
        //return table.renderFormatted();
        String name = "name";
        return
                div(
                        p(name),
                        div(
                                ul(each(data, l ->
                                        li(l.toString()))
                                )).withClasses("pero", "pero"),
                        script(rawHtml("""
                                var index = "none";
                                for (var x in index) {
                                    console.log(x);                                
                                }
                                function pero() {
                                    return index;
                                }
                                """))
                ).renderFormatted();
    }

    public static void main(String[] args) {
        TableOld<String> table = new TableOld<>();
        table.data(List.of("jedan", "dva", "tri"));
        System.out.println(table);
    }

    @Override
    public String toHtml() {
        return null;
    }
}

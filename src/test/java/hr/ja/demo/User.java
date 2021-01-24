package hr.ja.demo;

import lombok.Data;
import org.intellij.lang.annotations.Language;

@Data
public class User {

    private Long id;
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String radiNesto() {
        System.out.println("radim nesto 222");
        return "";
    }

    public String opet() {
        System.out.println("opet");
        @Language("HTML")
        String html = """
                <b>Ovo dela da li je to sada tako 2</p>
                """;
        return html;
    }
}

package hr.ja.demo.testing;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import hr.ja.demo.User;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.plugin.rendering.template.JavalinJte;

import java.nio.file.Path;
import java.util.Collections;

public class JavaLinJte {

    public static void main(String[] args) {
        JavalinJte.configure(createTemplateEngine());
        Javalin app = Javalin.create().start(7000);
        app.get("/", JavaLinJte::renderJtePage);
    }

    private static void renderJtePage(Context context) {
        User u = new User("pero");
        context.render("src/test/java/hr/ja/demo/demo.jte", Collections.singletonMap("user", u));
    }

    private static TemplateEngine createTemplateEngine() {
        boolean isDevSystem = true;
        if (isDevSystem) {
            DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
            return TemplateEngine.create(codeResolver, ContentType.Html);
        } else {
            return TemplateEngine.createPrecompiled(Path.of("jte-classes"), ContentType.Html);
        }
    }
}

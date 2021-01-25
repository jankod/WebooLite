package hr.ja.demo.testing;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.plugin.rendering.template.JavalinJte;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Collections;

@Slf4j
public class JavaLinJteDemo1 {

    public static void main(String[] args) {
        JavalinJte.configure(createTemplateEngine());
        Javalin app = Javalin.create().start(7000);
        app.get("/", JavaLinJteDemo1::renderJtePage);
    }

    private static void renderJtePage(Context context) {
        HomePage page = new HomePage();
        String name = page.getClass().getName();
        log.debug("class name {}", name);

        context.render("HomePage.jte", Collections.singletonMap("page", page));
    }

    private static TemplateEngine createTemplateEngine() {
        boolean isDevSystem = true;
        if (isDevSystem) {

            String name1 = HomePage.class.getSimpleName() + ".jte";
            //  DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src",  "test", "resources"));
            ResourceCodeResolver codeResolver = new ResourceCodeResolver("") {
                @SneakyThrows
                @Override
                public String resolve(String name) {

                    URL resourceAsStream
                            = HomePage.class.getResource(name1);
                    if (resourceAsStream == null) {
                        throw new IllegalArgumentException("Not find " + name1);
                    }
                    return IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
                }
            };

            return TemplateEngine.create(codeResolver, ContentType.Html);
        } else {
            return TemplateEngine.createPrecompiled(Path.of("jte-classes"), ContentType.Html);
        }
    }

    private static void printInputStream(InputStream is) {
        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

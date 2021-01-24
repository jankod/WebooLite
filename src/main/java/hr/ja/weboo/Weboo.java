package hr.ja.weboo;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;
import hr.ja.weboo.ui.Page;
import hr.ja.weboo.ui.Route;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.template.JavalinJte;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Slf4j
public class Weboo {


    private int port;
    private boolean debug = true;
    private Javalin app;
    private List<Class<? extends Page>> pages = new ArrayList<>();

    public Weboo(Class<? extends Page>... pagesArray) {
        pages.addAll(Arrays.asList(pagesArray));
        JavalinJte.configure(createTemplateEngine());


    }

    private TemplateEngine createTemplateEngine() {
        if (debug) {
            DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
            return TemplateEngine.create(codeResolver, ContentType.Html);
        } else {
            return TemplateEngine.createPrecompiled(Path.of("jte-classes"), ContentType.Html);
        }

    }

    public void start() {
        start(80);
    }

    public void start(int port) {
        this.port = port;

        app = Javalin.create(conf->
        {
            conf.addStaticFiles("/public");
        }).start(port);
        log.info("http://localhost:"+port);

        for (Class<? extends Page> page : pages) {
            Route route = page.getAnnotation(Route.class);
            log.debug("Route {} page {}", route.value(), page.getSimpleName());
            app.get(route.value(), new Handler() {
                @Override
                public void handle(@NotNull Context ctx) throws Exception {
                    Page pageInstance = page.getConstructor().newInstance();
                    pageInstance.doGet();
                    ctx.render("layout.jte", Collections.singletonMap("page", pageInstance));
                }
            });
        }
    }

    public void addPage(Class<? extends Page> page) {
        pages.add(page);

    }
}

package hr.ja.weboo;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.html.HtmlTemplateOutput;
import gg.jte.output.StringOutput;
import hr.ja.weboo.ui.Page;
import hr.ja.weboo.ui.Route;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.rendering.template.JavalinJte;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
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


    private static Weboo instance;
    TemplateEngine templateEngine = createTemplateEngine();
    MyJteCodeResolver codeResolver = new MyJteCodeResolver();

    public Weboo(Class<? extends Page>... pagesArray) {

        pages.addAll(Arrays.asList(pagesArray));
        JavalinJte.configure(templateEngine);
        instance = this;
    }

    public static Weboo getInstance() {
        HtmlTemplateOutput o;
        return instance;
    }

    @SneakyThrows
    public static String jteParseThis(Page page) {
        String name = page.getClass().getSimpleName() + ".jte";
        log.debug("Load name: {}", name);
        URL resource = page.getClass().getResource(name);
        if(resource == null) {
            String msg = "Not find resource " + name;
            log.warn(msg);
            return msg;
        }
        StringOutput output = new StringOutput();
        instance.templateEngine.render(resource.toURI().getPath(), page, output);
        return output.toString();
    }

    private TemplateEngine createTemplateEngine() {
        if (debug) {
            return TemplateEngine.create(codeResolver, ContentType.Html);
            //DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "jte"));
            //return TemplateEngine.create(codeResolver, ContentType.Html);
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
        log.info("Start web http://localhost:"+port);

        for (Class<? extends Page> page : pages) {
            Route route = page.getAnnotation(Route.class);
            log.debug("Route {} page {}", route.value(), page.getSimpleName());
            app.get(route.value(), new Handler() {
                @Override
                public void handle(@NotNull Context ctx) throws Exception {
                    Request.addContext(ctx);
                    Page pageInstance = page.getConstructor().newInstance();
                    ctx.render("layout.jte", Collections.singletonMap("page", pageInstance));
                }
            });
        }
    }

    public void addPage(Class<? extends Page> page) {
        pages.add(page);

    }
}

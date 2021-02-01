package hr.ja.weboo;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import hr.ja.weboo.ui.*;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;


@Slf4j
public class Weboo {


    private Javalin app;

    private static Weboo instance;

    private WebooConfig config;

    private TemplateEngine templateEngine;
    private JteCodeResolverFromClass codeResolver = new JteCodeResolverFromClass();

    private Weboo(WebooConfig config) {
        this.config = config;
        templateEngine = createTemplateEngine();
    }

    public static Weboo start(WebooConfig config) {
        if (instance != null) {
            throw new IllegalStateException("Start is called twice!");
        }

        instance = new Weboo(config);
        instance.start();

        return instance;
    }

    private TemplateEngine createTemplateEngine() {
        if (config.isDebug()) {
            return TemplateEngine.create(codeResolver, ContentType.Html);
        } else {
            return TemplateEngine.createPrecompiled(Path.of("jte-classes"), ContentType.Html);
        }

    }


    private void start() {

        app = Javalin.create(conf ->
        {
            conf.addStaticFiles("/public");

        }).start(config.getPort());
        log.info("Start web http://localhost:" + config.getPort());

        for (Class<? extends Page> page : config.getPages()) {
            Route route = page.getAnnotation(Route.class);
            log.debug("Route {} page {}", route.value(), page.getSimpleName());

            app.get(route.value(), new Handler() {
                @Override
                public void handle(@NotNull Context ctx) throws Exception {
                    Request.addContext(ctx);
                    Constructor<? extends Page> constructor = page.getConstructor();
                    constructor.setAccessible(true);
                    Page pageInstance = constructor.newInstance();

                    Constructor<? extends Layout> constructorLayout = config.getLayout().getConstructor(Page.class);
                    Layout layout = constructorLayout.newInstance(pageInstance);
                    log.debug("layout class  {}", layout.getClass());
                    if (layout instanceof JteWidget) {
                        String html = renderJte((JteWidget) layout);
                        ctx.html(html);
                    }else {
                        // html layout
                        ctx.html(layout.toString());
                    }
                    //ctx.render("layout.jte", Collections.singletonMap("page", pageInstance));
                }
            });
        }
    }

    private String renderJte(JteWidget widget) {
        Class<? extends JteWidget> clazz = widget.getClass();
        String name = getWidgetName(clazz);
        String template = getJteTemplate(clazz);
        instance.codeResolver.addTemplate(name, template);
        StringOutput output1 = new StringOutput();

        instance.templateEngine.render(name, widget, output1);
        String html = output1.toString();
      //  log.debug("name {} html '{}'", name, html);
        return html;
    }


    @SneakyThrows
    private String getJteTemplate(Class<?> clazz) {
        String name = getWidgetName(clazz);
        InputStream resourceAsStream = clazz.getResourceAsStream(name);
        if (resourceAsStream == null) {
            throw new RuntimeException("Not find template " + name);
        }
        return IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
    }

    private String getWidgetName(Class<?> clazz) {
        String name = clazz.getSimpleName() + ".jte";
        return name;
    }

    @SneakyThrows
    public static void writeWidget(JteWidget content, TemplateOutput output) {
        String html = instance.renderJte(content);
        output.getWriter().write(html);


    }
}

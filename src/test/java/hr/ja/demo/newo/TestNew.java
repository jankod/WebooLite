package hr.ja.demo.newo;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import hr.ja.weboo.JteCodeResolverFromClass;
import hr.ja.weboo.ui.Widget;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
public class TestNew {

    static TemplateEngine engine;
    static JteCodeResolverFromClass codeResolver = new JteCodeResolverFromClass();

    public static void main(String[] args) {


        MyPage myPage = new MyPage();
        String name = MyPage.class.getName();
        String template = getTemplate(MyPage.class);

        codeResolver.addTemplate(name, template);
        engine = TemplateEngine.create(codeResolver, ContentType.Html);

        StringOutput w = new StringOutput();
        engine.render(name, myPage, w);

        System.out.println(w.toString());

    }

    @SneakyThrows
    private static String getTemplate(Class<?> clazz) {
        String name = clazz.getSimpleName() + ".jte";
        InputStream resourceAsStream = clazz.getResourceAsStream(name);
        if (resourceAsStream == null) {
            throw new RuntimeException("Not find template " + name);
        }
        return IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
    }

    @SneakyThrows
    public static void writeWidget(Widget content, TemplateOutput output) {
        String template = getTemplate(content.getClass());
        String name = content.getClass().getName();
        codeResolver.addTemplate(name, template);
        StringOutput output1 = new StringOutput();
        engine.render(name, content, output1);
        String value = output1.toString();
        output.getWriter().write(value);
        //output.writeUserContent(value);


        log.debug("name {} html '{}'", name , value);
    }
}



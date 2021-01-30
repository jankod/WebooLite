package hr.ja.weboo;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.io.StringWriter;

public class FreeMarker {
    String parse(String template) throws IOException, TemplateException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_30);
        Template t = Template.getPlainTextTemplate("pero", "pero ${d}", config);
        StringWriter out = new StringWriter();
        t.process("marko", out);
        System.out.println(out);

        return "html";
    }


    public static void main(String[] args) throws IOException, TemplateException {

    }
}

@Data
@AllArgsConstructor
class Model {
    private String name = "marko";
}

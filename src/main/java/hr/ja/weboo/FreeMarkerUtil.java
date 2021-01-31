package hr.ja.weboo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

public class FreeMarkerUtil {
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


package hr.ja.demo;

import freemarker.cache.ConditionalTemplateConfigurationFactory;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateSourceMatcher;
import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

public class TestFreeMarker {


    public static void main(String[] args) throws IOException, TemplateException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_30);
        config.setOutputFormat(HTMLOutputFormat.INSTANCE);
        StringTemplateLoader loader = new StringTemplateLoader();
        config.setTemplateLoader(loader);
        loader.putTemplate("pero", "Ime je: ${name}");

        StringWriter out = new StringWriter();
        config.getTemplate("pero").process(new User("pero"), out);
        System.out.println(out);

        ConditionalTemplateConfigurationFactory s;

        TemplateSourceMatcher matcher;
    }
}

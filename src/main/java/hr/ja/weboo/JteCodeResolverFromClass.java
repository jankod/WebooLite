package hr.ja.weboo;

import gg.jte.CodeResolver;

import java.util.HashMap;
import java.util.Map;

public class JteCodeResolverFromClass implements CodeResolver {


    private Map<String, String> source = new HashMap<>();

    //private Map<String, Boolean> hasChange = new HashMap<>();


    public void addTemplate(String name, String template) {
        source.put(name, template);
    }

    @Override
    public String resolve(String name) {
        return source.get(name);
    }

    @Override
    public boolean hasChanged(String name) {
        return false;
    }
}

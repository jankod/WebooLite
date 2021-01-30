package hr.ja.weboo;

import gg.jte.CodeResolver;

import java.util.HashMap;
import java.util.Map;

public class MyJteCodeResolver implements CodeResolver {


    private Map<String, String> source = new HashMap<>();

    public void addCode(String name, String code) {
        source.put(name, code);
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

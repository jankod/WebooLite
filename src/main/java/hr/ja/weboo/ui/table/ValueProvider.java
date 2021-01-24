package hr.ja.weboo.ui.table;

@FunctionalInterface
public interface ValueProvider<SOURCE, TARGET> {
    TARGET apply(SOURCE var1);
}
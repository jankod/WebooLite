package hr.ja.weboo.ui.table;

public interface ColumnRenderer<T> {

    Object render(T data) ;
}

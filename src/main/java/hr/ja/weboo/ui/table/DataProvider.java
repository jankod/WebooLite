package hr.ja.weboo.ui.table;

import java.util.List;

public interface DataProvider<T> {

    List<T> getData(int num, int size);

}

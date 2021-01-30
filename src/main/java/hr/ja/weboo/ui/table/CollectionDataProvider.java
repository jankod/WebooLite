package hr.ja.weboo.ui.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionDataProvider<T> implements DataProvider<T> {

    private ArrayList<T> data;

    public CollectionDataProvider(Collection<T> data) {
        this.data = new ArrayList<>(data);
    }

    @Override
    public List<T> getData(int num, int size) {
        return data.subList(num, num + size);
    }
}

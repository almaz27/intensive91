import java.util.Collection;
import java.util.Comparator;

public interface CustomList<E> {
    boolean add(int index, E element);
    boolean addAll(Collection<? extends E> c);
    boolean addAll(int index, Collection c);
    void clear();
    E get(int index);
    boolean isEmpty();
    boolean remove(int index);
    Object remove(Object o);
//    void sort(Comparator<? extends E> c);





}

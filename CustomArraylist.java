import java.util.*;

public  class CustomArraylist implements CustomList {
    public Object[] items;
    public int next = 0;
    public int length;

    public CustomArraylist(int capacity) {
        items = new Object[capacity];
        length = capacity;
    }


    @Override
    public boolean add(int index, Object element) {
        if (index > length) return false;
        items[index] = element;
        return true;

    }

    @Override
    public boolean addAll(Collection c) {
        if(c.size() <= length){
            Iterator iterator = c.iterator();
            int pointer = 0;
            while (iterator.hasNext()){
                items[pointer] = iterator.next();
                pointer++;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        int collectionLength = c.size();
        if(index < length && (length - index) >= collectionLength){
            Iterator cIterator = c.iterator();
            while (cIterator.hasNext()){
                items[index] = cIterator.next();
                index++;
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            items[i] = null;
        }

    }

    @Override
    public Object get(int index) {
        return items[index];
    }

    @Override
    public boolean isEmpty() {
        int countNulls =0 ;
        for (int i = 0; i < length; i++) {
            if (items[i] == null){
                countNulls++;
            }
        }
        return countNulls == length;
    }

    @Override
    public boolean remove(int index) {
        if (lengthIsLess(index)) return false;
        items[index] = null;
        return true;
    }

    @Override
    public Object remove(Object o) {
        for (int i = 0; i < length; i++) {
            if (items[i].equals(o)){
                Object wanted = items[i];
                items[i] = null;
                return wanted;
            }
        }
        return null;
    }




    class sortByFirstLetter implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            String a = (String) o1;
            String b = (String) o2;
            if(a.charAt(0) > b.charAt(0)) return -1;
            if(a.charAt(0) < b.charAt(0)) return 1;
            return 0;
        }
    }
    private boolean lengthIsLess(int capacity){
        return capacity > length;
    }
    public static void main(String[] args) {
        CustomArraylist customArraylist = new CustomArraylist(5);
        customArraylist.add(0,"Almaz");
        customArraylist.addAll(List.of(new String[]{"Murat", "Marat","Morat","Firat","Polat"}));
        customArraylist.addAll(2, List.of(new String[]{"Melisa","Maria"}));

        for (int i = 0; i < customArraylist.items.length; i++) {
            System.out.println(customArraylist.items[i]);
        }
        System.out.println("*-------------------------");
//        customArraylist.clear();
        customArraylist.remove("Marat");
        for (int i = 0; i < customArraylist.items.length; i++) {
            System.out.println(customArraylist.items[i]);
        }
        System.out.println("*-------------------------");
        for (int i = 0; i < customArraylist.items.length; i++) {
            System.out.println(customArraylist.items[i]);
        }
    }
}

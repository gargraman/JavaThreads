package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class DoIterate
{
    static Map<String, String> m = new HashMap<>();

    static List<String> list = new LinkedList<>();

    static {
        list.add("abc");
        list.add("def");
        list.add("ghi");
        m.put("a", "abc");
        m.put("d", "def");
        m.put("g", "ghi");
        m.put("b", "bcd");
    }

    public static void main(String[] args)
    {
        DoIterate it = new DoIterate();
        it.iterateMap();
        it.iterateMapJava8();
        it.iterateList();
        it.iterateListJava8();
        it.sortMap();
    }

    private void iterateListJava8()
    {
        list.stream().filter(s -> s.equalsIgnoreCase("a")).forEach(s -> System.out.println(":" + s));
        list.forEach(item -> System.out.println(item));

        // Example of Aggregator average()
     /*   double average = roster.stream().filter(p -> p.getGender() == Person.Sex.MALE).mapToInt(Person::getAge)
            .average().getAsDouble();

        List<String> namesOfMaleMembersCollect = roster.stream().filter(p -> p.getGender() == Person.Sex.MALE)
            .map(p -> p.getName()).collect(Collectors.toList()); // nested for loops Albums with each having multiple
                                                                 // tracks
        List<Album> sortedFavs = albums.stream().filter(a -> a.tracks.anyMatch(t -> (t.rating >= 4)))
            .sorted(Comparator.comparing(a -> a.name)).collect(Collectors.toList());
*/
    }

    private void iterateList()
    {
        for (String s : list) {
            System.out.println(":" + s);
        }

        ListIterator<String> it = list.listIterator();
        boolean flag = true;
        while (it.hasNext()) {
            System.out.println("--" + it.next());
            if (flag) {
                it.add("added");
                flag = false;
            }
        }

        /*
         * Collections.sort(list, new Comparator<Album>() { public int compare(Album a1, Album a2) { return
         * a1.name.compareTo(a2.name); }});
         */
    }

    private void iterateMapJava8()
    {
        m.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));
    }

    private void iterateMap()
    {
        m.clear
        Set<Entry<String, String>> entries = m.entrySet();
        for (Entry<String, String> e : entries) {
            System.out.println("Key:" + e.getKey() + ": value=" + e.getValue());
        }
    }

    private void sortMap()
    {

        Map<String, String> sortedMap = m.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
            .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("After sorting");
        sortedMap.forEach((key, value) -> System.out.println(key + " value: " + value));

    }

}

package collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    }

    public static void main(String[] args)
    {
        DoIterate it = new DoIterate();
        it.iterateMap();
        it.iterateMapJava8();
        it.iterateList();
        it.iterateListJava8();
    }

    private void iterateListJava8()
    {
        list
        .stream()
        .filter(s -> s.equalsIgnoreCase("a"))
        .forEach(s -> System.out.println(":"+s));
        
        /*//Example of Aggregator average()
         double average = roster
            .stream()
            .filter(p -> p.getGender() == Person.Sex.MALE)
            .mapToInt(Person::getAge)
            .average()
            .getAsDouble();
         */
        /*
        List<String> namesOfMaleMembersCollect = roster
            .stream()
            .filter(p -> p.getGender() == Person.Sex.MALE)
            .map(p -> p.getName())
            .collect(Collectors.toList());
        
        //nested for loops Albums with each having multiple tracks    
        List<Album> sortedFavs =
          albums.stream()
                .filter(a -> a.tracks.anyMatch(t -> (t.rating >= 4)))
                .sorted(Comparator.comparing(a -> a.name))
                .collect(Collectors.toList());
    
        */
        
    }

    private void iterateList()
    {
        for(String s : list) {
            System.out.println(":"+ s);
        }
        
        /*
         Collections.sort(list, new Comparator<Album>() {
                           public int compare(Album a1, Album a2) {
                               return a1.name.compareTo(a2.name);
                           }});
         */
    }

    private void iterateMapJava8()
    {
        // TODO Auto-generated method stub
        
    }

    private void iterateMap()
    {
        
        
    }

}

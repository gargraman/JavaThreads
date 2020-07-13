package collections;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Function;

public class Ship {
    private Map<Long, Long> containers;

    public Ship(int containerCount, Function<Long, Long> fillContainer) {
        this.containers = new Hashtable<Long, Long>();

        for (long i = 0; i < containerCount; i++) {
            this.containers.put(i, fillContainer.apply(i));
        }
    }

    public long peekContainer(long containerIndex) {
        return this.containers.get(containerIndex);
    }
    
    public static void main(String[] args) {
        Ship ship = new Ship(100, containerIndex -> containerIndex);

        for (int i = 0; i < 10; i++) {
            System.out.println("Container: " + i + ", cargo: " + ship.peekContainer(i));
        }
    }
}
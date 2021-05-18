import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/9/3 10:57
 */
public class Herb {

    public enum Type {ANNUAL, PERENNIAL, BIENNTAL}

    private final String name;
    private final Type type;

    public Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Set<Herb> garden = new HashSet<>();
        garden.add(new Herb("herb1", Herb.Type.ANNUAL));
        garden.add(new Herb("herb2", Herb.Type.PERENNIAL));
        garden.add(new Herb("herb3", Herb.Type.ANNUAL));
        garden.add(new Herb("herb4", Herb.Type.BIENNTAL));
        garden.add(new Herb("herb5", Herb.Type.BIENNTAL));
        garden.add(new Herb("herb6", Herb.Type.ANNUAL));
        Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<>(Herb.Type.class);

        for (Herb.Type t : Herb.Type.values()) {
            herbsByType.put(t, new HashSet<>());
        }

        for (Herb h : garden) {
            herbsByType.get(h.type).add(h);
        }

        System.out.println(herbsByType);

    }
}

import java.util.*;
import java.util.stream.Collectors;

interface MenuItem {
    String getName();
    double getPrice(Size size);
}

enum Size {
    SMALL, LARGE
}

abstract class AbstractMenuItem implements MenuItem {
    private final String name;
    private final double basePrice;

    public AbstractMenuItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double getPrice(Size size) {
        return size == Size.SMALL ? basePrice : basePrice * 1.5;
    }
}

class MainCourse extends AbstractMenuItem {
    public MainCourse(String name, double basePrice) {
        super(name, basePrice);
    }
}

class Dessert extends AbstractMenuItem {
    public Dessert(String name, double basePrice) {
        super(name, basePrice);
    }
}

class Soup extends AbstractMenuItem {
    public Soup(String name, double basePrice) {
        super(name, basePrice);
    }
}
class Menu<T extends MenuItem> {
    private final Map<String, T>
            itemsMap = new HashMap<>();

    public void addItem(T newItem) {
        if (!itemsMap.containsKey(newItem.getName())) {
            itemsMap.put(newItem.getName(), newItem);
            System.out.println(newItem.getName() + " added to the menu.");
        } else {
            System.out.println("Item '" + newItem.getName() + "' already exists in the menu.");
        }
    }

    public void pushValue(T newItem) {
        if (!itemsMap.containsKey(newItem.getName())) {
            System.out.println("Adding item: " + newItem.getName());
            itemsMap.put(newItem.getName(), newItem);
        } else {
            System.out.println("Already added: " + newItem.getName());
        }
    }

    public List<T> getItems() {
        return new ArrayList<>(itemsMap.values());
    }

    public List<T> getItemsSortedByPrice(Size size) {
        return itemsMap.values().stream()
                .sorted((item1, item2) -> Double.compare(item2.getPrice(size), item1.getPrice(size)))
                .collect(Collectors.toList());
    }

    public Map<Class<? extends MenuItem>, List<T>> groupByCategory() {
        return itemsMap.values().stream()
                .collect(Collectors.groupingBy(item -> (Class<? extends MenuItem>) item.getClass()));
    }
}

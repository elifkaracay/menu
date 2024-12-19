public class MenuManager {
    public static void main(String[] args) {
        Menu<MenuItem> menu = new Menu<>();
        menu.addItem(new MainCourse("Steak", 20.0));
        menu.addItem(new MainCourse("Chicken", 15.0));
        menu.addItem(new Dessert("Ice Cream", 5.0));
        menu.addItem(new Dessert("Cake", 6.0));
        menu.addItem(new Soup("Tomato Soup", 4.0));
        menu.addItem(new Soup("Chicken Soup", 5.0));
        menu.pushValue(new MainCourse("Fish", 18.0));
        menu.pushValue(new Dessert("Brownie", 7.0));

        System.out.println("Menu Items:");
        menu.getItems().forEach(item -> {
            System.out.printf("%s - Small: %.2f, Large: TL%.2f \n",
                    item.getName(),
                    item.getPrice(Size.SMALL),
                    item.getPrice(Size.LARGE));
        });

        System.out.println("\n Menu Items Sorted by Large Size:");
        menu.getItemsSortedByPrice(Size.LARGE).forEach(item -> {
            System.out.printf("%s - Large:  %.2f\n",
                    item.getName(),
                    item.getPrice(Size.LARGE));
        });

        System.out.println("\n Menu Items Grouped by Category:");
        menu.groupByCategory().forEach((category, items) -> {
            System.out.println("Category: " + category.getSimpleName());
            items.forEach(item -> System.out.printf(" - %s: Small: $%.2f, Large: $%.2f \n",
                    item.getName(),
                    item.getPrice(Size.SMALL),
                    item.getPrice(Size.LARGE)));
        });
    }
}
package pl.karpiu.ShoppingList.products;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private final List<String> shoppingList = new ArrayList<>();

    public Categories(){
        shoppingList.add(0, "[Product categories - examples]");
        shoppingList.add(1, "Bakery");
        shoppingList.add(2, "Meat");
        shoppingList.add(3, "Fruit");
        shoppingList.add(4, "Alcohol");
        shoppingList.add(5, "Toiletries");
        shoppingList.add(6, "Pet shop");
        shoppingList.add(7, "Other");
    }

      public void showCategories() {
         for (String categoriesName : shoppingList) {
              System.out.println(categoriesName);
          }
    }
}

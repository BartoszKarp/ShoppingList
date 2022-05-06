package pl.karpiu.ShoppingList.products;

import java.util.ArrayList;

public class Categories {

    private final ArrayList<String> shoppingList = new ArrayList<String>();

    public void addCategories(){
        shoppingList.add(0, "[Product categories - examples]");
        shoppingList.add(1, "Bakery");
        shoppingList.add(2, "Meat");
        shoppingList.add(3, "Fruit");
        shoppingList.add(4, "Alcohol");
        shoppingList.add(5, "Toileteries");
        shoppingList.add(6, "Pet shop");
        shoppingList.add(7, "Other");
    }


    public void showCategories() {


        System.out.println("Choose product categories:");


        for (int i = 0; i < shoppingList.size(); i++) {

            System.out.println(i + ". " + shoppingList.get(i));

        }
    }


}

package pl.karpiu.ShoppingList.input;

import pl.karpiu.ShoppingList.ShoppingListCommands;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static pl.karpiu.ShoppingList.ShoppingListCommands.numberOfTxtFiles;

public class UserInputCommand {

    private ShoppingListCommands shoppingListCommands = new ShoppingListCommands();


    public void addProduct(){
        shoppingListCommands.addProduct();
        System.out.println("Product added.");
    }

    public void removeProduct(){

        if(shoppingListCommands.getGroceryList().isEmpty()){
            System.out.println("List is empty. Add product and try again.");
        } else {
            shoppingListCommands.showGroceryList();
            shoppingListCommands.removeProduct();
            System.out.println("Product removed.");
        }
    }

    public void savingListToFile(){
        shoppingListCommands.listShopListFiles();

        if(shoppingListCommands.getGroceryList().isEmpty()){
            System.out.println("List is empty. Add product and try again.");
        } else {
            shoppingListCommands.savingListToFile();

        }
    }

    public void showGroceryList(){
        if(shoppingListCommands.getGroceryList().isEmpty()){
            System.out.println("List is empty. Add product and try again.");
        } else {
            shoppingListCommands.showGroceryList();
        }
    }

    public void loadListFromFile(){
        shoppingListCommands.listShopListFiles();
        shoppingListCommands.removeAllItemsFromList();
        if(numberOfTxtFiles != 0) {
            shoppingListCommands.loadListFromFile();
            shoppingListCommands.removeFirstLine();
        } else {

        }
    }





}

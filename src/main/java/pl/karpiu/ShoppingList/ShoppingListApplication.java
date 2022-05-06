package pl.karpiu.ShoppingList;

import pl.karpiu.ShoppingList.input.UserInputCommand;
import pl.karpiu.ShoppingList.input.UserInputManager;


public class ShoppingListApplication {


    public static void main(String[] args) {

        new ShoppingListApplication().start();
    }



    private void start() {

        ShoppingListCommands shoppingListCommands = new ShoppingListCommands();

        boolean shouldItWork = true;

        UserInputManager userInputManager = new UserInputManager(); // <- here scanner is ready to use
        UserInputCommand userInputCommand = new UserInputCommand();


        System.out.println("Start App....");




        while (shouldItWork)
        {
            System.out.println("Choose option:");

            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Show all grocery list");
            System.out.println("4. Load exist list");
            System.out.println("5. Save");
            System.out.println("6. Exit");


            switch(userInputManager.nextCommand()){

                case ADD_PRODUCT -> userInputCommand.addProduct();
                case REMOVE_PRODUCT -> userInputCommand.removeProduct();
                case SHOW_ALL -> userInputCommand.showGroceryList();
                case LOAD_LIST -> userInputCommand.loadListFromFile(); //listShopListFiles();
                case SAVE_LIST -> userInputCommand.savingListToFile();
                case EXIT -> shouldItWork = false;
            }
        }
    }
}

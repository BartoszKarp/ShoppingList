package pl.karpiu.ShoppingList.input;

import pl.karpiu.ShoppingList.CommandNames;

import java.util.Scanner;

public class UserInputManager {

    private Scanner scanner;
    private CommandNames commandNames;
    private String value;

    public UserInputManager(){

        scanner = new Scanner(System.in);

    }


    public CommandNames nextCommand() {

        value = scanner.nextLine();
        if (value.equals("1")){
            commandNames = CommandNames.ADD_PRODUCT;
            return commandNames;
        } else if (value.equals("2")){
            commandNames = CommandNames.REMOVE_PRODUCT;
            return commandNames;
        } else if (value.equals("3")){
            commandNames = CommandNames.SHOW_ALL;
            return commandNames;
        }else if (value.equals("4")){
            commandNames = CommandNames.LOAD_LIST;
            return commandNames;
        }else if (value.equals("5")){
            commandNames = CommandNames.SAVE_LIST;
            return commandNames;
        }else if (value.equals("6")){
            commandNames = CommandNames.EXIT;
            return commandNames;
        }

        throw new IllegalArgumentException("Unknown action, please try again: " + value);

    }
}

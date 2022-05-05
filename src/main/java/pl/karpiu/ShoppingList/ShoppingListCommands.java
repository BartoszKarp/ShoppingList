package pl.karpiu.ShoppingList;

import pl.karpiu.ShoppingList.products.Categories;

import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;

public class ShoppingListCommands {

    private String categoryName;
    private String productName;
    private String fileName;
    private Categories categories;
    private String split = " / ";

    private Scanner scanner = new Scanner(System.in);
    private Map<String, String> groceryList = new HashMap<>();

    public void addProduct() {

        categories = new Categories();

        categories.addCategories();
        categories.showCategories();

        categoryName = scanner.nextLine();

        System.out.println("Write product name:");

        productName = scanner.nextLine();
        groceryList.put(categoryName, productName);

    }

    public void removeProduct() {
        System.out.println("Enter product name to remove: ");
        groceryList.values().remove(scanner.nextLine());
    }

    public void showGroceryList() {

            System.out.println("[Category]"+split+"[Product]");
            BiConsumer<String, String> biconsumer = (key, val) ->
                    System.out.println(key + split + val);
            groceryList.forEach(biconsumer);
        }


    public void savingListToFile() {

            BufferedWriter writer = null;

            System.out.println("Write file name to save: ");
            fileName = scanner.nextLine();

            try {
                writer = new BufferedWriter(new FileWriter(fileName + ".txt"));

                writer.write("[Category]" + split + "[Product]\n");

                for (Map.Entry<String, String> entry : groceryList.entrySet()) {
                    writer.write(entry.getKey() + split + entry.getValue());

                    writer.newLine();

                }

                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    writer.close();
                } catch (Exception e) {
                }
                System.out.println("List saved to file named: " + fileName + ".txt");
            }
    }

    public void loadListFromFile(){

        BufferedReader reader = null;

        System.out.println("Write file name to save: ");
        fileName = scanner.nextLine();

        try {
            reader = new BufferedReader(new FileReader(fileName + ".txt"));

            String line = null;

            // read file line by line
            while ((line = reader.readLine()) != null) {

                // split the line by :
                String[] parts = line.split(split);

                // first part is name, second is number
                String categoryName = parts[0].trim();
                String productName = parts[1].trim();

                // put name, number in HashMap if they are
                // not empty
                if (!categoryName.equals("") && !productName.equals(""))
                    groceryList.put(categoryName, productName);
            }
        }
        catch (Exception e) {
            System.out.println("Loading work properly");
        }
        finally {

            // Always close the BufferedReader
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (Exception e) {
                };
            }
        }

    }

    public void removeAllItemsFromList(){
        groceryList.clear();
    }

    public void removeFirstLine(){

        groceryList.remove("[Category]", "[Product]");

    }

    public void listShopListFiles() {

        File directoryPath = new File("C:\\Users\\Magda Tobołkiewicz\\Desktop\\Programowanie\\ShoppingList");
        File allTxtFiles[] = directoryPath.listFiles();

        System.out.println("Exist shopping lists:");

        for(File file : allTxtFiles) {
            if(file.isFile() && file.getName().endsWith(".txt")){
                System.out.println("File name: " + file.getName());
            } else {
                System.out.println("There is no shopping lists.");
            }
        }


    }



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Map<String, String> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(Map<String, String> groceryList) {
        this.groceryList = groceryList;
    }
}

/*
    Small Business Inventory and Reorder Assistant
    Build a tool that looks up an item's quantity and price, calculates its inventory value, and flags
items that need restocking.

• GUI: Item lookup, quantity and price display, reorder status.

• File I/O: Read inventory records and save updated inventory or reorder reports.

    -things we should learn - 
• Programming concepts: Numeric calculations, comparisons, selection, file processing.

    - Extra - 
• Extension: Calculate the cost of replenishing inventory to a specified target quantity.
*/
package SKA;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
/*
import javax.swing.JFrame;
import javax.swing.JButton;
*/ 
public class SKU {
    static boolean isrunning = true;
    static Scanner scan = new Scanner(System.in);
    static ArrayList<String> inventory = new ArrayList<>();
public static void startup() {
        System.out.println("Welcome to the Small Business Inventory and Reorder Assistant");
        System.out.println("Please select an option:");
    }

public static void displayMenu() {
        System.out.println("0: Startup");
        System.out.println("1: Add inventory item");
        System.out.println("2: View inventory items");
        System.out.println("3: Exit");
    }

public static void MS(){
    
    int count = 0;
    while(isrunning){
        //will be removed in GUI version
        do{
        SKU.displayMenu();
        }while(count == 5);
            int choice = scan.nextInt();
          
            switch (choice) {
                case 0 -> startup();
                case 1 -> {
                    System.out.println("You selected option 1: Add inventory item");
                    String itemName = scan.next();
                    inventory.add(itemName);
            }
                case 2 -> {
                    System.out.println("You selected option 2: View inventory items");
                    for (String item : inventory) {
                        System.out.println(item);
                    }
            }
                case 3 -> {
                    System.out.println("You selected option 3: Exit");
                    isrunning = false;
            }
                default -> System.out.println("Invalid choice. Please try again.");
            }
                count++;
        }
}
    public static void main(String [] args){
        //IDK stack/heap where jframe stuff is being read?
        SwingUtilities.invokeLater(() -> {
        //basic frame set up
        JFrame frame = new JFrame("SKA Start");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel like frame in Tkinter, widget to place widgets on.
        JPanel topPanel = new JPanel(); 
        frame.add(topPanel, BorderLayout.NORTH);
        // center on screen
        frame.setLocationRelativeTo(null); 

        //Just a label for the first button.
        JLabel op1 = new JLabel("Add inventory item", SwingConstants.CENTER);
        topPanel.add(op1, BorderLayout.NORTH);
        
        //button
        JButton op1$ = new JButton();
        topPanel.add(op1$, BorderLayout.NORTH);
        op1$.addActionListener(event -> {
            String itemName = JOptionPane.showInputDialog(
                    frame, "Enter item name:", "Add inventory item", JOptionPane.QUESTION_MESSAGE);
            if (itemName != null && !itemName.trim().isEmpty()) {
                inventory.add(itemName.trim());
            }
        });
        
        /*regular label               
                                      centered in the middle of the frame
        JLabel label = new JLabel("Hello, Swing!", SwingConstants.CENTER);
        frame.add(label);
       */
        topPanel.setVisible(true);
        /*
        frame.setVisible(true);
        /*String name;
        option windows for small things(could use later)
        name = JOptionPane.showInputDialog("What is your name?");

        JOptionPane.showMessageDialog(null, "Welcome to the Small Business Inventory and Reorder Assistant " + name);
        int ans = JOptionPane.showConfirmDialog(
            null, "Would you like to continue?", "Continue?", JOptionPane.YES_NO_OPTION);
         if (ans == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "You selected Yes.");
        }
            */
        });
                

        //MS();
        
    }
}

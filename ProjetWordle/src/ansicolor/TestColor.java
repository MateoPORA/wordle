/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ansicolor;

/**
 *
 * @author guillaume.laurent
 */
public class TestColor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.print(AnsiColor.BLACK + "Hello world! ");
        System.out.print(AnsiColor.RED + "Hello world! ");
        System.out.print(AnsiColor.GREEN + "Hello world! ");
        System.out.print(AnsiColor.YELLOW + "Hello world! ");
        System.out.print(AnsiColor.BLUE + "Hello world! ");
        System.out.print(AnsiColor.PURPLE + "Hello world! ");
        System.out.print(AnsiColor.CYAN + "Hello world! ");
        System.out.print(AnsiColor.WHITE + "Hello world! ");
        System.out.println(AnsiColor.RESET);
        
        System.out.print(AnsiColor.BLACK_BACKGROUND + "Hello world! ");
        System.out.print(AnsiColor.RED_BACKGROUND + "Hello world! ");
        System.out.print(AnsiColor.GREEN_BACKGROUND + "Hello world! ");
        System.out.print(AnsiColor.YELLOW_BACKGROUND + "Hello world! ");
        System.out.print(AnsiColor.BLUE_BACKGROUND + "Hello world! ");
        System.out.print(AnsiColor.PURPLE_BACKGROUND + "Hello world! ");
        System.out.print(AnsiColor.CYAN_BACKGROUND + "Hello world! ");
        System.out.print(AnsiColor.WHITE_BACKGROUND + "Hello world! ");
        System.out.println(AnsiColor.RESET);

    }

}

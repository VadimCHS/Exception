package Seminar_2;

import java.io.IOException;
import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        boolean flag = true;
        String text = null;

        while (flag) {
            try {
                text = getText("Введите любой текст: ");
                flag = false;
            } catch (IOException e) {
                System.out.println("Введена пустая строка.");
            }
        }

        System.out.println("Введенный текст: " + text);

    }

    public static String getText(String msg) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print(msg);
        String text = scanner.nextLine();

        if (text.equals("")) {
            throw new IOException();        // Ругается на не закрытый scanner. Если закрыть scanner в блоке if, выбрасывает NoSuchElementException
        }
        
        scanner.close();
        return text;
    }
}

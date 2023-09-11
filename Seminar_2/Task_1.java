// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

package Seminar_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        boolean flag = true;
        double test = 0.0;
        while (flag) {
            try {
                test = getFloatConsole("Введите дробное число через \",\": ");
                flag = false;

            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода!!! Попробуйте еще раз.");
            } 
            
        }
        System.out.println("Введеное число: " + test);
    }


    public static double getFloatConsole(String msg) throws InputMismatchException{
        double result = 0;
        Scanner scanner;
        
        scanner = new Scanner(System.in);
        System.out.print(msg);
        result = scanner.nextDouble();
        scanner.close();
        return result;        
    }
}
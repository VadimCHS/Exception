package Seminar_2;
/*
try {
   int d = 0;                                               <- На ноль делить нельзя, меняем 0 на любое число
   double catchedRes1 = intArray[8] / d;                    <- Обьявляем и инициализируем массив intArray и заменя индекс [8] на индекс в пределах массива.
   System.out.println("catchedRes1 = " + catchedRes1);       - Заменим double на int, так как входящие переменные int и результат будет отбрасывать остаток от деления
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}                                                           <- Добавляем обработку ArrayIndexOutOfBoundsException
 */

public class Task_2 {
    public static void main(String[] args) {
        try {
            int d = 6;
            int[] intArray = { 1, 2, 3, 4, 10};
            int catchedRes1 = intArray[4] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}


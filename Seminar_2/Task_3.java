package Seminar_2;
/*
public static void main(String[] args) throws Exception {                           <- Убираем выброс исключения
   try {
       int a = 90;
       int b = 3;
       System.out.println(a / b);
       printSum(23, 234);
       int[] abc = { 1, 2 };
       abc[3] = 9;                                                                  <- Меняем индекс [3] на индекс в пределах массива
   } catch (Throwable ex) {                                                         <- Убираем обработку исключений и ошибок, и ставим RuntimeException c переносом вниз списка
       System.out.println("Что-то пошло не так...");
   } catch (NullPointerException ex) {                                              <- Заменяем на ArithmeticException
       System.out.println("Указатель не может указывать на null!");
   } catch (IndexOutOfBoundsException ex) {
       System.out.println("Массив выходит за пределы своего размера!");
   }
}
public static void printSum(Integer a, Integer b) throws FileNotFoundException {    <- Убираем выброс усключения и меняем Integer на int 
   System.out.println(a + b);
}
*/


public class Task_3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(a, b);
            int[] abc = { 1, 2 };
            abc[1] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("На ноль делить нельзя!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (RuntimeException ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }

}

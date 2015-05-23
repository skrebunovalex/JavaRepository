package doplab4;

/*4.	На вход программе поступает трёхзначное число (от 100 до 999), которое генерируется случайным образом либо
вводиться из консоли (на своё усмотрение). Необходимо определить является ли число счастливым.
Счастливое число, это число у которого все цифры совпадают (например 777), либо число у которого каждая последующая
цифра на 1 больше предыдущей (123 или 456), а также счастливыми являются числа 781, 302, 409 и 941 (такие числа будет
называть “Магическими”).
Программа должна вывести на экран входное число ( только в случае если оно было сгенерировано) и результат какое число
попалось: “Счастливое”, “Несчастливое” или “Магическое”.
 */
public class Main {
    public static void main(String[] args) {
        int number = 100 + (int) (Math.random() * ((999 - 100) + 1));
        System.out.println(number);
        int numberThree = number % 10;
        int numberTwo = (number / 10) % 10;
        int numberOne = number / 100;
        System.out.println(numberOne + " " + numberTwo + " " + numberThree);
        if (numberThree == numberTwo && numberTwo == numberOne) {
            System.out.println("Число счастливое");
        } else if (numberOne + 1 == numberTwo && numberTwo + 1 == numberThree) {
            System.out.println("Число счастливое");
        } else if (number == 781 || number == 302 || number == 409 || number == 941) {
            System.out.println("Число магическое");
        } else {
            System.out.println("Число несчастливое");
        }
    }
}

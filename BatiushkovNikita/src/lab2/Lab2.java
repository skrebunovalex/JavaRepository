package lab2;

// Seconds in weeks
public class Lab2 {
    public static void main(String[] args) {
        int s = 6188392;
        int sec = s % 60;
        int m = (s - sec) / 60;
        int min = m % 60;
        int h = (m - min) / 60;
        int hour = h % 24;
        int d = (h - hour) / 24;
        int days = d % 7;
        int weeks = (d - days) / 7;
        System.out.println(weeks + " недель " + days + " дней " + hour + " часов " + min + " минут " + sec + " секунд ");
    }
}

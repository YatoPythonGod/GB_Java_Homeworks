package Task_1;

// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

public class Task_1 {
    public static void main(String[] args) {
        System.out.println(get_triangle_num(5));
    }
    static int get_triangle_num(int num) {
        if (num == 1) return 1;
        return num + get_triangle_num(num - 1);
    }

}

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the limits for the array Rx: ");
        double Rx1 = scanner.nextDouble();
        double Rx2 = scanner.nextDouble();
        double Rxst = 1;
        double[] Rx = EnterArr(Rx1, Rx2, Rxst);

        System.out.println("Enter the limits for the array R1: ");
        double R11 = scanner.nextDouble();
        double R12 = scanner.nextDouble();
        double R1st = 1;
        double[] R1 = EnterArr(R11, R12, R1st);

        System.out.println("Enter the limits for the array R2: ");
        double R21 = scanner.nextDouble();
        double R22 = scanner.nextDouble();
        double R2st = 1;
        double[] R2 = EnterArr(R21, R22, R2st);

        double[] A = Sum(R1, R2);
        double[] B = Mult(R1, R2);

        double[] mult1 = Mult(Rx, A);
        double[] sum1 = Sum(mult1, B);
        double[] sum2 = Sum(Rx, R2);
        double[] Z = Div(sum1, sum2);

        System.out.println("Rx: " + Arrays.toString(Rx));
        System.out.println("R1: " + Arrays.toString(R1));
        System.out.println("R2: " + Arrays.toString(R2));
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
        System.out.println("Result array Z: " + Arrays.toString(Z));

        // Находим пересечение массивов Rx и Z
        List<Double> intersection = findIntersection(Rx, Z);
        System.out.println("Intersection points: " + intersection);
    }

    // Метод для нахождения пересечения двух массивов
    public static List<Double> findIntersection(double[] arr1, double[] arr2) {
        List<Double> intersection = new ArrayList<>();
        for (double num1 : arr1) {
            for (double num2 : arr2) {
                if (Double.compare(num1, num2) == 0 && !intersection.contains(num1)) {
                    intersection.add(num1);
                }
            }
        }
        return intersection;
    }

    // Остальные методы (EnterArr, Sum, Mult, Div) остаются без изменений
    public static double[] EnterArr(double start, double end, double step) {
        int size = (int) ((end - start) / step) + 1;
        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = start + i * step;
        }

        return array;
    }

    public static double[] Sum(double[] arr1, double[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        double[] res = new double[n1 * n2];
        int index = 0;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                res[index++] = arr1[i] + arr2[j];
            }
        }
        return res;
    }

    public static double[] Mult(double[] arr1, double[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        double[] res = new double[n1 * n2];
        int index = 0;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                res[index++] = arr1[i] * arr2[j];
            }
        }
        return res;
    }

    public static double[] Div(double[] arr1, double[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        double[] res = new double[n1 * n2];
        int index = 0;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr2[j] != 0) {
                    res[index++] = arr1[i] / arr2[j];
                } else {
                    res[index++] = Double.NaN;
                }
            }
        }
        return res;
    }
}
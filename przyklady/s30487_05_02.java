import java.util.Arrays;
import java.util.Comparator;

public 
class s30487_05_02 implements Comparator<Integer> {

    public static final int BY_VAL = 1;
    public static final int BY_VAL_REV = 2;
    public static final int BY_NUM_OF_DIVS = 3;
    public static final int BY_SUM_OF_DIGS = 4;


    private final int criterion;


    public s30487_05_02(int criterion) {
        this.criterion = criterion;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Cannot compare null values");
        }

        int result = 0;

        switch (criterion) {
            case BY_VAL:
                result = Integer.compare(o1, o2);
                break;
            case BY_VAL_REV:
                result = Integer.compare(o2, o1);
                break;
            case BY_NUM_OF_DIVS:
                result = Integer.compare(countDivisors(o1), countDivisors(o2));
                if (result == 0) {
                    result = Integer.compare(o1, o2);
                }
                break;
            case BY_SUM_OF_DIGS:
                result = Integer.compare(sumOfDigits(o1), sumOfDigits(o2));
                if (result == 0) {
                    result = Integer.compare(o1, o2);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid comparison criterion");
        }

        return result;
    }

//dzielniki
    private int countDivisors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }

//suma
    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] numbers = { 34, 121, 4, 22, 8 };

        s30487_05_02 compByValue = new s30487_05_02(s30487_05_02.BY_VAL);
        s30487_05_02 compByValueRev = new s30487_05_02(s30487_05_02.BY_VAL_REV);
        s30487_05_02 compByDivisors = new s30487_05_02(s30487_05_02.BY_NUM_OF_DIVS);
        s30487_05_02 compBySumDigits = new s30487_05_02(s30487_05_02.BY_SUM_OF_DIGS);

        System.out.println("Original array:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Arrays.sort(numbers, compByValue);
        System.out.println("Sorted by value:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Arrays.sort(numbers, compByValueRev);
        System.out.println("Sorted by value reversed:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Arrays.sort(numbers, compByDivisors);
        System.out.println("Sorted by number of divisors:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Arrays.sort(numbers, compBySumDigits);
        System.out.println("Sorted by sum of digits:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
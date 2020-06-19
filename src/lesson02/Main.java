package lesson02;

public class Main extends RuntimeException {

    public static void main(String[] args) {

        String[][] array = {{"1", "2", "a", "4"},
                           {"a", "2", "a", "4"},
                           {"1", "2"},
                           {"1", "a", "4"},
                           {"1", "2", "a", "4"}};

        checkArraySize(array, 4, 4);
    }

    public static void checkArraySize(String array[][], int rightNumberOfRows, int rightNumberOfElementsInRaw) {

        try {
            if (array.length != rightNumberOfRows) {
                throw new MyArraySizeException("Некорректное количество строк: ", array.length);
            }
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage() + e.getNumber());
        }


        for (int i = 0; i < array.length; i++) {
            try {
                if (array[i].length != rightNumberOfElementsInRaw) {
                    throw new MyArraySizeException("Некорректное количество символов в строке " + i +
                            ": ", array[i].length);
                }
            } catch (MyArraySizeException e) {
                System.err.printf(e.getMessage() + e.getNumber() + "\n");
            }
        }


        int sum = 0;
        int newItem;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    try {
                        newItem = Integer.parseInt(array[i][j]);
                        sum += newItem;

                    } catch (NumberFormatException e) {
                       /* System.out.printf("Не удалось изменить тип (строка, элемент): %d, %d\n", i, j);*/
                        throw new MyArrayDataException("Не удалось изменить тип (строка, элемент): ");
                    }

                } catch (MyArrayDataException e) {
                     System.err.printf(e.getMessage() + i + ", "+ j + "\n");

                }
            }
        }

        System.out.println("Сумма элементов массива, которые удалось преобразовать: " + sum);
    }
}








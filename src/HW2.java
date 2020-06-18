public class HW2 {

    private static final int arraySize = 4;

    private static final String [][] correctData = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15","16"},
    };

    private static final String[][] incorrectSizeData = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7"},
            {"9", "10", "11", "12"},
            {"13", "14", "15","16"},
    };

    private static final String[][] incorrectValueData = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "b"},
            {"13", "14", "15","16"},
    };

    public static void main(String[] args) {
        try {
//            int result = sumArrayValue(correctData);
//            int result = sumArrayValue(incorrectSizeData);
            int result = sumArrayValue(incorrectValueData);
            System.out.println("Сумма массива равна: " + result);
        } catch (MyArraySizeException e){
            System.out.println("Некорректный размер массива!");
            e.printStackTrace();
        } catch (MyArrayDataException e){
            System.out.println("Некорректные данные в массиве");
            e.printStackTrace();
        }
    }



    private static int sumArrayValue(String[][] data) {
        checkArraySize(data);

        int sumResult = 0;

        for ( int rowIndex = 0; rowIndex < data.length; rowIndex++){
            String[] row = data[rowIndex];
            for (int colIndex = 0; colIndex < row.length ; colIndex++) {
                String value = row[colIndex];
                try {
                    sumResult += Integer.parseInt(value);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(value, rowIndex, colIndex);
                }
            }
        }
        return sumResult;
    }

    private static void checkArraySize (String [][] data){
        if (data.length != arraySize){
            throw new MyArraySizeException();
        }

        for (String[] row: data) {
            if (row.length != arraySize){
                throw new MyArraySizeException();
            }
        }
    }

}

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String cellValue, int rowIndex, int colIndex){
        super(String.format("Неверное значение '%s' в ячейке [%d][%d] массива, требуется число",
                cellValue, rowIndex, colIndex));
    }
}

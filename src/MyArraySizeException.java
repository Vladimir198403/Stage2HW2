public class MyArraySizeException extends IllegalArgumentException {

    public MyArraySizeException(){
        super("Неверный размер массива, рекомендуемый размер 4х4");
    }
}

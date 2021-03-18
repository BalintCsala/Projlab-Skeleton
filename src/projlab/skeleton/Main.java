package projlab.skeleton;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // FunctionPrinter használat
    public void testFunc() {
        FunctionPrinter.enter("Main", "testFunc");
        FunctionPrinter.msg("Uzenet a fuggvenyen belul");
        FunctionPrinter.exit();
    }

}

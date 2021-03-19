package projlab.skeleton.utils;

import java.util.ArrayList;

public class FunctionPrinter {

    private static int level = 0;

    private static ArrayList<String> names = new ArrayList<>();

    public static void enter(String className, String name) {
        String n = className + "#" + name + "()";
        System.out.println("    ".repeat(level) + n + " {");
        names.add(n);
        level++;
    }

    public static void msg(String msg) {
        System.out.println("    ".repeat(level) + msg);
    }

    public static void exit() {
        level--;
        System.out.println("    ".repeat(level) + "} // " + names.remove(names.size() - 1));
    }



}

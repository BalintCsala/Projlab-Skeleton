package projlab.skeleton.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

public class FunctionPrinter {

    private static int level = 0;

    private static ArrayList<String> names = new ArrayList<>();
    private static HashMap<Object, String> objects = new HashMap<>();

    public static void register(Object object, String name) {
        objects.put(object, name);
    }

    public static void enter(String className, String name, Object object, Object... parameters) {

        StringJoiner joiner = new StringJoiner(", ");
        for (Object parameter : parameters) {
            if (parameter == null) {
                joiner.add("null");
            } else if (objects.containsKey(parameter)) {
                joiner.add(objects.get(parameter));
            } else {
                joiner.add(parameter.toString());
            }
        }

        String objName;
        if (objects.containsKey(object)) {
            objName = objects.get(object) + ".";
        } else {
            objName = className + "#";
        }

        String n = objName + name + "(" + joiner.toString() + ")";
        System.out.println("    ".repeat(level) + n + " {");
        names.add(n);
        level++;
    }

    public static void msg(String msg) {
        System.out.println("    ".repeat(level) + msg);
    }

    public static void ask(String question) {
        System.out.print("    ".repeat(level) + question + " ");
    }


    public static void exit() {
        level--;
        System.out.println("    ".repeat(level) + "}");
    }



}

package projlab.skeleton.utils;

import java.util.HashMap;

public class ObjectCatalog {

    private ObjectCatalog() {}

    private static final HashMap<String, Object> objects = new HashMap<>();

    public static void addObject(String name, Object object) {
        objects.put(name, object);
    }

    public static Object getObject(String name) {
        return objects.get(name);
    }

    public static String getName(Object object) {
        for (String name : objects.keySet()) {
            if (objects.get(name) == object)
                return name;
        }
        return "";
    }

    public static String getInfo(String name) {
        return getInfo(name, 0);
    }

    public static String getInfo(String name, int indent) {
        if (getObject(name) == null)
            return "    ".repeat(indent) + "null";
        String[] info = getObject(name).toString().split("\n");
        StringBuilder builder = new StringBuilder();
        for (String line : info) {
            builder.append("    ".repeat(indent)).append(line).append("\n");
        }

        return builder.toString();
    }

}

package lab1app.tasks;

public class CamelCaseSplitter {
    public String splitCamelCase(String input) {
        return input.replaceAll("([a-z])([A-Z]+)", "$1 $2");
    }
}
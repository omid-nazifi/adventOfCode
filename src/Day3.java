import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        String path = "C:\\HDD\\FH\\Semester 3\\ASD\\AdventOfCode\\src\\day3.txt";
        long lastResult;
        List<String> values = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                values.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        lastResult = getManyofTrees(values, 1, 1);
        lastResult *= getManyofTrees(values, 3, 1);
        lastResult *= getManyofTrees(values, 5, 1);
        lastResult *= getManyofTrees(values, 7, 1);
        lastResult *= getManyofTrees(values, 1, 2);

        System.out.println(lastResult);
    }

    private static int getManyofTrees(final List<String> values, int column, int row) {
        int treeCounter = 0;
        int rowCounter = 0;
        int index = 0;
        for (String line : values) {
            if (rowCounter != 0 && rowCounter % row == 0) {
                index = index + column > line.length() - 1 ? column - (Math.abs(line.length() - index)) : index + column;
                treeCounter += line.charAt(index) == '#' ? 1 : 0;
            }
            rowCounter++;
        }
        return treeCounter;
    }
}

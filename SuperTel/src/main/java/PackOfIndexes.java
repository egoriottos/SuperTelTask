import java.util.ArrayList;
import java.util.List;

public class PackOfIndexes {
    private final String[] array;

    public PackOfIndexes(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String str : array) {
            builder.append(str + ",");
        }
        return builder.toString();
    }

    /*
    Преобразование массива, где вместо '-' появляются числа
     */
    public List<Integer> generateIndexes() {
        List<Integer> list = new ArrayList<>();
        for (String element : array) {
            String[] parts = element.split(",");
            for (String part : parts) {
                if (part.contains("-")) {
                    String[] getRange = part.split("-");
                    int startNumber = Integer.parseInt(getRange[0]);
                    int endNumber = Integer.parseInt(getRange[1]);
                    for (int j = startNumber; j <= endNumber; j++) {
                        list.add(j);
                    }
                } else {
                    list.add(Integer.parseInt(part));
                }
            }
        }
        return list;
    }
    List<List<Integer>> generateAllCombinations(List<Integer>combinationsList){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : combinationsList) {
            int currentSize = result.size();
            for (int i = 0; i < currentSize; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }
        result.remove(0);
        return result;
    }

}

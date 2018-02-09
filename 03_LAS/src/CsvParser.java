import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvParser {
    private Function<String, RecordLine> mapToItem = (line) -> {
        String[] p = line.split(";");// a CSV has comma separated lines
        //more initialization goes here
        return new RecordLine(
                Integer.parseInt(p[0]),
                Integer.parseInt(p[1]),
                Integer.parseInt(p[2]),
                p[3].charAt(0),
                Integer.parseInt(p[4]),
                p[5],
                Integer.parseInt(p[6]),
                Integer.parseInt(p[7]),
                Integer.parseInt(p[8]));
    };

    public List<RecordLine> processInputFile(String inputFilePath) {
        List<RecordLine> inputList = new ArrayList<>();
        try {
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

}

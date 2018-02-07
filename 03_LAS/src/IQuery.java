import java.util.List;
import java.util.Map;

public interface IQuery {
    long executeSQL01();

    long executeSQL02();

    long executeSQL03();

    long executeSQL04();

    List<Integer> executeSQL05();

    List<Integer> executeSQL06();

    Map<Character, Long> executeSQL07();

    Map<Integer, Long> executeSQL08();

    Map<Character, Long> executeSQL09();

    Map<Character, Long> executeSQL10();

    Map<Character, Long> executeSQL11();

    Map<Integer, Long> executeSQL12();
}
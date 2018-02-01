import javafx.util.Pair;

import java.util.List;

public interface IQuery {
    long executeSQL01();

    long executeSQL02();

    long executeSQL03();

    long executeSQL04();

    List<Integer> executeSQL05();

    List<Integer> executeSQL06();

    List<Pair<Character,Long>> executeSQL07();

    List<Pair<Integer,Long>>  executeSQL08();

     List<Pair<Character,Long>> executeSQL09();

    List<Pair<Character,Long>>  executeSQL10();

    List<Pair<Character,Long>>  executeSQL11();

    List<Pair<Character,Double>>  executeSQL12();
}
package genericCollection.sec10;

import java.util.List;
import java.util.Vector;

public class VectorBoardMain {
    public static void main(String[] ignoredArgs) {
        List<Board> list = new Vector<>();

        list.add(new Board("subject1  ", "detail1  ", "author1"));
        list.add(new Board("subject1-1", "detail1-1", "author1-1"));
        list.add(new Board("subject1-2", "detail1-2", "author1-2"));
        list.add(new Board("subject1-3", "detail1-3", "author1-3"));
        list.add(new Board("subject1-4", "detail1-4", "author1-4"));
        list.add(new Board("subject1-5", "detail1-5", "author1-5"));

        list.remove(2);
        list.remove(3);

        for (Board board : list) {
            System.out.println("Subject: " + board.subject + ",\tContent: " + board.content + ",\tAuthor: " + board.author);
        }
    }
}

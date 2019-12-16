import java.io.*;

/**
 * @author shenjian
 * @description 测试类
 * @date 2019/12/3
 */
public class Test {

    public static void main(String[] args) throws IOException {
       String path = "sql/first.sql";

       BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("-----------------------");
            System.out.println("语句 -> " + line);
            System.out.println("-----------------------");
        }
    }
}

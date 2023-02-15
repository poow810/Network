package Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamDemo7 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:/network/Stream/자바.txt");
            Stream<String> st;

            // Files 클래스의 line()
            st = Files.lines(path, Charset.defaultCharset());
            st.forEach(System.out::println);
            // BufferedReader 클래스의 lines()

            File file = path.toFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader); // 파일에서 한 줄씩 뽑아오기 위한 buffer 객체 생성
            st = bufferedReader.lines();
            st.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

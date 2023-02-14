package genericclass;

public class GenericClassTest1 {
    public static void main(String[] args) {
        PostBox<String> postBox = new PostBox<>();
//      PostBox<int> postBox1 = new PostBox<int>() 에러남
        PostBox<Integer> postBox1 = new PostBox<>();
        postBox.setItem("소포");  // 문자열만 올 수 있음
        postBox1.setItem(77);
        System.out.println(postBox.getItem());
        System.out.println(postBox1.getItem());
    }
}

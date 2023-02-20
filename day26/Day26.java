package day26;

public class Day26 {
    private String secret = "캡슐화된 변수";
    String s = "Day26 인스턴스 변수";

    class MemberClass {
        String s = "MemberClass의 인스턴스 변수";

        public void show() {
            System.out.println("내부 클래스");
            System.out.println(secret); // MemberClass안에 secret 변수가 존재하지 않아 바깥 스코프의 secret 변수 값을 출력 x

            System.out.println(s); // MemberClass안에 s 변수가 존재

            System.out.println(Day26.this.s); // Day26의 인스턴스 변수 s의 값을 출력
        }

         static String s3 = "정적 멤버 필드";
        // static void show2() {}
    }

    public static void main(String[] args) {
        Day26 m = new Day26();
        Day26.MemberClass mc = m.new MemberClass();

        System.out.println(mc.s);
        mc.show();
        mc.s3 = "test";
        System.out.println(Day26.MemberClass.s3);
    }
}

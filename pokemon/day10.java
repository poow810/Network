package pokemon;

import java.util.List;
import java.util.Scanner;

class Pokemon {     // abstract로 객체를 생성 못하는 추상 클래스로 만들어도 된다.

    public static int count = 0;
    protected String owner;
    protected List<String> skill;

    public Pokemon(String owner, String skill) {
        this.owner = owner;
        this.skill = List.of(skill.split("/")); // split으로 스킬을 배열로 만들고 리스트에 다시 담음
        System.out.print("포켓몬 생성됨 : ");
        count += 1;

    }
    public List<String> getSkill() {
        return skill;
    }

    public void info() {
        System.out.printf("%s의 포켓몬이 사용 가능한 스킬입니다.", owner);
        System.out.println(skill);
    }
}

class Pikachu extends Pokemon {
    private final String name;

    public Pikachu(String owner, String skill, String name) {
        super(owner, skill);
        this.name = "피카츄";
        System.out.println(this.name);
    }

    public void attack(int num) {
        System.out.printf("%s의 %s가 %s 공격 시전\n", owner, name, skill.get(num-1));
    }
}

class Pairi extends Pokemon {
    private final String name;

    public Pairi(String owner, String skill, String name) {
        super(owner, skill);
        this.name = "파이리";
        System.out.println(this.name);
    }

    public void attack(int num) {
        System.out.printf("%s의 %s가 %s 공격 시전\n", owner, name, skill.get(num-1));
    }
}

class Ggobugi extends Pokemon {
    private final String name;

    public Ggobugi(String owner, String skill, String name) {
        super(owner, skill);
        this.name = "꼬부기";
        System.out.println(this.name);
    }

    public void attack(int num) {
        System.out.printf("%s의 %s가 %s 공격 시전\n", owner, name, skill.get(num - 1));
    }
}

public class day10 {
    public static void main(String[] args) {
        while (true) {
            System.out.printf("총 %d마리의 포켓몬이 생성되었습니다.", Pokemon.count);
            Scanner in = new Scanner(System.in);
            System.out.print("1) 포켓몬 생성 2) 프로그램 종료 : ");
            int menu = in.nextInt();
            if (menu == 2) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else if (menu == 1) {
                System.out.print("1) 피카츄 2) 꼬부기 3) 파이리 : ");
                int pokemon = in.nextInt();
                if (pokemon == 1) {
                    System.out.print("플레이어 이름 입력 : ");
                    in.nextLine();
                    String myowner = in.nextLine();
                    System.out.print("사용 가능한 기술 입력(/로 구분하여 입력) : ");
                    String myskill = in.nextLine();
                    Pikachu p = new Pikachu(myowner, myskill, "피카츄");
                    System.out.println("1) 정보조회 2) 공격");
                    int num = in.nextInt();
                    if (num == 1) {
                        p.info();
                    } else if (num == 2) {
                        System.out.println(p.getSkill());
                        System.out.print("공격 번호 선택 : ");
                        int attack_menu = in.nextInt();
                        p.attack(attack_menu);
                    }
                } else if (pokemon == 2) {
                    System.out.print("플레이어 이름 입력 : ");
                    in.nextLine();
                    String myowner = in.nextLine();
                    System.out.print("사용 가능한 기술 입력(/로 구분하여 입력) : ");
                    String myskill = in.nextLine();
                    Pairi p = new Pairi(myowner, myskill, "피카츄");
                    System.out.println("1) 정보조회 2) 공격");
                    int num = in.nextInt();
                    if (num == 1) {
                        p.info();
                    } else if (num == 2) {
                        System.out.println(p.getSkill());
                        System.out.print("공격 번호 선택 : ");
                        int attack_menu = in.nextInt();
                        p.attack(attack_menu);
                    }
                } else if (pokemon == 3) {
                    System.out.print("플레이어 이름 입력 : ");
                    in.nextLine();
                    String myowner = in.nextLine();
                    System.out.print("사용 가능한 기술 입력(/로 구분하여 입력) : ");
                    String myskill = in.nextLine();
                    Ggobugi p = new Ggobugi(myowner, myskill, "피카츄");
                    System.out.println("1) 정보조회 2) 공격");
                    int num = in.nextInt();
                    if (num == 1) {
                        p.info();
                    } else if (num == 2) {
                        System.out.println(p.getSkill());
                        System.out.print("공격 번호 선택 : ");
                        int attack_menu = in.nextInt();
                        p.attack(attack_menu);
                    }
                }

            }else{
                System.out.println("메뉴에서 골라주세요");
            }

        }

    }

}


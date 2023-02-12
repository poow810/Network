package pokemon;

import java.util.List;
import java.util.Scanner;

class Pokemon {

    static int count = 0;
    protected String owner;
    protected List<String> skill;

    public Pokemon(){

    }
    public Pokemon(String owner, String skill) {
        this.owner = owner;
        this.skill = List.of(skill.split("/"));
        System.out.println("포켓몬 생성됨");
        count+=1;

    }
    public void setOwner(String owner){
        this.owner = owner;}
    public String getOwner(){
        return owner;}
    public void setSkill(String skill){
        this.skill = List.of(skill.split("/"));}
    public List<String> getSkill(){
        return skill;}
}

class Pikachu extends Pokemon {
    private String name;
    public Pikachu(){

    }

    public Pikachu(String owner, String skill) {
        super(owner, skill);
    }
    public void setName(String name){
        this.name = "피카츄";}
    public String getName(){
        return "피카츄";}


    public void attack() {
        System.out.printf("%s의 %s가 %s 공격 시전", owner, name, skill);
    }
}

class Pairi extends Pokemon {
    private String name;

    public Pairi(String owner, String skill) {
        super(owner, skill);
    }
    public void setName(String name){
        this.name = "파이리";}
    public String getName(){
        return "파이리";}

    public void attack() {
        System.out.printf("%s의 %s가 %s 공격 시전", owner, name, skill);
    }

}

class Ggobugi extends Pokemon {
    private String name;
    public Ggobugi(String owner, String skill) {
        super(owner, skill);
    }
    public void setName(String name){
        this.name = "꼬부기";}
    public String getName(){
        return "꼬부기";}

    public void attack() {
        System.out.printf("%s의 %s가 %s 공격 시전", owner, name, skill);
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
                if (pokemon == 1){
                    Pikachu p = new Pikachu();
                    System.out.print("플레이어 이름 입력 : ");
                    p.setOwner(in.nextLine());
                    in.nextLine();
                    System.out.print("사용 가능한 기술 입력(/로 구분하여 입력) : ");
                    p.setSkill(in.nextLine());

                }

                }

            }

        }

    }

package pokemon_professor_code;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public abstract class Pokemon {
    private String owner;
    private List<String> skills;
    public static int count = 0;

    public String getOwner() {
        return owner;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Pokemon(String owner, String skills) {
        this.owner = owner;
        StringTokenizer st = new StringTokenizer(skills, "/");  // /기준으로 토큰을 만듦
        this.skills = new ArrayList<>();
        while(st.hasMoreTokens()){  // True, False return, 토큰이 남아있으면 무한루프
            this.skills.add(st.nextToken());  // 다음 토큰을 skills에 계속 추가
        }
        System.out.print("포켓몬 생성 : ");
        Pokemon.count = Pokemon.count + 1;
    }

    public void attack(int idx){
        System.out.println(this.skills.get(idx) + "공격 시전!");
    }
    public void info(){
        int idx = 0;
        System.out.println(this.owner + "의 포켓몬이 사용 가능한 스킬");
        for(String skill : skills){
            System.out.println(++idx + " : " + skill);
        }
    }
}

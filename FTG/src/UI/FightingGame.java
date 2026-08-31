package UI;

import domain.EnemyCharacter;
import domain.HeroCharacter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FightingGame {
    public void  start (String username){
        // 1. 显示游戏的标题
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│    🎮 " + username + " 欢迎来到文字格斗游戏 🎮   │");
        System.out.println("└─────────────────────────────────────────────────┘");

        HeroCharacter player = createHeroCharacter(username);
        System.out.println("角色创建成功！");
        System.out.println("角色初始属性为：" + player.show());
        System.out.println("角色技能为：" + player.skills.toString().replace("[", "").replace("]", ""));

        // name    hp    atk    def    skill
        // 初级战士   80     15     10     猛击
        // 敏捷刺客   60     20      5     快速攻击
        // 重装坦克  120     10     20     防御姿态
        // 神秘法师   70     25      8     火球术（180%伤害）
        ArrayList<EnemyCharacter> enemies = new ArrayList<>();
        enemies.add(new EnemyCharacter("初级战士", 80, 15, 10, "猛击"));
        enemies.add(new EnemyCharacter("敏捷刺客", 60, 20, 5, "快速攻击"));
        enemies.add(new EnemyCharacter("重装坦克", 120, 10, 20, "防御姿态"));
        enemies.add(new EnemyCharacter("神秘法师", 70, 25, 8, "火球术（180%伤害）"));
    }
    public HeroCharacter createHeroCharacter(String username){
        System.out.println("创建您自己的角色");
        System.out.println("您当前的角色名为：" + username);

        int points = 20;
        Scanner sc = new Scanner(System.in);
        String[] options = {"生命值", "攻击力", "防御力"};
        String[] optionDescriptions = {"每点 + 10HP", "每点 + 2", "每点 + 1"};
        Map<String, Integer> optionsMap = new HashMap<>();
        for (int i = 0; i < options.length; i++) {
            System.out.println("请输入您想分配给" + options[i] + "的点数（当前属性点数为：" + points + "）");
            System.out.println(options[i] + "：" + optionDescriptions[i]);
            int inputPoints = sc.nextInt();
            if(inputPoints > points){
                System.out.println("您输入的属性点数超过当前属性点数，将把全部点数分配给" + options[i]);
                inputPoints = points;
                points = 0;
            } else if (inputPoints < 1) {
                System.out.println("您输入的属性点数小于1，默认分配0点");
                inputPoints = 0;
            }else {
                points -= inputPoints;
            }
            optionsMap.put(options[i], inputPoints);
        }
        HeroCharacter heroCharacter = new HeroCharacter(
                username,
                optionsMap.get("生命值") * 10 + 100,
                optionsMap.get("攻击力") * 2 + 10,
                optionsMap.get("防御力") + 10
        );
        heroCharacter.skills.add("普通攻击");
        heroCharacter.skills.add("强力一击");
        heroCharacter.skills.add("生命汲取");

        return heroCharacter;
    }
}

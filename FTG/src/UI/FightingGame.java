package UI;

import com.sun.source.tree.CaseTree;
import domain.EnemyCharacter;
import domain.HeroCharacter;

import java.util.*;

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

        int count = 1;
        int winCount = 0;
        while (player.isAlive()){

            if(count > 1){
                for (int i = 0; i < enemies.size(); i++) {
                    EnemyCharacter enemy = enemies.get(i);
                    enemy.HP += 10;
                    enemy.maxHp += 10;
                    enemy.attack += 3;
                    enemy.defense += 2;
                    enemy.defending = false;
                }
            }

//            挑选随机敌人
            Random r = new Random();
            int enemyIndex = r.nextInt(enemies.size());
            EnemyCharacter enemy = enemies.get(enemyIndex);
            System.out.println("敌人："+enemy.show());

//            战斗开始
            System.out.println("==============================");
            System.out.println("第" + count + "场战斗 开始！");
            int round = 1;
            while (player.isAlive()){
                System.out.println("===========================");
                System.out.println("第" + round + "轮回合");
//                打印双方血条
                System.out.println(printBloodBar(player.name, player.HP, player.maxHp));
                System.out.println(printBloodBar(enemy.name, enemy.HP, enemy.maxHp));
                playerTurn(player, enemy);
                if (!enemy.isAlive()){
                    System.out.println("你击败了敌人：" + enemy.name);
                    winCount++;
                    break;
                }
                enemyTurn(enemy, player);

                if (!player.isAlive()){
                    System.out.println("你被" + enemy.name + "击败了！");
                    break;
                }
                round ++;

            }


            if(player.isAlive()){
                int healHp = r.nextInt(20) + 20;
                player.heal(healHp);
                System.out.println("你恢复了 " + healHp + " HP");
                System.out.println("当前胜利场数：" + winCount);
                System.out.println("===============================");
              if(winCount >0 && winCount%3 == 0){
                  player.maxHp +=30;
                  player.attack += 5;
                  player.defense += 3;
                  System.out.println("你的角色等级提升，属性已提升！最大生命值提升30，攻击力提升5，防御力提升3");
                  System.out.println("当前属性为：" + player.show());

              }
                System.out.println("是否继续下一场战斗？（y/n）");
                Scanner sc = new Scanner(System.in);
                String choice = sc.next();
                if (choice.equalsIgnoreCase("n")){
                    System.out.println("游戏结束，感谢游玩！");
                    break;
                }else if (choice.equalsIgnoreCase("y")){
                    count ++;
                } else {
                    System.out.println("未知输入，结束游戏！");
                    break;
                }
            }

        }

        System.out.println("总胜场为"+winCount+"场!");
        System.out.println("游戏结束，感谢游玩！");




    }
//    定义一个方法打印敌我双方的血条
    public String printBloodBar(String name, int hp, int maxHp){
        // 定义一个方法打印敌我双方的血条
// 满血： 【████████████████】
// 半血： 【████████        】
// 残血： 【█               】


// zhangsan: [████████████████] 100/100 HP
// 初级战士: [████████████████] 80/80 HP
        int barLength = 20;
        int filledLength = (int) (hp * 1.0 / maxHp * barLength);
        StringBuffer bloodBar =  new StringBuffer();
        bloodBar.append(name+ ": " + "[");
        for (int i = 0; i < barLength; i++) {
            if (i < filledLength) {
                bloodBar.append("█");
            } else {
                bloodBar.append(" ");
            }
        }
        bloodBar.append("] "+hp+"/"+maxHp);
        return bloodBar.toString();
    }

    public void playerTurn(HeroCharacter player, EnemyCharacter enemy){
        System.out.println("======你的回合======");
        System.out.println("请选择你的行动：1.普通攻击 2.强力一击 3.生命汲取");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()){
            default:
                System.out.println("未匹配到动作，默认使用普通攻击");
            case 1:
                int damage = getDamage(player.attack, enemy.defense);
                System.out.println("你使用普通攻击对"+ enemy.name +"造成了" + damage + "点伤害");
                enemy.takeDamage(damage);
                break;
            case 2 :

                if(player.HP > 10){
                    player.takeDamage(10);
                    int damage2 = getDamage((int)(player.attack * 1.8), enemy.defense);
                    System.out.println("你使用强力一击对"+ enemy.name +"造成了" + damage2 + "点伤害");
                    enemy.takeDamage(damage2);
                    System.out.println("你消耗了 10 HP，对" + enemy.name + "造成了" + damage2 + "点伤害");
                }else{
                    System.out.println("体力不足攻击失败！");
                }

                break;
            case 3:
                if(player.HP > 10){
                    player.takeDamage(10);
                    Random r = new Random();
                   int healHp = r.nextInt(21) + 10;
                    player.heal(healHp );
                    System.out.println("你消耗了 10 HP，恢复了 " + healHp + " HP");
                }else{
                    System.out.println("体力不足攻击失败！");
                };
                break;
        }

    }

    public int getDamage(int attack, int defense){
        return defense >= attack ? 1 :  attack - defense;
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

    public void enemyTurn(EnemyCharacter enemy, HeroCharacter player){
        System.out.println("======敌人:"+enemy.name+"的回合======");
        String action = "普通攻击";
        Random r = new Random();
        int n = r.nextInt(2);
        if(n == 0){
            action = enemy.skill;
        }

        switch (action){
            case "普通攻击":
                System.out.println("敌人："+ enemy.name +"采取了普通攻击");
                int damage = getDamage(enemy.attack, player.defense);
                System.out.println("敌人："+ enemy.name +"对您造成了" + damage + "点伤害");
                player.takeDamage(damage);
                break;
            case "猛击":
                System.out.println("敌人："+ enemy.name +"采取了猛击");
                int damage2 = getDamage((int)(enemy.attack * 1.5), player.defense);
                System.out.println("敌人："+ enemy.name +"对您造成了" + damage2 + "点伤害");
                player.takeDamage(damage2);
                break;
            case "快速攻击":
                System.out.println("敌人："+ enemy.name +"采取了快速攻击");
                int damage3 = 0;
                for (int i = 0; i < 2; i++) {
                    damage3 += getDamage((int)(enemy.attack / 1.5), player.defense);
                }
                System.out.println("敌人："+ enemy.name +"对您造成了" + damage3 + "点伤害");
                player.takeDamage(damage3);
                break;
            case "防御姿态":
                System.out.println("敌人："+ enemy.name +"摆出了防御姿态");
                enemy.defending = true;
                break;
            case "火球术":
                System.out.println("敌人："+ enemy.name +"使用了火球术");
                int damage4 = getDamage((int)(enemy.attack * 1.8), player.defense);
                System.out.println("敌人："+ enemy.name +"对您造成了" + damage4 + "点伤害");
                player.takeDamage(damage4);
                break;
        }

    }

}

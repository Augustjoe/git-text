package domain;

//敌人游戏角色
public class EnemyCharacter extends Character {
    public String skill;
    public boolean defending;

    public EnemyCharacter(String name, int HP, int attack, int defense, String skill) {
        super(name, HP, attack, defense);
        this.skill = skill;
    }
    public EnemyCharacter() {
        super();
    }

    @Override
    public void takeDamage(int damage) {
        if (this.defending) {
            this.HP = this.HP - ((damage / 2) <= 0 ? 1 : (damage / 2));
            this.defending = false;
        } else {
            this.HP = this.HP - damage;
        }
        super.takeDamage(damage);
    }
}

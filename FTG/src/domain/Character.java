package domain;

public class Character {
    public String name;
    public int HP;
    public int maxHp;
    public int attack;
    public int defense;

    public Character(String name, int HP, int attack, int defense) {
        this.name = name;
        this.HP = HP;
        this.maxHp = HP;
        this.attack = attack;
        this.defense = defense;
    }
    public Character() {
    }

    public boolean isAlive() {
        return HP > 0;
    }

    public void heal(int amount) {
        HP += amount;
        if (HP > maxHp) {
            HP = maxHp;
        }
    }

    public  void  takeDamage(int amount) {
        HP -= amount;
        if (HP < 0) {
            HP = 0;
        }
    }

    public String show(){
        return "Name: " + name + ", HP: " + HP + ", Attack: " + attack + ", Defense: " + defense;
    }


}

package domain;

import java.util.ArrayList;

public class HeroCharacter extends Character {

    public ArrayList<String> skills;
    public HeroCharacter(String name, int HP, int attack, int defense) {
        super(name, HP, attack, defense);
        this.skills = new ArrayList<String>();
    }
    public HeroCharacter() {
        super();
        this.skills = new ArrayList<String>();
    }
}

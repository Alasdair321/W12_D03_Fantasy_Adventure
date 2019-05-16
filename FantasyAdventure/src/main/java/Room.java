import Game.Character;
import Game.Interfaces.IHabitable;
import Game.Items.Treasure;

import java.util.ArrayList;

public class Room implements IHabitable {

    private ArrayList<Character> characters;
    private ArrayList<Character> enemies;
    private Treasure treasures; //make some treasure

    public Room(ArrayList<Character> enemies, Treasure treasures) {
        this.characters = new ArrayList<>();
        this.enemies = enemies;
        this.treasures = treasures;
    }

    public Treasure getTreasures() {
        return treasures;
    }

    public int countCharacters(){
        return characters.size();
    }

    public int countCharactersAlive(){
        int living = 0;
        for (Character character : characters){
            if (character.isAlive()){
                living+=1;
            }
        }
        return living;
    }

    public int countEnemiesAlive(){
        int living = 0;
        for (Character kobold : enemies){
            if (kobold.isAlive()){
                living+=1;
            }
        }
        return living;
    }

    public int countEnemies(){
        return enemies.size();
    }

    @Override
    public void enter(Character character) {
        characters.add(character);
    }

    @Override
    public void leave(Character character) {
        if (character.isAlive()){
            characters.remove(character);
        }
    }
}

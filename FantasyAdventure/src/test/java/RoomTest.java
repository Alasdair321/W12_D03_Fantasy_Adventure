import Game.Character;
import Game.Characters.Healer.Cleric;
import Game.Characters.Melee.Barbarian;
import Game.Characters.Melee.Knight;
import Game.Characters.Melee.Rogue;
import Game.Items.Armour;
import Game.Items.HealingItem;
import Game.Items.Treasure;
import Game.Items.Weapon;
import Game.Monster.Enemies.Kobold;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Treasure treasure;
    Room room;
    Kobold kobold1;
    Kobold kobold2;
    Kobold kobold3;
    Knight knight;
    Barbarian barbarian;
    Rogue rogue;
    Cleric cleric;
    ArrayList<Character> kobolds;
    private Armour armour;
    private Weapon weapon;
    private HealingItem orbOfHealing;

    @Before
    public void setUp() {
        kobold1 = new Kobold(0, 2,5);
        kobold2 = new Kobold(0, 2,5);
        kobold3 = new Kobold(20, 2,5);
        kobolds = new ArrayList<>(Arrays.asList(kobold1,kobold2,kobold3));
        treasure = new Treasure();
        armour = new Armour(5);
        weapon = new Weapon(5);
        knight = new Knight(100,10, weapon, 5, armour);
        barbarian = new Barbarian(0, 5,weapon, 10);
        rogue = new Rogue(100,2,weapon, 3);
        orbOfHealing = new HealingItem(2);
        cleric = new Cleric(50,1, orbOfHealing);
        room = new Room(kobolds, treasure);

    }

    @Test
    public void hasNoCharacters() {
        assertEquals(0, room.countCharacters());
    }

    @Test
    public void hasEnemies() {
        assertEquals(3, room.countEnemies());
    }

    @Test
    public void hasTreasure() {
        assertEquals(treasure, room.getTreasures());
    }

    @Test
    public void enterRoom() {
        room.enter(knight);
        room.enter(barbarian);
        room.enter(rogue);
        room.enter(cleric);
        assertEquals(4, room.countCharacters());
    }

    @Test
    public void leaveRoom() {
        room.enter(knight);
        room.enter(barbarian);
        room.enter(rogue);
        room.enter(cleric);
        room.leave(cleric);
        assertEquals(3, room.countCharacters());
    }

    @Test
    public void countAliveCharacters() {
        room.enter(knight);
        room.enter(barbarian);
        room.enter(rogue);
        room.enter(cleric);
        assertEquals(3, room.countCharactersAlive());
    }

    @Test
    public void countAliveEnemies() {
        assertEquals(1, room.countEnemiesAlive());
    }
}

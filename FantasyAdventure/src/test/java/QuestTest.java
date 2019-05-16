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
import Game.Quest;
import Game.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuestTest {

    Treasure treasure;
    Room room1;
    Room room2;
    Room room3;
    Character kobold1;
    Character kobold2;
    Character kobold3;
    Character kobold4;
    Character kobold5;
    Knight knight;
    Barbarian barbarian;
    Rogue rogue;
    Cleric cleric;
    ArrayList<Character> koboldsR1;
    ArrayList<Character> koboldsR2;
    ArrayList<Character> koboldsR3;
    private Armour armour;
    private Weapon weapon;
    private HealingItem orbOfHealing;
    private Quest quest;

    @Before
    public void setUp() throws Exception {
        kobold1 = new Kobold(0, 2,5);
        kobold2 = new Kobold(0, 2,5);
        kobold3 = new Kobold(0, 2,5);
        kobold3 = new Kobold(0, 2,5);
        kobold3 = new Kobold(0, 2,5);
        koboldsR1 = new ArrayList<>(Arrays.asList(kobold1,kobold2,kobold3));
        koboldsR2 = new ArrayList<>(Arrays.asList(kobold1,kobold2,kobold3, kobold4));
        koboldsR3 = new ArrayList<>(Arrays.asList(kobold1,kobold2,kobold3, kobold4, kobold5));
        treasure = new Treasure();
        armour = new Armour(5);
        weapon = new Weapon(5);
        knight = new Knight(100,10, weapon, 5, armour);
        barbarian = new Barbarian(100, 5,weapon, 10);
        rogue = new Rogue(100,2,weapon, 3);
        orbOfHealing = new HealingItem(2);
        cleric = new Cleric(50,1, orbOfHealing);
        room1 = new Room(koboldsR1, treasure);
        room2 = new Room(koboldsR2, treasure);
        room3 = new Room(koboldsR3, treasure);
        quest = new Quest();
    }

    @Test
    public void startsWithEmptyRooms() {
        assertEquals(0, quest.getPartySize());
    }

    @Test
    public void startsWithEmptyParty() {
        assertEquals(0, quest.getRoomsNumber());
    }

    @Test
    public void addRoomToQuest() {
        quest.addRoom(room1);
        assertEquals(1, quest.getRoomsNumber());
    }

    @Test
    public void addPartyMemberToParty() {
        quest.addCharacterToParty(knight);
        assertEquals(1, quest.getPartySize());
    }

    @Test
    public void canEnterFirstRoom() {
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.addRoom(room3);
        quest.addCharacterToParty(knight);
        quest.addCharacterToParty(barbarian);
        quest.addCharacterToParty(rogue);
        quest.addCharacterToParty(cleric);
        quest.beginQuest();
        assertEquals(4, room1.countCharacters());
        assertEquals(0, room2.countCharacters());
        assertEquals(0, room3.countCharacters());
    }

    @Test
    public void completeFirstRoomEnterSecond() {
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.addRoom(room3);
        quest.addCharacterToParty(knight);
        quest.addCharacterToParty(barbarian);
        quest.addCharacterToParty(rogue);
        quest.addCharacterToParty(cleric);
        quest.beginQuest();
        quest.currentRoomComplete();
        assertEquals(0, room1.countCharacters());
        assertEquals(4, room2.countCharacters());
        assertEquals(0, room3.countCharacters());
    }
    @Test
    public void completeFirstRoomEnterThird() {
        quest.addRoom(room1);
        quest.addRoom(room2);
        quest.addRoom(room3);
        quest.addCharacterToParty(knight);
        quest.addCharacterToParty(barbarian);
        quest.addCharacterToParty(rogue);
        quest.addCharacterToParty(cleric);
        quest.beginQuest();
        quest.currentRoomComplete();
        quest.currentRoomComplete();
        assertEquals(0, room1.countCharacters());
        assertEquals(0, room2.countCharacters());
        assertEquals(4, room3.countCharacters());
    }
}

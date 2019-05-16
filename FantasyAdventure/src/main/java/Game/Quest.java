package Game;

import java.util.ArrayList;
import java.util.LinkedList;

public class Quest {

    ArrayList<Character> party;
    LinkedList<Room> rooms;

    public Quest() {
        this.party = new ArrayList<>();
        this.rooms = new LinkedList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void addCharacterToParty(Character character){
        party.add(character);
    }


    public int getPartySize() {
        return party.size();
    }

    public int getRoomsNumber() {
        return rooms.size();
    }

    public void beginQuest(){
        Room firstRoom = rooms.getFirst();

        for (Character character : party){
            if (character.getHealth() != 0){
                firstRoom.enter(character);
            }
        }
    }

    public Room findCurrentRoom(){
        for (Room room : rooms){
            if (room.countCharacters() >0) {
                ArrayList<Character> characters = room.getCharacters();
                for (Character character : characters) {
                    if (character.getHealth() > 0){
                        return room;
                    }
                }

            }
        }
        return rooms.get(0);
    }

    public void currentRoomComplete(){
        Room currentRoom = findCurrentRoom();
        int index = rooms.indexOf(currentRoom);

        if (currentRoom.countEnemiesAlive() == 0) {
            for ( Character character : party) {
                if (character.getHealth()>0){
                    currentRoom.leave(character);
                }
            }
        }

        if (getRoomsNumber() != (index+1)){
            Room nextRoom = rooms.get(index+1);
            for (Character character : party){
               if (character.getHealth() != 0){
                   nextRoom.enter(character);
               }
            }
        } else {
            Room lastRoom = rooms.getLast();
            for (Character character : party){
                if (character.getHealth()!=0){
                    lastRoom.enter(character);
                }
            }
        }
    }
}

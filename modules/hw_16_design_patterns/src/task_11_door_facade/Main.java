package task_11_door_facade;

public class Main {
    public static void main(String[] args) {
        DoorFacade facade = new DoorFacade();

        facade.openDoor();
        facade.closeDoor();
        facade.lockDoor();
        facade.secureDoor();
    }
}

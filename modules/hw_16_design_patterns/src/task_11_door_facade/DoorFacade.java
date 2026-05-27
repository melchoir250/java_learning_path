package task_11_door_facade;

public class DoorFacade {
    private final DoorOpen doorOpen;
    private final DoorClose doorClose;
    private final DoorLock doorLock;

    public DoorFacade() {
        this.doorOpen = new DoorOpen();
        this.doorClose = new DoorClose();
        this.doorLock = new DoorLock();
    }

    public void openDoor() {
        doorOpen.execute();
    }

    public void closeDoor() {
        doorClose.execute();
    }

    public void lockDoor() {
        doorLock.execute();
    }

    public void secureDoor() {
        closeDoor();
        lockDoor();
    }
}

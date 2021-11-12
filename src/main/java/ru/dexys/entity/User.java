package ru.dexys.entity;

public class User {
    public Object id;
    public Object roomId;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getRoomId() {
        return roomId;
    }

    public void setRoomId(Object roomId) {
        this.roomId = roomId;
    }

    public void peek() {
        if (this.getRoomId() == null) {

            System.out.print("{\"userId\":" + this.getId() + "}");
            return;
        }
        System.out.print("{\"userId\":" + this.getId() + ",\"roomId\":" + this.getRoomId() + "}");
    }
}


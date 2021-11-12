package ru.dexys.entity;

public class Room {
    public Object roomId;
    public Object[] userIds;

    public Object getRoomId() {
        return roomId;
    }

    public void setRoomId(Object roomId) {
        this.roomId = roomId;
    }

    public Object[] getUserIds() {
        return userIds;
    }

    public void setUserIds(Object[] userIds) {
        this.userIds = userIds;
    }

    public int sizeUsers() {
        return userIds.length;
    }

    public void peek() {

        System.out.print("{\"roomId\":" + this.getRoomId() + ",\"userIds\":[");
        for (int y = 0; y < this.sizeUsers(); ++y) {
            System.out.print(this.getUserIds()[y]);
            if (y != this.sizeUsers() - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]}");
    }
}

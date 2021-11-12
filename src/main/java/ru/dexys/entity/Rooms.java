package ru.dexys.entity;

public class Rooms {
    public Room[] users;

    public Rooms(Room[] users) {
        this.users = users;
    }

    public void peek() {
        for (int i = 0; i < users.length; ++i) {
            users[i].peek();
            if (i < users.length - 1) {
                System.out.print(",");
            }
        }
    }
}

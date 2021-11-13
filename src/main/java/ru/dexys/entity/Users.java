package ru.dexys.entity;

public class Users {
    public User[] users;

    public Users(User[] users) {
        this.users = users;
    }

    public int count() {
        return users.length;
    }

    public void peek() {
        peek(0, users.length);
    }

    public void peek(int index) {
        peek(index, index);
    }

    public void peek(int start, int end) {
        if (end > users.length) end = users.length;

        for (int i = 0; i < end; ++i) {
            if ((int) users[i].getId() >= start) {
                users[i].peek();
                if (i < users.length - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println();
    }
}

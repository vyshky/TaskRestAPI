package ru.dexys.entity;

public class Users {
    public User[] users;

    public Users(User[] users) {
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

    public void peek(int start, int end) {

        for (int i = 0; i < users.length; ++i) {
            if ((int) users[i].getId() >= start) {
                users[i].peek();
                if (i < users.length - 1) {
                    System.out.print(",");
                }
            }
            if ((int) users[i].getId() == end) {
                return;
            }
        }
    }
}

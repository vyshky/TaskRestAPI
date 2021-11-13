package ru.dexsys;

import org.junit.Assert;
import org.junit.Test;
import ru.dexys.client.impl.ClientAccessSystem;
import ru.dexys.entity.Rooms;
import ru.dexys.entity.Users;

import java.io.IOException;

public class ApplicationTestUser {
    public static final ClientAccessSystem request = new ClientAccessSystem();

    @Test
    public void getRooms() {
        try {
            Rooms rooms = new Rooms(request.getRooms());
            rooms.peek();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getUsers() {
        int startIndex = 4;
        int endIndex = 9;
        try {
            Users users = new Users(request.getUsers());
            users.peek();
            users.peek(5);
            users.peek(startIndex, endIndex);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void checkEntrance() {
        int keyId = 1;
        int roomId = 1;
        String entrance = "ENTRANCE";
        String exit = "EXIT";
        try {
            request.getEntrance(keyId, roomId, entrance);
            request.getEntrance(keyId, roomId, exit);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}

package ru.dexsys;

import org.junit.Assert;
import org.junit.Test;
import ru.dexys.client.impl.ClientAccessSystem;
import ru.dexys.entity.Room;
import ru.dexys.entity.User;

import java.io.IOException;

public class ApplicationTestUser {
    public static final ClientAccessSystem request = new ClientAccessSystem();

    @Test
    public void checkRooms() throws IOException {
        Room rooms = request.getRooms();
    }

    @Test
    public void checkUsers() throws IOException {
        int startIndex = 4;
        int endIndex = 9;
        User user = request.getUsers();
        user.peekUsers(startIndex, endIndex);
    }

    @Test
    public void checkEntrance() throws IOException {
        int id = 2;
        int roomId = 4;
        boolean entrance = true;
        if (roomId % id == 0) {

            int statusCode = request.getEntrance(id, roomId, entrance);

            if (statusCode == 403) {
                Assert.fail("Вы не можете войти в комнату" + "{ id - " + id + " в room - " + roomId + "}" + "\n РАЗРАБОТЧИКУ СРОЧНО ИСПРАВИТЬ");
            }
            if (statusCode == 500) {
                Assert.fail("Порочие ошибки");
            }
        } else {
            Assert.fail("Вход запрещен! id - " + id + " и roomId - " + roomId);
        }
    }
}

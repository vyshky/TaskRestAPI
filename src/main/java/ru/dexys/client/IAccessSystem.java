package ru.dexys.client;

import ru.dexys.entity.Entrance;
import ru.dexys.entity.Go;
import ru.dexys.entity.Room;
import ru.dexys.entity.User;

import java.io.IOException;

public interface IAccessSystem {
    Room[] getRooms() throws IOException;

    User[] getUsers() throws IOException;

    void getEntrance(int userId, int roomId, String entrance) throws IOException;
}

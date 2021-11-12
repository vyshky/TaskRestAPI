package ru.dexys.client.impl;

import io.restassured.RestAssured;
import ru.dexys.client.IAccessSystem;
import ru.dexys.entity.Room;
import ru.dexys.entity.User;

import java.io.IOException;

public class ClientAccessSystem implements IAccessSystem {
    private static final String BASE_URL = "http://localhost:8080";

    @Override
    public Room[] getRooms() throws IOException {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .request("GET", "/info/rooms")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(Room[].class);
    }

    @Override
    public User[] getUsers() throws IOException {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .request("GET", "/info/users")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(User[].class);
    }

    public int getEntrance(int id, int roomId, boolean entrance) {
        String ENTRANCE = null;
        if (entrance) {
            ENTRANCE = "ENTRANCE";
        } else {
            ENTRANCE = "EXIT";
        }
        return RestAssured.given()
                .baseUri(BASE_URL)
                .get("/check?entrance=" + ENTRANCE + "&keyId=" + id + "&roomId=" + roomId)
                .prettyPeek()
                .thenReturn()
                .statusCode();
    }

}

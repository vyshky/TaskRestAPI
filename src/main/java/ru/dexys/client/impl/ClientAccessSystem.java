package ru.dexys.client.impl;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import ru.dexys.client.IAccessSystem;
import ru.dexys.entity.Room;
import ru.dexys.entity.User;

import java.io.IOException;

public class ClientAccessSystem implements IAccessSystem {
    private static final String BASE_URL = "http://localhost:8080";

    @Override
    public Room getRooms() throws IOException {
        var json = RestAssured.given()
                .baseUri(BASE_URL)
                .request("GET", "/info/rooms")
                .prettyPrint();
        return new Room(json).deserialization();
    }

    @Override
    public User getUsers() throws IOException {
        var json = RestAssured.given()
                .baseUri(BASE_URL)
                .get("info/users")
                .prettyPrint();
        return new User(json).deserialization();
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

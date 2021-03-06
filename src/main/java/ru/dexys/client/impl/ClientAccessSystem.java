package ru.dexys.client.impl;

import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.internal.assertion.Assertion;
import org.hamcrest.Matcher;
import ru.dexys.client.IAccessSystem;
import ru.dexys.entity.EndPoint;
import ru.dexys.entity.Entrance;
import ru.dexys.entity.Room;
import ru.dexys.entity.User;

import java.io.IOException;
import java.lang.module.Configuration;
import java.util.SortedMap;

public class ClientAccessSystem implements IAccessSystem {
    private static final String BASE_URL = "http://localhost:8080";

    @Override
    public Room[] getRooms() throws IOException {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .get(EndPoint.rooms)
                .peek()
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(Room[].class);
    }

    @Override
    public User[] getUsers() throws IOException {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .get(EndPoint.users)
                .peek()
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .as(User[].class);
    }

    public void getEntrance(int keyId, int roomId, String entrance) throws IOException {
        RestAssured.given()
                .baseUri(BASE_URL)
                .get(EndPoint.checkEntrance, entrance, keyId, roomId)
                .peek()
                .then()
                .statusCode(200)
                .and()
                .extract()
                .body();
    }

}

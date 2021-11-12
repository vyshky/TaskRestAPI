package ru.dexys.entity;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class Room {
    HashMap<Integer, ArrayList> rooms = new HashMap<Integer, ArrayList>();
    public int userIds;
    public int roomId;
    private JsonParser jsonParser;
    public String json;
    private Map<String, Object> nextObject;

    public Room(String json) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final JsonFactory jsonFactory = objectMapper.getFactory();
        this.jsonParser = jsonFactory.createParser(json);
        this.json = json;
    }

    public Room deserialization() throws IOException {
        JsonToken arrayStartToken = this.jsonParser.nextToken();

        if (arrayStartToken != JsonToken.START_ARRAY)   // Проверяем есть ли начало массива начальнай ТОКЕН
            throw new RuntimeException("There was a problem initializing the first element of the Json Structure: ");

        // Перебираем все объекты
        while (!jsonParser.isClosed()) {
            boolean flagId = false;
            boolean flagRoomId = false;
            // Перебираем 1 Обект в for
            for (JsonToken nextToken = this.jsonParser.nextToken(); nextToken != JsonToken.END_OBJECT && nextToken != null; nextToken = this.jsonParser.nextToken()) {

                // Ищем value и записываем в id или roomId
                if (nextToken == JsonToken.VALUE_NUMBER_INT) {
                    if (jsonParser.getCurrentName() == "userIds") {
                        flagId = true;
                        userIds = Integer.parseInt(jsonParser.getValueAsString());
                    }
                    if (jsonParser.getCurrentName() == "roomId") {
                        flagRoomId = true;
                        roomId = Integer.parseInt(jsonParser.getValueAsString());
                    }
                }
            }
            if (flagId && flagRoomId) {
                // TODO  : записать в массив значение
                System.out.println("id = " + userIds + " roomId = " + roomId);
            }
        }
        return this;
    }


    public Room des() throws IOException {
        JsonFactory factory = new JsonFactory();
        JsonParser jsonParser = factory.createParser(json);
        final JsonToken arrayStartToken = jsonParser.nextToken();

        if (arrayStartToken != JsonToken.START_ARRAY) {

        }

        return this;
    }

    public HashMap<Integer, ArrayList> getRoom() throws IOException {
        if (rooms.size() == 0) this.deserialization();
        return rooms;
    }

    public void printRoom() {
        for (int i = 1; i <= rooms.size(); ++i) {
            System.out.println("В комнате " + i + " находятся юзеры " + rooms.get(i));
        }
    }
}

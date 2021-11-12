package ru.dexys.entity;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class User {
    HashMap<Integer, Integer> users = new HashMap<Integer, Integer>();
    public int id;
    public int roomId;
    private JsonParser jsonParser;


    public User(String json) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final JsonFactory jsonFactory = objectMapper.getFactory();
        this.jsonParser = jsonFactory.createParser(json);
    }

    public void peekUsers(int startIndex, int endIndex) {
        if (endIndex >= users.size()) return;
        for (int i = startIndex; i < endIndex; ++i) {
            System.out.println("id = " + i + " roomId = " + users.get(i));
        }
    }

    public User deserialization() throws IOException {
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
                    if (jsonParser.getCurrentName() == "id") {
                        flagId = true;
                        id = Integer.parseInt(jsonParser.getValueAsString());
                    }
                    if (jsonParser.getCurrentName() == "roomId") {
                        flagRoomId = true;
                        roomId = Integer.parseInt(jsonParser.getValueAsString());
                    }
                }
            }
            if (flagId && flagRoomId) {
                users.put(id, roomId);
            } else if (flagId && !flagRoomId) {
                users.put(id, null);
            }
        }
        return this;
    }
}


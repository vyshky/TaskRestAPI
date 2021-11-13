package ru.dexsys.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import ru.dexys.client.impl.ClientAccessSystem;
import ru.dexys.entity.Rooms;
import ru.dexys.entity.Users;

import java.io.IOException;

@CucumberOptions
        (
                features = "src/test/resources",
                glue = "ru/dexsys/steps",
                plugin = "pretty"
        )
@RunWith(Cucumber.class)
public class TestRunner {
    public static final ClientAccessSystem request = new ClientAccessSystem();
    public static int usersCount;

    @Given("^I ask you to give me back the room numbers$")
    public void getRooms() {
        try {
            Rooms rooms = new Rooms(request.getRooms());
            rooms.peek();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Given("^I ask you to give me back the users. start = (\\d+) end = (\\d+)$")
    public void getUsers(int startIndex, int endIndex) {
        try {
            Users users = new Users(request.getUsers());
            usersCount = users.count();
            users.peek(startIndex, endIndex);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }


    @Given("^I check to enter the room. userId = (\\d+) maxRoom = (\\d+)$")
    public void checkEntrance(int keyId, int maxRoom) {
        String entrance = "ENTRANCE";
        try {
            for (int y = 1; y <= maxRoom; ++y) {
                if (y % keyId == 0) {
                    request.getEntrance(keyId, y, entrance);
                    checkExit(keyId, y);
                }
            }
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("^I leave the room. id = (\\d+) roomId = (\\d+)$")
    public void checkExit(int keyId, int roomId) {
        String exit = "EXIT";
        try {
            request.getEntrance(keyId, roomId, exit);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

}

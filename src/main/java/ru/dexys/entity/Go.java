package ru.dexys.entity;

public enum Go {
    IN("ENTRANCE"),
    OUT("EXIT");

    private String title;

    Go(String entrance) {
        this.title = title;
    }

    public String getIn() {
        return in.title;
    }

    public String getOut() {
        return out.title;
    }
}

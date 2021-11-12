package ru.dexys.entity;

public enum Go {
    in("ENTRANCE"),
    out("EXIT");

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

package pl.jdomanski.bgames.ships;

public enum Message {
    MISSED("Missed!"),
    HIT("Hit!"),
    SUNK("Sunk!");

    private String body;

    Message(String body) {
        this.body = body;
    }

    public String getBody(){
        return this.body;
    }
}

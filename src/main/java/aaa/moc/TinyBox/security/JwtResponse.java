package aaa.moc.TinyBox.security;

import aaa.moc.TinyBox.domain.Actor;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 271366438598748037L;
    private final String jwttoken;
    private final Actor actor;

    public JwtResponse(String jwttoken, Actor actor) {
        this.jwttoken = jwttoken;
        this.actor = actor;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public Actor getActor() {
        return this.actor;
    }
}
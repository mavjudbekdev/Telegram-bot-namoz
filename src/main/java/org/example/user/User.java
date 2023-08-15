package org.example.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String id;
    private UserState userState;
    private boolean bomdod = true;
    private boolean peshin = true;
    private boolean asr = true;
    private boolean shom = true;
    private boolean xufton = true;

    public User(String id, UserState userState) {
        this.id = id;
        this.userState = userState;
    }
}

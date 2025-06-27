package ca.sheridancollege.bibek.beans;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class player {
    public int id;
    public String name;
    public String position;
    public int age;
    public String team;
    public String country;
    public String email;
    public String phone;
}

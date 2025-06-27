package ca.sheridancollege.datavbase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.bibek.beans.player;

@Repository
public class DatabaseAccess {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addPlayer(player player) {
        String sql = "INSERT INTO player (name, position, age, team, country, email, phone)" +
                "VALUES (:name, :position, :age, :team, :country, :email, :phone)";

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(player);
        jdbc.update(sql, params);

    }

    public List<player> getPlayers() {
        String sql = "SELECT * FROM player";
        List<player> players = jdbc.query(sql, new BeanPropertyRowMapper<>(player.class));
        return players;
    }

    public player getPlayerById(int id) {
        String sql = "SELECT * FROM player WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject(sql, params, new BeanPropertyRowMapper<>(player.class));
    }

    public void updatePlayer(player player) {
        String sql = "UPDATE player SET name = :name, position = :position, age = :age, " +
                "team = :team, country = :country, email = :email, phone = :phone " +
                "WHERE id = :id";

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(player);
        jdbc.update(sql, params);
    }

    public void deletePlayer(int id) {
        String sql = "DELETE FROM player WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbc.update(sql, params);
    }

    // public List<player> getPlayers() {
    // String sql = "SELECT * FROM player";
    // List<player> players = jdbc.query(sql, new
    // BeanPropertyRowMapper<>(player.class));
    // return players;

}

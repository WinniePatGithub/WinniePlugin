package me.winniepat.winnieplugin.Utils.Database;

import org.bukkit.entity.Player;

import java.sql.*;

public class PointsDatabase {

    private final Connection connection;

    public PointsDatabase(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        try(Statement statement = connection.createStatement();) {
            statement.execute("""
                CREATE TABLE IF NOT EXISTS players (
                uuid TEXT PRIMARY KEY,
                username TEXT NOT NULL,
                points INTEGER NOT NULL DEFAULT 0)
        """);
        }

    }

    public void closeConnection() throws SQLException {
        if(connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void addPlayer(Player p) throws SQLException{
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players (uuid, username) VALUES) (?, ?)")){
            preparedStatement.setString(1, p.getUniqueId().toString());
            preparedStatement.setString(2, p.getDisplayName());
            preparedStatement.executeUpdate();
        }
    }

    public boolean playerExists(Player player) throws SQLException {
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM players WHERE uuid = ?")) {
            preparedStatement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    public void updatePlayerPoints(Player player, int points) throws SQLException {
        if(!playerExists(player)) {
            addPlayer(player);
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE players SET points = ? WHERE uuid = ?")) {
            preparedStatement.setInt(1, points);
            preparedStatement.setString(2, player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        }
    }

    public int getPlayerPoints(Player player) throws SQLException{
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT points FROM players WHERE uuid = ?")) {
            preparedStatement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("points");
            }else {
                return 0;
            }
        }
    }

}

package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database
{
    private static Database instance;
    private Connection connection;
    private final String url = "jdbc:sqlite:pokedex.sqlite";

    private Database() throws Exception {
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connesso al database SQLite");
        } catch (Exception e) {
            throw new Exception("Errore di connessione al database: " + e.getMessage());
        }
    }

    public static Database getInstance() throws Exception {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private boolean isConnectionValid() {
        try {
            return connection != null && connection.isValid(5);
        } catch (Exception e) {
            return false;
        }
    }

    // GESTIONE POKéMON
    public void addPokemon(Pokemon p) throws Exception
    {
        if (!isConnectionValid())
        {
            throw new Exception("Il database non è raggiungibile");
        }

        String query = "INSERT INTO Pokemon(index, nome, tipo1, tipo2, HP, abilità) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, p.index);
            statement.setString(2, p.nome);
            statement.setString(3, p.tipo1);
            statement.setString(4, p.tipo2);
            statement.setInt(5, p.HP);
            statement.setString(6, p.abilita);

            statement.executeUpdate();
        }
        catch (Exception e)
        {
            throw new Exception("Errore inserimento pokémon: " + e.getMessage());
        }
    }

}
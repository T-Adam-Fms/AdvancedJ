//Exercice 6 : Allons plus loin en permettant uniquement aux utilisateurs en base d’avoir 
//accès à notre boutique. Pour ce faire, vous devez ajouter une classe Utilisateur et son 
//homologue en base dont voici le contenu :


package dao;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    // Method to validate user login
    public boolean validateUser(String login, String password) {
        String sql = "SELECT * FROM T_Users WHERE Login = ? AND Password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();  // Return true if user exists
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
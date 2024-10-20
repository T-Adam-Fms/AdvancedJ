//Exercice 6 : Allons plus loin en permettant uniquement aux utilisateurs en base d’avoir 
//accès à notre boutique. Pour ce faire, vous devez ajouter une classe Utilisateur et son 
//homologue en base dont voici le contenu :




package test;

import dao.UserDao;
import entities.Article;
import util.DatabaseConfig;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise6Jdbc {
    public static void main(String[] args) {
        // Create an instance of DatabaseConfig to manage the connection
        DatabaseConfig dbConfig = new DatabaseConfig();

        try (Connection connection = dbConfig.getConnection()) {
            if (connection != null) {
                // Create an instance of UserDao for user validation
                UserDao userDao = new UserDao(connection);

                // Get user login credentials
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter login: ");
                String login = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                // Validate user login
                if (userDao.validateUser(login, password)) {
                    System.out.println("Login successful!");

                    // Perform database operations if login is valid
                    // Assuming you have implemented methods for Article operations
                    insertArticle(connection, new Article(0, "Smartwatch", "Apple", 299.99));
                    ArrayList<Article> articles = selectAllArticles(connection);
                    printArticles(articles);
                } else {
                    System.out.println("Login failed! Invalid credentials.");
                }
            } else {
                System.out.println("Failed to establish a database connection.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Assuming you have the following methods defined elsewhere in your code:
    public static void insertArticle(Connection connection, Article article) {
        // Implement the method to insert an article into the database
    }

    public static ArrayList<Article> selectAllArticles(Connection connection) {
        // Implement the method to retrieve all articles from the database
        return new ArrayList<>(); // Return an empty list for now
    }

    public static void printArticles(ArrayList<Article> articles) {
        // Implement the method to print articles
    }
}

package com.zemoga.portfolio.DAO;

import com.zemoga.portfolio.model.Portfolio;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.util.Optional;

public class PortfolioDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public PortfolioDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected Try<Boolean> connect() {
            return Try.of( () -> {
                Class.forName("com.mysql.jdbc.Driver");
                DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
                jdbcConnection = DriverManager.getConnection(
                        jdbcURL, jdbcUsername, jdbcPassword);
                return true;
            });
    }

    protected Try<Boolean> disconnect() {
        return Try.of( () -> {
            jdbcConnection.close();
            return true;
        });

    }

    public Option<ArrayList<Portfolio>> getAllPortfolios() {
        String sqlQuery = "SELECT * FROM zemoga_test_db.portfolio";
        Try<ArrayList<Portfolio>> tryPortfolios = connect()
                .flatMap( value -> Try.of( () -> {
                    ArrayList<Portfolio> portfolios = new ArrayList<>();
                    Statement statement = jdbcConnection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sqlQuery);

                    while (resultSet.next()) {
                        int idPortfolio = resultSet.getInt("IDPORTFOLIO");
                        String description = resultSet.getString("DESCRIPTION");
                        String imageUrl = resultSet.getString("IMAGE_URL");
                        String title = resultSet.getString("TITLE");
                        String twitterUserName = resultSet.getString("TWITTER_USER_NAME");

                        Portfolio portfolio = new Portfolio(idPortfolio, description, imageUrl, title,twitterUserName);
                        portfolios.add(portfolio);
                    }

                    resultSet.close();
                    statement.close();
                    return portfolios;
                }));
        if( tryPortfolios.isSuccess()) {
            Try.of(this::disconnect);
        }
        return tryPortfolios.toOption();
    }
}

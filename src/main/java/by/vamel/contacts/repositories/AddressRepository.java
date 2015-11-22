package by.vamel.contacts.repositories;

import by.vamel.contacts.entities.Address;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressRepository {
    private final DataSource dataSource;

    public AddressRepository() {
        try {
            Context context = new InitialContext();
            try {
                dataSource = (DataSource) context.lookup("java:comp/env/jdbc/trainingdb");
            } finally {
                context.close();
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() {
        try {
            Connection connection = dataSource.getConnection();
            try {
                Statement statement = connection.createStatement();
                try {
                    statement.execute("create table address (id INTEGER NOT NULL )");
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Address address) {

    }

    public void delete(Address address) {

    }

    public Address find(long id) {
        try {
            Connection connection = dataSource.getConnection();
            try {
                Statement statement = connection.createStatement();
                try {
                    ResultSet resultSet = statement.executeQuery("select * from address where id = " + id);
                    try {
                        if(!resultSet.next()) {
                            return null;
                        } else {
                            return unmarshal(resultSet);
                        }
                    } finally {
                        resultSet.close();
                    }
                } finally {
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Address unmarshal(ResultSet resultSet) {
        Address address = new Address();
        try {
            address.setId(resultSet.getLong("id"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }
}

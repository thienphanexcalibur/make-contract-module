package model;

import model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDAO {

    public ClientDAO() {

    }

    public ArrayList<Client> getClients() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();

        String sql = "SELECT * from client";
        Statement statement = getStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            clients.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }
        rs.close();
        cleanEnvironment(statement, null);
        return clients;
    }

    public Client getClient(int clientID) throws SQLException {
        Client client = null;
        String sql = "SELECT * from client WHERE id=?";
        PreparedStatement ps = getPreparedStatement(sql);
        ps.setInt(1, clientID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            client = new Client(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(9));
        }
        rs.close();
        cleanEnvironment(null, ps);
        return client;
    }

    public int deleteClient(int clientID) throws SQLException {
        String sql = "DELETE FROM client where ID=" + Integer.toString(clientID);
        PreparedStatement ps = getPreparedStatement(sql);
        int result = ps.executeUpdate();
        cleanEnvironment(null, ps);
        return result;
    }
}

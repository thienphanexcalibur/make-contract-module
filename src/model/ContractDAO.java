package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContractDAO extends BaseDAO {

    public ContractDAO() {
    }

    /**
     *
     * @param clientID
     * @param startDate
     * @param endDate String
     * @param collateral Collateral
     * @param deposit Deposit
     * @param vehicleID
     * @return
     */
    public int createContract(int clientID, String startDate, String endDate, Collateral collateral, Deposit deposit, int vehicleID) {
        String contractQuery = "INSERT INTO contract(ClientID, Start_date, Finish_date) VALUES (?,?,?);";
        String collateralQuery = "INSERT INTO collateral(ContractID, Name, Value) VALUES (?, ?, ?);";
        String depositQuery = "INSERT INTO deposit(ContractID, amount) VALUES (?, ?)";
        String rentVehicleQuery = "INSERT INTO rentvehicle(ContractID, VehicleID, ClientID) VALUES (?,?,?)";

        try {
            PreparedStatement ps = getPreparedStatement(contractQuery);
            ps.setInt(1, clientID);
            ps.setString(2, startDate);
            ps.setString(3, endDate);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                ResultSet generatedKey = ps.getGeneratedKeys();
                if (generatedKey.next()) {
                    int key = generatedKey.getInt(1);

                    PreparedStatement ps1 = getPreparedStatement(collateralQuery);
                    ps1.setInt(1, key);
                    ps1.setString(2, collateral.getName());
                    ps1.setFloat(3, collateral.getValue());
                    ps1.executeUpdate();

                    PreparedStatement ps2 = getPreparedStatement(depositQuery);
                    ps2.setInt(1, key);
                    ps2.setFloat(2, deposit.getAmount());
                    ps2.executeUpdate();

                    PreparedStatement ps3 = getPreparedStatement(rentVehicleQuery);
                    ps3.setInt(1, key);
                    ps3.setInt(2, vehicleID);
                    ps3.setInt(3, clientID);
                    ps3.executeUpdate();

                    generatedKey.close();
                    return 1;
                }
            }
            cleanEnvironment(null, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Vehicle> getVehicles() throws SQLException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * from vehicle";
        Statement statement = getStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            vehicles.add(new Vehicle(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6)));
        }
        System.out.println(vehicles);
        cleanEnvironment(statement, null);
        rs.close();
        return vehicles;
    }
}

package com.bd1.m3.service;

import com.bd1.m3.config.DatabaseConfig;
import com.bd1.m3.service.dto.UnitDTO;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class UnitService {

    public void createUnit(UnitDTO unit) {
        Connection c = DatabaseConfig.getConnection();
        try{
            CallableStatement callProcedure = c.prepareCall("{call InsertUnit(?, ?, ?)}");
            callProcedure.setLong(1, unit.getUnitFloor());
            callProcedure.setLong(2, unit.getUnitNumber());
            callProcedure.setString(3, unit.getBlock());

            callProcedure.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error when connecting to database.", e);
        }
    }
}

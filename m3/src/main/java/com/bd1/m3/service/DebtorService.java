package com.bd1.m3.service;

import com.bd1.m3.config.DatabaseConfig;
import com.bd1.m3.service.dto.DebtorDTO;
import com.bd1.m3.service.dto.UnitDTO;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class DebtorService {

    public void createDebtor(DebtorDTO debtorDTO) {
        Connection c = DatabaseConfig.getConnection();
        try{
            CallableStatement callProcedure = c.prepareCall("{call InsertDebtor(?, ?, ?, ?)}");
            callProcedure.setString(1, debtorDTO.getDebtorName());
            callProcedure.setString(2, debtorDTO.getMail());
            callProcedure.setLong(3, debtorDTO.getPhone());
            callProcedure.setLong(4, debtorDTO.getDocumentNumber());

            callProcedure.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error when connecting to database.", e);
        }
    }
}

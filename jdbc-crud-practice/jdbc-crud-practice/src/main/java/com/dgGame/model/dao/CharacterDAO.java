package com.dgGame.model.dao;

import com.dgGame.model.dto.CharacterDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.dgGame.common.JDBCTemplate.close;

public class CharacterDAO {

    private Properties prop = new Properties();

    public CharacterDAO () {

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/dgGame/mapper/character-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectMaxLevelCharacter(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        int maxLevelCharacter = 0;

        String query = prop.getProperty("selectMaxLevelCharacter");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                maxLevelCharacter = rset.getInt("MAX(A.CHARACTER_LEVEL)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return maxLevelCharacter;
    }

    public List<CharacterDTO> selectAllCharacterList(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        CharacterDTO selectedChar = null;
        List<CharacterDTO> charList = null;

        String query = prop.getProperty("selectAllCharacterList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            charList = new ArrayList<>();

            while (rset.next()) {

                selectedChar = new CharacterDTO();

                selectedChar.setName(rset.getString("CHARACTER_NAME"));
                selectedChar.setLevel(rset.getInt("CHARACTER_LEVEL"));
                selectedChar.setHp(rset.getInt("CHARACTER_HP"));
                selectedChar.setApoint(rset.getInt("CHARACTER_APOINT"));
                selectedChar.setDpoint(rset.getInt("CHARACTER_DPOINT"));
                selectedChar.setTapoint(rset.getInt("CHARACTER_TAPOINT"));
                selectedChar.setTdpoint(rset.getInt("CHARACTER_TDPOINT"));
                selectedChar.setJobid(rset.getString("JOB_ID"));

                charList.add(selectedChar);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return charList;
    }


}

package com.dgGame.run;

import com.dgGame.model.dao.CharacterDAO;
import com.dgGame.model.dto.CharacterDTO;

import java.sql.Connection;
import java.util.List;

import static com.dgGame.common.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        Connection con = getConnection();
        CharacterDAO registDAO = new CharacterDAO();

        // 1. 캐릭터 최고 레벨 조회
        int maxLevelCharacter = registDAO.selectMaxLevelCharacter(con);

        System.out.println("maxLevelCharacter = " + maxLevelCharacter);

        // 2. 전체 캐릭터 정보 조회
        List<CharacterDTO> charList = registDAO.selectAllCharacterList(con);

        for(CharacterDTO allList : charList) {
            System.out.println("allList = " + allList);
        }

        // 3. 캐릭터 공격력 수정
    }
}

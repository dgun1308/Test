package com.dgGame.run;

import com.dgGame.model.dao.CharacterDAO;
import com.dgGame.model.dto.CharacterDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static com.dgGame.common.JDBCTemplate.close;
import static com.dgGame.common.JDBCTemplate.getConnection;

public class ReadApplication {

    public static void main(String[] args) {

        Connection con = getConnection();
        CharacterDAO registDAO = new CharacterDAO();
        Scanner sc = new Scanner(System.in);

        // 1. 캐릭터 정보 조회(직업 연결)
        System.out.print("조회할 캐릭터명을 입력해주세요 : ");
        String charName = sc.nextLine();

        CharacterDTO selChar = registDAO.selectCharacterInfo(charName, con);
        System.out.println("selChar = " + selChar);

        // 2. 전체 캐릭터 정보 조회(직업 연결)
        List<CharacterDTO> charList = registDAO.selectAllCharacterList(con);

        for(CharacterDTO allList : charList) {
            System.out.println("allList = " + allList);
        }

        close(con);
    }
}

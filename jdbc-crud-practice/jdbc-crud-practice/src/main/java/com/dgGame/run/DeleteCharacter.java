package com.dgGame.run;

import com.dgGame.model.dao.CharacterDAO;
import com.dgGame.model.dto.CharacterDTO;

import java.sql.Connection;
import java.util.Scanner;

import static com.dgGame.common.JDBCTemplate.close;
import static com.dgGame.common.JDBCTemplate.getConnection;

public class DeleteCharacter {

    public static void main(String[] args) {

        Connection con = getConnection();
        CharacterDAO registDAO = new CharacterDAO();

        Scanner sc = new Scanner(System.in);

        // 5. 캐릭터 삭제
        // 5-1. 삭제할 캐릭터명 입력
        System.out.print("삭제할 캐릭터명을 입력하세요 : ");
        String delCharacterName = sc.nextLine();

        // 5-2. 삭제할 캐릭터명 저장
        CharacterDTO delChar = new CharacterDTO();
        delChar.setName(delCharacterName);

        // 5-3. 메소드 호출 후 해당 캐릭터 삭제
        int result2 = registDAO.deleteCharacter(delChar, con);

        if(result2 > 0) {
            System.out.println("\'" + delCharacterName + "\'" + " 캐릭터 삭제 완료");
        } else {
            System.out.println("\'" + delCharacterName + "\'" + " 캐릭터 삭제 실패");
        }

        close(con);
    }
}

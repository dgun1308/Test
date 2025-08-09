package com.dgGame.run;

import com.dgGame.model.dao.CharacterDAO;
import com.dgGame.model.dto.CharacterDTO;

import java.sql.Connection;
import java.util.Scanner;

import static com.dgGame.common.JDBCTemplate.close;
import static com.dgGame.common.JDBCTemplate.getConnection;

public class CharApointUpdate {

    public static void main(String[] args) {

        Connection con = getConnection();
        CharacterDAO registDAO = new CharacterDAO();

        // 3. 캐릭터 공격력 수정
        // 3-1. 공격력을 수정할 캐릭터 선택 및 수정값 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("공격력을 수정할 캐릭터명을 입력하세요 : ");
        String characterName = sc.nextLine();
        System.out.print("수정할 공격력 수치를 입력하세요 : ");
        int characterApoint = sc.nextInt();
        sc.nextLine();

        // 3-2. 해당 캐릭터 공격력 수정 값 저장
        CharacterDTO udtChar = new CharacterDTO();
        udtChar.setName(characterName);
        udtChar.setApoint(characterApoint);

        // 3-3. 해당 캐릭터 공격력 수정을 위한 메소드 호출 후 등록
        int result = registDAO.updateCharacterApoint(udtChar, con);

        if(result >0) {
            System.out.println(characterName + " 공격력 수정 성공!");
        } else {
            System.out.println("공격력 수정 실패!");
        }

        close(con);
    }
}

package com.dgGame.run;

import com.dgGame.model.dao.CharacterDAO;
import com.dgGame.model.dto.CharacterDTO;

import java.sql.Connection;
import java.util.Scanner;

import static com.dgGame.common.JDBCTemplate.close;
import static com.dgGame.common.JDBCTemplate.getConnection;

public class InsertNewCharacter {

    public static void main(String[] args) {

        Connection con = getConnection();
        CharacterDAO registDAO = new CharacterDAO();

        Scanner sc = new Scanner(System.in);

        // 4. 신규 캐릭터 등록
        // 4-1. 신규 캐릭터 등록을 위한 정보 입력
        System.out.print("등록할 캐릭터명을 입력하세요 : ");
        String newCharacterName = sc.nextLine();
        System.out.print("등록할 캐릭터의 레벨을 입력하세요 : ");
        int newCharacterLevel = sc.nextInt();
        System.out.print("등록할 캐릭터의 체력을 입력하세요 : ");
        int newCharacterHp = sc.nextInt();
        System.out.print("등록할 캐릭터의 공격력을 입력하세요 : ");
        int newCharacterApoint = sc.nextInt();
        System.out.print("등록할 캐릭터의 방어력을 입력하세요 : ");
        int newCharacterDpoint = sc.nextInt();
        System.out.print("등록할 캐릭터의 직업을 입력하세요(전사, 궁수, 마법사) : ");
        sc.nextLine();
        String newCharacterJob = sc.nextLine();

        // 4-2. 신규 캐릭터 등록을 위한 값 가공
        String jobId = "";
        switch (newCharacterJob) {
            case "전사" : jobId = "w1"; break;
            case "궁수" : jobId = "a1"; break;
            case "마법사" : jobId = "m1"; break;
        }

        // 4-3. 신규 캐릭터 정보 저장
        CharacterDTO newChar = new CharacterDTO();
        newChar.setName(newCharacterName);
        newChar.setLevel(newCharacterLevel);
        newChar.setHp(newCharacterHp);
        newChar.setApoint(newCharacterApoint);
        newChar.setDpoint(newCharacterDpoint);
        newChar.setJobName(jobId);

        // 4-4. 신규 캐릭터 등록을 위한 메소드 호출 후 등록
        int result = registDAO.insertNewCharacter(newChar, con);

        if(result > 0) {
            System.out.println("\'" + newCharacterName + "\'" + " 캐릭터 등록 완료");
        } else {
            System.out.println("\'" + newCharacterName + "\'" + " 캐릭터 등록 실패");
        }

        close(con);
    }
}

package com.dgGame.run;

import com.dgGame.model.dao.CharacterDAO;
import com.dgGame.model.dto.CharacterDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static com.dgGame.common.JDBCTemplate.close;
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
        newChar.setJobid(jobId);

        // 4-4. 신규 캐릭터 등록을 위한 메소드 호출 후 등록
        int result1 = registDAO.insertNewCharacter(newChar, con);

        if(result1 > 0) {
            System.out.println("신규 캐릭터 등록 완료");
        } else {
            System.out.println("신규 캐릭터 등록 실패");
        }

        close(con);
    }
}

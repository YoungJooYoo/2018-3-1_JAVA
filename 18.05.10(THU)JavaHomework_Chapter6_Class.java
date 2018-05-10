/*
 * 작성자 정보: 2016101453 컴퓨터학부 유영주
 * 목적 및 개요: 3-1학기 JAVA 과제  <객제치향 프로그래밍 과제 NO.3 프로그램 A타입>
 * 과제수행날짜: 2018.05.09(수)
 * 프로그램 특징: 교재 제 6장 객체지향 개념 적용하기 
 * 사용언어: JAVA
 * 프로그램 작성환경 및 실행환경:
 *   OS: OSX High Sierra 10.13.4
 *   실행: OSX Terminal
 *   JAVA version: 9.0.1
 */

import java.util.Scanner;

public class MemberExample {
    public static void main(String[] args){

        String fieldName;
        String fieldId;
        String fieldPassword;
        int fieldAge;

        Member user1 = new Member("성춘향");
        Member user2 = new Member("홍길동", "hong");
        Member user3 = new Member("류관순","ryu", "1234");
        Member user4 = new Member("변학도","byun", "5678",25);

        System.out.println("필드값 키보드로 입력 받기 전 출력");
        user1.displyMember();
        System.out.println("");
        user2.displyMember();
        System.out.println("");
        user3.displyMember();
        System.out.println("");
        user4.displyMember();

        System.out.println("");
        System.out.println("user1 필드값을 채워넣어 주세요");
        System.out.print("user1 id를 입력하세요 : ");
        Scanner scanId = new Scanner(System.in);
        fieldId = scanId.nextLine();
        user1.id = fieldId;
        System.out.print("user1 password를 입력하세요 : ");
        Scanner scanPassword = new Scanner(System.in);
        fieldPassword = scanPassword.nextLine();
        user1.password = fieldPassword;
        System.out.print("user1 age를 입력하세요 : ");
        Scanner scanAge = new Scanner(System.in);
        fieldAge = scanAge.nextInt();
        user1.age = fieldAge;
        System.out.println("");

        System.out.println("user2 필드값을 채워넣어 주세요");
        System.out.print("user2 password를 입력하세요 : ");
        fieldPassword = scanPassword.nextLine();
        user2.password = fieldPassword;
        System.out.print("user2 age를 입력하세요 : ");
        fieldAge = scanAge.nextInt();
        user2.age = fieldAge;
        System.out.println("");


        System.out.println("user3 필드값을 채워넣어 주세요");
        System.out.print("user3 age를 입력하세요 : ");
        fieldAge = scanAge.nextInt();
        user3.age = fieldAge;

        //입력 값 받은후 다시 출력
        System.out.println("필드값 키보드로 입력 받은 후 출력 ");
        user1.displyMember();
        System.out.println("");
        user2.displyMember();
        System.out.println("");
        user3.displyMember();
        System.out.println("");
        user4.displyMember();
    } /* end main */
} /* end class MemberExample */


public class Member {
    String name;
    String id;
    String password;
    int age;

    //생성자 오버라이드 시작.
    public Member(String name){
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
    }

    public Member(String name, String id){
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
    }

    public Member(String name, String id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
    }

    public Member(String name, String id,String password, int age){
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
    }

    void displyMember(){
        System.out.println("Member 클래스의 Field 값");
        System.out.println("name: " + name);
        System.out.println("id: " + id);
        System.out.println("password: " + password);
        System.out.println("age: " + age);
    }
}


/*
 * 작성자 정보 : 2016101453 컴퓨터학부 유영주
 * 목적 및 개요:  3-1학기  Java과제  <Calculate_Grade_of_Students>
 * 과제수행날짜: 2018.03.23(금) 작성시작 -> 2018.03.27(화) 작성완료
 * 프로그램 특징: JAVA로 성적산출 프로그램 구현
 * 사용언어: JAVA
 * 프로그램 작성환경 및 실행환경:
 *   OS: OSX High Sierra 10.13.3
 *   실행: OSX Terminal
 *   JAVA version: 9.0.1
 */



/*
 * 주의사항: 1.배열 사용금지.
 *         2.System.in.read(),skip,nextLine, nextlnt 함수를 사용할 것.
 *         3.성적산출시 if, switch 각 1번씩 사용할 것.
 */



/*
 * 본 프로그램은 다음과 같은 규칙을 준수한다.
 * 1. 헝가리안 표기법을 이용해 변수명을 지정했다.
 *    이유는 IDE를 쓰지 않고, 터미널 vim을 이용하기 때문에 변수 타입 혼동을 막기 위함이다.
 * 2. 변수의 타입의 명확성을 위해 타입+변수명으로 변수 이름을 지정한다
 *    int Num;  ->  int iNum;
 * 3. N명을 5명으로 정하고 진행했다.
 *
 */


import java.io.IOException;
import java.util.Scanner;


public class Calculate_Grade_of_Students {
    public static  void main (String[] args) throws IOException {

        // 이름을 입력받을 학생이름 문자열 객체참조 변수 선언
        String strStudent_Name1;
        String strStudent_Name2;
        String strStudent_Name3;
        String strStudent_Name4;
        String strStudent_Name5;

        // 중간고사 점수를 받을 정수형 변수 선언
        // 중간고사 점수는 총점에서 30% 반영된다.
        int iMidterm_Score1;
        int iMidterm_Score2;
        int iMidterm_Score3;
        int iMidterm_Score4;
        int iMidterm_Score5;

        // 기말고사 점수를 받을 정수형 변수 선언
        // 기말고사 점수는 총점에서 30% 반영된다.
        int iFinal_Exams_Score1;
        int iFinal_Exams_Score2;
        int iFinal_Exams_Score3;
        int iFinal_Exams_Score4;
        int iFinal_Exams_Score5;

        // 숙제 점수를 받을 정수형 변수 선언
        // 숙제 점수는 총점에서 25% 반영된다.
        int iHomework_Score1;
        int iHomework_Score2;
        int iHomework_Score3;
        int iHomework_Score4;
        int iHomework_Score5;

        // 출석 점수를 받을 정수형 변수 선언
        // 출석 점수는 총점에서 15% 반영된다.
        int iAttendance_Score1;
        int iAttendance_Score2;
        int iAttendance_Score3;
        int iAttendance_Score4;
        int iAttendance_Score5;

        // 총점을 받을 실수형 변수 선언
        // 총점을 소수점 1번째 자리까지 출력해야한다.
        double dTotal_Score1;
        double dTotal_Score2;
        double dTotal_Score3;
        double dTotal_Score4;
        double dTotal_Score5;

        // 각 학생의 학점을 저장한 변수 선언
        // 성적은 다음과 같이 입력 된다.
        // A: 90~100점, B: 80~89점, C: 70~79, D:60~69점, F: 그 외
        // 문자 0으로 초기화한 이유는 System.out.println(chrGrade_Student1);을 통해 출력하면 초기화를 요구하는
        // 에러가 나와 , 에러를 방지하고자 초기화 시켰다.
        char chrGrade_Student1 = '0';
        char chrGrade_Student2 = '0';
        char chrGrade_Student3 = '0';
        char chrGrade_Student4 = '0';
        char chrGrade_Student5 = '0';


        // 항목별 반영되는 점수들
        // 중간 30%, 기말 30%, 숙제 25%, 출석 15%
        double fExamScoreRatio_Mid = 0.3;
        double fExamScoreRatio_Final = 0.3;
        double fExamScoreRatio_Homework = 0.25;
        double fExamScoreRatio_Attendance = 0.15;


        // ----------------
        // 학생정보 입력하는 구역
        // ----------------

        // 특징:
        // 이름입력은 "영문자 대문자" 한 자리만 받는다.
        // 문자열 참조변수와 객체를 사용하며 학생 1~5까지 이름과 점수를 입력받는다.
        // 학생 1~5의 정보 이름, 중간고사점수, 기말고사점수, 숙제점수, 출석점수 입력
        // 가급적 깔끔한 출력문이 깔끔하게 나오게 하려면, 이름은 영문자1글자, 점수는 숫자 2글자로 해야 가장 정렬되어서 나온다.

        // 학생1 입력 시작
        Scanner Scan_Student_Name1 = new Scanner(System.in);
        Scanner Scan_iMidterm_Score1 = new Scanner(System.in);
        Scanner Scan_iFinal_Exams_Score1 = new Scanner(System.in);
        Scanner Scan_iHomework_Score1= new Scanner(System.in);
        Scanner Scan_iAttendance_Score1= new Scanner(System.in);
        Scanner Scan_fTotal_Score1= new Scanner(System.in);

        System.out.print("학생1 이름 입력 : ");
        strStudent_Name1 = Scan_Student_Name1.nextLine();
        System.out.print("학생1 중간고수점수 입력 : ");
        iMidterm_Score1 = Scan_iMidterm_Score1.nextInt();
        System.out.print("학생1 기말고사점수 입력 : ");
        iFinal_Exams_Score1 = Scan_iMidterm_Score1.nextInt();
        System.out.print("학생1 숙제점수 입력 : ");
        iHomework_Score1 = Scan_iMidterm_Score1.nextInt();
        System.out.print("학생1 출석점수  입력 : ");
        iAttendance_Score1 = Scan_iMidterm_Score1.nextInt();

        //총점 계산 소수점 1자리만 출력
        dTotal_Score1 = ((iMidterm_Score1*fExamScoreRatio_Mid)
                  + (iFinal_Exams_Score1*fExamScoreRatio_Final)
                  + (iHomework_Score1*fExamScoreRatio_Homework)
                   +(iAttendance_Score1*fExamScoreRatio_Attendance));

        // if 구문을 이용해 학생 1~5의 성적을 A~F까지 평가한다.
        // A: 90~100점, B: 80~89점, C: 70~79, D:60~69점, F: 그 외
        if(90 <= dTotal_Score1 && dTotal_Score1 <= 100)
        {
            chrGrade_Student1 = 'A';
        }
        else if(80 <= dTotal_Score1 && dTotal_Score1 <90)
        {
            chrGrade_Student1 = 'B';
        }
        else if(70 <= dTotal_Score1 && dTotal_Score1 <80)
        {
            chrGrade_Student1 = 'C';
        }
        else if(60 <= dTotal_Score1 && dTotal_Score1 <70)
        {
            chrGrade_Student1 = 'D';
        }
        else if(0 <= dTotal_Score1 && dTotal_Score1 <60)
        {
            chrGrade_Student1 = 'F';
        }
        else
        {
            // 점수의 범위가 0부터 100까지인데 이 범위가 넘어설 경우를 대비한 예외를 고려한 구문이다.
            System.out.println("점수계산이 잘못되었습니다. 점수를 다시 입력하세요");
        }

        System.out.println("");


        // 학생2 입력 시작
        Scanner Scan_Student_Name2 = new Scanner(System.in);
        Scanner Scan_iMidterm_Score2 = new Scanner(System.in);
        Scanner Scan_iFinal_Exams_Score2 = new Scanner(System.in);
        Scanner Scan_iHomework_Score2= new Scanner(System.in);
        Scanner Scan_iAttendance_Score2= new Scanner(System.in);
        Scanner Scan_fTotal_Score2= new Scanner(System.in);

        System.out.print("학생2 이름 입력 : ");
        strStudent_Name2 = Scan_Student_Name2.nextLine();
        System.out.print("학생2 중간고수점수 입력 : ");
        iMidterm_Score2 = Scan_iMidterm_Score2.nextInt();
        System.out.print("학생2 기말고사점수 입력 : ");
        iFinal_Exams_Score2 = Scan_iMidterm_Score2.nextInt();
        System.out.print("학생2 숙제점수 입력 : ");
        iHomework_Score2 = Scan_iMidterm_Score2.nextInt();
        System.out.print("학생2 출석점수  입력 : ");
        iAttendance_Score2 = Scan_iMidterm_Score2.nextInt();

        //총점 계산 소수점 1자리만 출력
        dTotal_Score2 = ((iMidterm_Score2*fExamScoreRatio_Mid)
                + (iFinal_Exams_Score2*fExamScoreRatio_Final)
                + (iHomework_Score2*fExamScoreRatio_Homework)
                +(iAttendance_Score2*fExamScoreRatio_Attendance));

        // if 구문을 이용해 학생 1~5의 성적을 A~F까지 평가한다.
        // A: 90~100점, B: 80~89점, C: 70~79, D:60~69점, F: 그 외
        if(90 <= dTotal_Score2 && dTotal_Score2 <= 100)
        {
            chrGrade_Student2 = 'A';
        }
        else if(80 <= dTotal_Score2 && dTotal_Score2 <90)
        {
            chrGrade_Student2 = 'B';
        }
        else if(70 <= dTotal_Score1 && dTotal_Score1 <80)
        {
            chrGrade_Student2 = 'C';
        }
        else if(60 <= dTotal_Score2 && dTotal_Score2 <70)
        {
            chrGrade_Student2 = 'D';
        }
        else if(0 <= dTotal_Score1 && dTotal_Score1 <60)
        {
            chrGrade_Student2 = 'F';
        }
        else
        {
            // 점수의 범위가 0부터 100까지인데 이 범위가 넘어설 경우를 대비한 예외를 고려한 구문이다.
            System.out.println("점수계산이 잘 못 되었습니다. 점수를 다시 입력하세요");
        }

        System.out.println("");


        // 학생3 입력 시작
        Scanner Scan_Student_Name3 = new Scanner(System.in);
        Scanner Scan_iMidterm_Score3 = new Scanner(System.in);
        Scanner Scan_iFinal_Exams_Score3 = new Scanner(System.in);
        Scanner Scan_iHomework_Score3= new Scanner(System.in);
        Scanner Scan_iAttendance_Score3= new Scanner(System.in);
        Scanner Scan_fTotal_Score3= new Scanner(System.in);

        System.out.print("학생3 이름 입력 : ");
        strStudent_Name3 = Scan_Student_Name3.nextLine();
        System.out.print("학생3 중간고수점수 입력 : ");
        iMidterm_Score3 = Scan_iMidterm_Score3.nextInt();
        System.out.print("학생3 기말고사점수 입력 : ");
        iFinal_Exams_Score3 = Scan_iMidterm_Score3.nextInt();
        System.out.print("학생3 숙제점수 입력 : ");
        iHomework_Score3 = Scan_iMidterm_Score3.nextInt();
        System.out.print("학생3 출석점수  입력 : ");
        iAttendance_Score3 = Scan_iMidterm_Score3.nextInt();

        //총점 계산 소수점 1자리만 출력
        dTotal_Score3 = ((iMidterm_Score3*fExamScoreRatio_Mid)
                + (iFinal_Exams_Score3*fExamScoreRatio_Final)
                + (iHomework_Score3*fExamScoreRatio_Homework)
                +(iAttendance_Score3*fExamScoreRatio_Attendance));

        // if 구문을 이용해 학생 1~5의 성적을 A~F까지 평가한다.
        // A: 90~100점, B: 80~89점, C: 70~79, D:60~69점, F: 그 외
        if(90 <= dTotal_Score3 && dTotal_Score3 <= 100)
        {
            chrGrade_Student3 = 'A';
        }
        else if(80 <= dTotal_Score3 && dTotal_Score3 <90)
        {
            chrGrade_Student3 = 'B';
        }
        else if(70 <= dTotal_Score3 && dTotal_Score3 <80)
        {
            chrGrade_Student3 = 'C';
        }
        else if(60 <= dTotal_Score3 && dTotal_Score3 <70)
        {
            chrGrade_Student3 = 'D';
        }
        else if(0 <= dTotal_Score3 && dTotal_Score3 <60)
        {
            chrGrade_Student3 = 'F';
        }
        else
        {
            // 점수의 범위가 0부터 100까지인데 이 범위가 넘어설 경우를 대비한 예외를 고려한 구문이다.
            System.out.println("점수계산이 잘 못 되었습니다. 점수를 다시 입력하세요");
        }

        System.out.println("");


        // 학생4 입력 시작
        Scanner Scan_Student_Name4 = new Scanner(System.in);
        Scanner Scan_iMidterm_Score4 = new Scanner(System.in);
        Scanner Scan_iFinal_Exams_Score4 = new Scanner(System.in);
        Scanner Scan_iHomework_Score4= new Scanner(System.in);
        Scanner Scan_iAttendance_Score4= new Scanner(System.in);
        Scanner Scan_fTotal_Score4= new Scanner(System.in);

        System.out.print("학생4 이름 입력 : ");
        strStudent_Name4 = Scan_Student_Name4.nextLine();
        System.out.print("학생4 중간고수점수 입력 : ");
        iMidterm_Score4 = Scan_iMidterm_Score4.nextInt();
        System.out.print("학생4 기말고사점수 입력 : ");
        iFinal_Exams_Score4 = Scan_iMidterm_Score4.nextInt();
        System.out.print("학생4 숙제점수 입력 : ");
        iHomework_Score4 = Scan_iMidterm_Score4.nextInt();
        System.out.print("학생4 출석점수  입력 : ");
        iAttendance_Score4 = Scan_iMidterm_Score4.nextInt();

        //총점 계산 소수점 1자리만 출력
        dTotal_Score4 = ((iMidterm_Score4*fExamScoreRatio_Mid)
                + (iFinal_Exams_Score4*fExamScoreRatio_Final)
                + (iHomework_Score4*fExamScoreRatio_Homework)
                +(iAttendance_Score4*fExamScoreRatio_Attendance));

        // if 구문을 이용해 학생 1~5의 성적을 A~F까지 평가한다.
        // A: 90~100점, B: 80~89점, C: 70~79, D:60~69점, F: 그 외
        if(90 <= dTotal_Score4 && dTotal_Score4 <= 100)
        {
            chrGrade_Student4 = 'A';
        }
        else if(80 <= dTotal_Score4 && dTotal_Score4 <90)
        {
            chrGrade_Student4 = 'B';
        }
        else if(70 <= dTotal_Score4 && dTotal_Score4 <80)
        {
            chrGrade_Student4 = 'C';
        }
        else if(60 <= dTotal_Score4 && dTotal_Score4 <70)
        {
            chrGrade_Student4 = 'D';
        }
        else if(0 <= dTotal_Score4 && dTotal_Score4 <60)
        {
            chrGrade_Student4 = 'F';
        }
        else
        {
            // 점수의 범위가 0부터 100까지인데 이 범위가 넘어설 경우를 대비한 예외를 고려한 구문이다.
            System.out.println("점수계산이 잘 못 되었습니다. 점수를 다시 입력하세요");
        }

        System.out.println("");


        // 학생5 입력 시작
        Scanner Scan_Student_Name5 = new Scanner(System.in);
        Scanner Scan_iMidterm_Score5 = new Scanner(System.in);
        Scanner Scan_iFinal_Exams_Score5 = new Scanner(System.in);
        Scanner Scan_iHomework_Score5= new Scanner(System.in);
        Scanner Scan_iAttendance_Score5= new Scanner(System.in);
        Scanner Scan_fTotal_Score5= new Scanner(System.in);

        System.out.print("학생5 이름 입력 : ");
        strStudent_Name5 = Scan_Student_Name5.nextLine();
        System.out.print("학생5 중간고수점수 입력 : ");
        iMidterm_Score5 = Scan_iMidterm_Score5.nextInt();
        System.out.print("학생5 기말고사점수 입력 : ");
        iFinal_Exams_Score5 = Scan_iMidterm_Score5.nextInt();
        System.out.print("학생5 숙제점수 입력 : ");
        iHomework_Score5 = Scan_iMidterm_Score5.nextInt();
        System.out.print("학생5 출석점수  입력 : ");
        iAttendance_Score5 = Scan_iMidterm_Score5.nextInt();

        //총점 계산 소수점 1자리만 출력
        dTotal_Score5 = ((iMidterm_Score5*fExamScoreRatio_Mid)
                + (iFinal_Exams_Score5*fExamScoreRatio_Final)
                + (iHomework_Score5*fExamScoreRatio_Homework)
                +(iAttendance_Score5*fExamScoreRatio_Attendance));

        // if 구문을 이용해 학생 1~5의 성적을 A~F까지 평가한다.
        // A: 90~100점, B: 80~89점, C: 70~79, D:60~69점, F: 그 외
        if(90 <= dTotal_Score5 && dTotal_Score5 <= 100)
        {
            chrGrade_Student5 = 'A';
        }
        else if(80 <= dTotal_Score5 && dTotal_Score5 <90)
        {
            chrGrade_Student5 = 'B';
        }
        else if(70 <= dTotal_Score5 && dTotal_Score5 <80)
        {
            chrGrade_Student5 = 'C';
        }
        else if(60 <= dTotal_Score5 && dTotal_Score5 <70)
        {
            chrGrade_Student5 = 'D';
        }
        else if(0 <= dTotal_Score5 && dTotal_Score5 <60)
        {
            chrGrade_Student5 = 'F';
        }
        else
        {
            // 점수의 범위가 0부터 100까지인데 이 범위가 넘어설 경우를 대비한 예외를 고려한 구문이다.
            System.out.println("점수계산이 잘 못 되었습니다. 점수를 다시 입력하세요");
        }

        System.out.println("");



        // 이슈는 출력구문이 내 마음대로 안나온다.
        // 입력 받은 학생들의 정보를 출력한다.
        // 출력문에 %.1f 소수점 1자만 출력하게 하는 것이다.
        System.out.println("이름  중간   기말  숙제  출석  총점  학점");
        System.out.println("----------------------------------");
        // 학생 1 정보 출력
        System.out.print(strStudent_Name1+"     "+iMidterm_Score1+"   "+iFinal_Exams_Score1+"   "
                +iHomework_Score1+"   "+iAttendance_Score1);
        System.out.printf("  %.1f",dTotal_Score1);
        System.out.println("  "+chrGrade_Student1);
        // 학생 2 정보 출력
        System.out.print(strStudent_Name2+"     "+iMidterm_Score2+"   "+iFinal_Exams_Score2+"   "
                +iHomework_Score2+"   "+iAttendance_Score2);
        System.out.printf("  %.1f",dTotal_Score2);
        System.out.println("  "+chrGrade_Student2);
        // 학생 3 정보 출력
        System.out.print(strStudent_Name3+"     "+iMidterm_Score3+"   "+iFinal_Exams_Score3+"   "
                +iHomework_Score3+"   "+iAttendance_Score3);
        System.out.printf("  %.1f",dTotal_Score3);
        System.out.println("  "+chrGrade_Student3);
        // 학생 4 정보 출력
        System.out.print(strStudent_Name4+"     "+iMidterm_Score4+"   "+iFinal_Exams_Score4+"   "
                +iHomework_Score4+"   "+iAttendance_Score4);
        System.out.printf("  %.1f",dTotal_Score4);
        System.out.println("  "+chrGrade_Student4);
        // 학생 5 정보 출력
        System.out.print(strStudent_Name5+"     "+iMidterm_Score5+"   "+iFinal_Exams_Score5+"   "
                +iHomework_Score5+"   "+iAttendance_Score5);
        System.out.printf("  %.1f",dTotal_Score5);
        System.out.println("  "+chrGrade_Student5);


        // 추가 출력문 2가지 작성
        // 1.수강인원, 전체 평균점수, 전체 평균학점 출력
        double dTotal_Score_avr;
        char chrGrade_Student_avr = '0';
        dTotal_Score_avr = (dTotal_Score1 + dTotal_Score2 + dTotal_Score3 + dTotal_Score4 + dTotal_Score5)/5;

        // 총점을 정수형으로 형변환 후, 10으로 나누면 정수값 숫자만 나오게 된다.
        // 90~99점까지 case9가 나오는 방법이다. 100점은 case10이다.
        switch((int)dTotal_Score_avr/10){
            case 10:
            case 9:{
                // 10, 9레이블을 하나의 부류로 묶어서 처리하게 됩니다.
                chrGrade_Student_avr ='A';
                break;
            }
            case 8:{
                chrGrade_Student_avr ='B';
                break;
            }
            case 7:{
                chrGrade_Student_avr ='C';
                break;
            }
            case 6:{
                chrGrade_Student_avr ='D';
                break;
            }
            default:
                chrGrade_Student_avr ='F';
        }

        System.out.println();
        System.out.println();
        System.out.println("수강인원 : 5명");
        System.out.printf("전체평균점수 : %.1f",dTotal_Score5);
        System.out.println();
        System.out.println("전체평균학점: "+chrGrade_Student_avr);

        // 2. 학점별 인원 출력
        int iCount_Grade_A = 0;
        int iCount_Grade_B = 0;
        int iCount_Grade_C = 0;
        int iCount_Grade_D = 0;
        int iCount_Grade_F = 0;

        // A~F까지 인원을 카운트
        // 학생 1 카운트
        if(chrGrade_Student1 == 'A')
        {
            iCount_Grade_A = iCount_Grade_A +1 ;
        }
        else if(chrGrade_Student1 == 'B')
        {
            iCount_Grade_B = iCount_Grade_B + 1;
        }
        else if(chrGrade_Student1 == 'C')
        {
            iCount_Grade_C = iCount_Grade_C + 1;
        }
        else if(chrGrade_Student1 == 'D')
        {
            iCount_Grade_D = iCount_Grade_D + 1;
        }
        else if(chrGrade_Student1 == 'F')
        {
            iCount_Grade_F = iCount_Grade_F + 1;
        }

        // 학생 2 카운트
        if(chrGrade_Student2 == 'A')
        {
            iCount_Grade_A = iCount_Grade_A +1 ;
        }
        else if(chrGrade_Student2 == 'B')
        {
            iCount_Grade_B = iCount_Grade_B + 1;
        }
        else if(chrGrade_Student2== 'C')
        {
            iCount_Grade_C = iCount_Grade_C + 1;
        }
        else if(chrGrade_Student2 == 'D')
        {
            iCount_Grade_D = iCount_Grade_D + 1;
        }
        else if(chrGrade_Student2 == 'F')
        {
            iCount_Grade_F = iCount_Grade_F + 1;
        }

        // 학생 3 카운트
        if(chrGrade_Student3 == 'A')
        {
            iCount_Grade_A = iCount_Grade_A +1 ;
        }
        else if(chrGrade_Student3 == 'B')
        {
            iCount_Grade_B = iCount_Grade_B + 1;
        }
        else if(chrGrade_Student3 == 'C')
        {
            iCount_Grade_C = iCount_Grade_C + 1;
        }
        else if(chrGrade_Student3 == 'D')
        {
            iCount_Grade_D = iCount_Grade_D + 1;
        }
        else if(chrGrade_Student3 == 'F')
        {
            iCount_Grade_F = iCount_Grade_F + 1;
        }

        // 학생 4 카운트
        if(chrGrade_Student4 == 'A')
        {
            iCount_Grade_A = iCount_Grade_A +1 ;
        }
        else if(chrGrade_Student4 == 'B')
        {
            iCount_Grade_B = iCount_Grade_B + 1;
        }
        else if(chrGrade_Student4 == 'C')
        {
            iCount_Grade_C = iCount_Grade_C + 1;
        }
        else if(chrGrade_Student4 == 'D')
        {
            iCount_Grade_D = iCount_Grade_D + 1;
        }
        else if(chrGrade_Student4 == 'F')
        {
            iCount_Grade_F = iCount_Grade_F + 1;
        }

        // 학생 5 카운트
        if(chrGrade_Student5 == 'A')
        {
            iCount_Grade_A = iCount_Grade_A +1 ;
        }
        else if(chrGrade_Student5 == 'B')
        {
            iCount_Grade_B = iCount_Grade_B + 1;
        }
        else if(chrGrade_Student5 == 'C')
        {
            iCount_Grade_C = iCount_Grade_C + 1;
        }
        else if(chrGrade_Student5 == 'D')
        {
            iCount_Grade_D = iCount_Grade_D + 1;
        }
        else if(chrGrade_Student5 == 'F')
        {
            iCount_Grade_F = iCount_Grade_F + 1;
        }

        System.out.println();
        System.out.println("  학점   인원");
        System.out.println("-------------");
        System.out.println("  A   :   "+iCount_Grade_A);
        System.out.println("  B   :   "+iCount_Grade_B);
        System.out.println("  C   :   "+iCount_Grade_C);
        System.out.println("  D   :   "+iCount_Grade_D);
        System.out.println("  F   :   "+iCount_Grade_F);

    }
}

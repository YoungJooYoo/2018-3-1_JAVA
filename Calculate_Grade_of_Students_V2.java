/*
 * 작성자 정보 : 2016101453 컴퓨터학부 유영주
 * 목적 및 개요:  3-1학기  Java과제  <Calculate_Grade_of_Students_V2>
 * 과제수행날짜: 2018.04.05(목) 작성시작 ->
 * 프로그램 특징: JAVA로 성적산출 프로그램 구현
 * 사용언어: JAVA
 * 프로그램 작성환경 및 실행환경:
 *   OS: OSX High Sierra 10.13.4
 *   실행: OSX Terminal
 *   JAVA version: 9.0.1
 */



/*
 * 개선사항: 1. 배열 미사용 => 배열 사용.
 *         2. 상세메뉴 출력
 *         3. 수강 학생 수를 입력 받는다 ( 2<= 수강생 <=10 )
 *         4. Scanner 객체 하나 사용으로 수정 ( 저번 과제 지적사항 )
 *
 */



// 김성완 교수님!
// 숙제 hwp파일 타입 B 설명 중
// " 6. [개별학생 성적 조호] 메뉴 선택 "항목에 따르면 "이름"을 입력 받아 성적을 출력하라고 하셨지만,
//  " 7. 프로그램 실행 시 한 가지 시나리오의 예 " 항목에 따르면 "조회활 학생 학번 입력"이라고 되었습니다.
// 학번과, 이름 중 무엇을 입력 받아 개별조회를 하는지 통일 되지 않아,
// 본 과제는 "이름"을 입력 받아 개인 성적을 조회하는 방향으로 진행하였습니다.


/*
 * 본 프로그램은 다음과 같은 규칙을 준수한다.
 *
 * 1. 헝가리안 표기법을 이용해 변수명을 지정한다.
 *    이유는 IDE를 쓰지 않고, 터미널 vim을 이용하기 때문에 변수 타입 혼동을 막기 위함이다.
 * 2. 변수의 타입의 명확성을 위해 타입+변수명으로 변수 이름을 지정한다.
 *    int Num;  ->  int iNum;
 * 3. N명을 5명으로 정하고 진행했다.
 * 4. 함수의 첫글자는 영문다 재문자를 사용한다.
 *
 */



import java.io.IOException;
import java.util.Scanner;

public class Calculate_Grade_of_Students_V2 {
    public static  void main (String[] args) throws IOException {


        /*  재학생 수 입력 과정 */
        // 한 번 입력 받은 재학생 수는 더 이상 변경되지 않는다.
        // 입력을 받은 값이 배열의 크기를 정한다.
        // 입력 범위가 초과하면 범위에 허용되는 입력값을 입력할때까지 무한반복한다.

        int itheNumberOfStudentsEnrolled = 0; // 이 변수가 배열의 크기를 정해준다.
        int countSelectNum1 = 0;  // 1번 메뉴를 최초 실행하기 위한 변수다. 이 변수가 0이 아니면 1번을 더이상 실행하지 않는다.
        int selectNum = 0; // 메뉴 선택 입력 받을 변수 선언
        int countStudent = 0;
        int countForMoment = 0; // 입력받는 학생수 만큼 학생 정보를 입력 받아야하는데, 그것을 체크할 변수.

        for (; ; ) {

            System.out.println(" --------------------------- ");
            System.out.println(" 다음 메뉴 5가지 중 하나 선택해주세요 ");
            System.out.println(" --------------------------- ");
            System.out.println(" 1. 재학생 수 입력 ");
            System.out.println(" 2. 개별학생 성적입력 ");
            System.out.println(" 3. 전체 성적표 출력 ");
            System.out.println(" 4. 개별학생 성적 조회 ");
            System.out.println(" 5. 프로그램종료 ");

            Scanner Scan_selectNum = new Scanner(System.in);
            selectNum = Scan_selectNum.nextInt();

            // 1번 학생 수 입력 구현. 최초 실행이후 다시는 실행되지 않는다.
            if (selectNum == 1 && countSelectNum1 == 0) {
                System.out.println("1번 메뉴는 최초 실행 이후 다시 실행되지 않습니다.");
                System.out.println(" 재학생 수를 입력하세요. 범위는 2부터 10까지 ");
                Scanner Scan_theNumberOfStudentsEnrolled = new Scanner(System.in);
                itheNumberOfStudentsEnrolled = Scan_theNumberOfStudentsEnrolled.nextInt();
             }

             if (itheNumberOfStudentsEnrolled < 2 || itheNumberOfStudentsEnrolled > 10) {
                System.out.println("입력범위 초과 다시 입력해주세요.");
             }
             else {
                 System.out.println(itheNumberOfStudentsEnrolled+ "명의 학생을 입력 받습니다.");
                 break;
             }
        }


            /*  재학생 정보 입력 변수 */
            String[] strStudent_Name = new String[itheNumberOfStudentsEnrolled];
            int[] istudentIdentificatinNumber = new int[itheNumberOfStudentsEnrolled];
            int[] iMidterm_Score = new int[itheNumberOfStudentsEnrolled];
            int[] iFinal_Exams_Score = new int[itheNumberOfStudentsEnrolled];
            int[] iHomework_Score = new int[itheNumberOfStudentsEnrolled];
            int[] iAttendance_Score = new int[itheNumberOfStudentsEnrolled];


            // 각 학생의 학점을 저장한 변수 선언
            // 성적은 다음과 같이 입력 된다.
            // A: 90~100점, B: 80~89점, C: 70~79, D:60~69점, F: 그 외
            // 문자 0으로 초기화한 이유는 System.out.println(chrGrade_Student1);을 통해 출력하면 초기화를 요구하는
            // 에러가 나와 , 에러를 방지하고자 초기화 시켰다.
            char[] chrGrade_Student = new char[itheNumberOfStudentsEnrolled];


            // 항목별 반영되는 점수들
            // 중간 30%, 기말 30%, 숙제 25%, 출석 15%
            double fExamScoreRatio_Mid = 0.3;
            double fExamScoreRatio_Final = 0.3;
            double fExamScoreRatio_Homework = 0.25;
            double fExamScoreRatio_Attendance = 0.15;


            // 총점을 받을 실수형 변수 선언
            // 총점을 소수점 1번째 자리까지 출력해야한다.
            double[] dTotal_Score = new double [itheNumberOfStudentsEnrolled];


            // 2~5번 메뉴 구현
            // 사용자가 프로그램을 종료하기\
            for (; ; ) {

                System.out.println(" --------------------------- ");
                System.out.println(" 다음 메뉴 5가지 중 하나 선택해주세요 ");
                System.out.println(" --------------------------- ");
                System.out.println(" 1. 재학생 수 입력 ");
                System.out.println(" 2. 개별학생 성적입력 ");
                System.out.println(" 3. 전체 성적표 출력 ");
                System.out.println(" 4. 개별학생 성적 조회 ");
                System.out.println(" 5. 프로그램종료 ");

                // 1번 재실행은 방지하고 다시 메뉴 번호 입력을 받는다.
                selectNum = 0;
                Scanner Scan_selectNum = new Scanner(System.in);
                selectNum = Scan_selectNum.nextInt();

                /*  개별학생 성적입력 */
                if (selectNum == 2) {
                    // 입력 받은 학생수를 확인하여 범위가 초과하면 메세지를 띄운다.
                    if(countForMoment >= itheNumberOfStudentsEnrolled){
                        System.out.println("입력 가능한 범위인 "+itheNumberOfStudentsEnrolled+"명을 초과했습니다.");
                    }
                    //학번은 정수 1자리 배열의 길이 제는 함수 1> 넘어가면 다시 입력
                    //변수를 공유해서 count ++로 현재 위치부터 다시 가능하게 만든다.
                    else if(countStudent< itheNumberOfStudentsEnrolled){
                        for (; countStudent <= itheNumberOfStudentsEnrolled; ) {
                            Scanner scanStudnetInfo = new Scanner(System.in);  // 이 객체로 계속 객체를 찎어내고 그 주소값을 배열로 선언한 변수에 넣는다.

                            System.out.print("학생" + (countStudent + 1) + "의 이름 입력 : ");
                            strStudent_Name[countStudent] = scanStudnetInfo.nextLine();
                            System.out.print("학생" + (countStudent + 1) + "의 학번 입력 : ");
                            istudentIdentificatinNumber[countStudent] = scanStudnetInfo.nextInt();
                            System.out.print("학생" + (countStudent + 1) + "의 중간고사점수 입력 : ");
                            iMidterm_Score[countStudent] = scanStudnetInfo.nextInt();
                            System.out.print("학생" + (countStudent + 1) + "의 기말고수점수 입력 : ");
                            iFinal_Exams_Score[countStudent] = scanStudnetInfo.nextInt();
                            System.out.print("학생" + (countStudent + 1) + "의 숙제점수 입력 : ");
                            iHomework_Score[countStudent] = scanStudnetInfo.nextInt();
                            System.out.print("학생" + (countStudent + 1) + "의 출석점수 입력 : ");
                            iAttendance_Score[countStudent] = scanStudnetInfo.nextInt();
                            countStudent = countStudent + 1;
                            countForMoment = countForMoment + 1; // 몇번째 학생까지 입력 받았는지 확인하는 변수
                            break;  // 한번만 for문 실행하고 종료
                        } // for문 괄호
                    } // if 괄호
                } // 개별학생 성적입력 if 괄호

                /* 전체 성적표 출력  */
                else if (selectNum == 3) {

                    //총점 계산 소수점 1자리만 출력 각 입력 받은 점수와 반영 비율을 적용해서 계산한다.
                    for (int i = 0; i < countForMoment; i++) {

                        dTotal_Score[i] = ((iMidterm_Score[i] * fExamScoreRatio_Mid)
                                + (iFinal_Exams_Score[i] * fExamScoreRatio_Final)
                                + (iHomework_Score[i] * fExamScoreRatio_Homework)
                                + (iAttendance_Score[i] * fExamScoreRatio_Attendance));

                        // if 구문을 이용해 학생 1~5의 성적을 A~F까지 평가한다.
                        // A: 90~100점, B: 80~89점, C: 70~79, D:60~69점, F: 그 외
                        if (90 <= dTotal_Score[i] && dTotal_Score[i] <= 100) {
                            chrGrade_Student[i] = 'A';
                        } else if (80 <= dTotal_Score[i] && dTotal_Score[i] < 90) {
                            chrGrade_Student[i] = 'B';
                        } else if (70 <= dTotal_Score[i] && dTotal_Score[i] < 80) {
                            chrGrade_Student[i] = 'C';
                        } else if (60 <= dTotal_Score[i] && dTotal_Score[i] < 70) {
                            chrGrade_Student[i] = 'D';
                        } else if (0 <= dTotal_Score[i] && dTotal_Score[i] < 60) {
                            chrGrade_Student[i] = 'F';
                        } else {
                            // 점수의 범위가 0부터 100까지인데 이 범위가 넘어설 경우를 대비한 예외를 고려한 구문이다.
                            System.out.println("점수계산이 잘못되었습니다. 점수를 다시 입력하세요");
                        }

                        System.out.println("");

                    }


                    // 추가 출력문 2가지 작성
                    // 1.수강인원, 전체 평균점수, 전체 평균학점 출력
                    double dTotal_Score_avr = 0;
                    char chrGrade_Student_avr = '0';

                    // 반복문으로 입력된 학생수만큼  전체 점수 합을 구한다.
                    for (int i = 0; i < countForMoment; i++) {
                        dTotal_Score_avr = dTotal_Score_avr + dTotal_Score[i];
                    }
                    // 입력된 학생 수 만큼의 나누어 전체 평균을 구한다.
                    dTotal_Score_avr = dTotal_Score_avr / countForMoment;


                    // 총점을 정수형으로 형변환 후, 10으로 나누면 정수값 숫자만 나오게 된다.
                    // 90~99점까지 case9가 나오는 방법이다. 100점은 case10이다.
                    switch ((int) dTotal_Score_avr / 10) {
                        case 10:
                        case 9: {
                            // 10, 9레이블을 하나의 부류로 묶어서 처리하게 됩니다.
                            chrGrade_Student_avr = 'A';
                            break;
                        }
                        case 8: {
                            chrGrade_Student_avr = 'B';
                            break;
                        }
                        case 7: {
                            chrGrade_Student_avr = 'C';
                            break;
                        }
                        case 6: {
                            chrGrade_Student_avr = 'D';
                            break;
                        }
                        default:
                            chrGrade_Student_avr = 'F';
                    }

                    System.out.println();
                    System.out.println();
                    System.out.println("수강인원 : " + itheNumberOfStudentsEnrolled + "명");
                    System.out.printf("전체평균점수 : %.1f", dTotal_Score_avr);
                    System.out.println();
                    System.out.println("전체평균학점: " + chrGrade_Student_avr);


                    // 2. 학점별 인원 출력
                    int iCount_Grade_A = 0;
                    int iCount_Grade_B = 0;
                    int iCount_Grade_C = 0;
                    int iCount_Grade_D = 0;
                    int iCount_Grade_F = 0;

                    for( int i=0; i<countForMoment; i++ ){
                    // A~F까지 인원을 카운트
                        if (chrGrade_Student[i] == 'A') {
                        iCount_Grade_A = iCount_Grade_A + 1;
                        }
                        else if (chrGrade_Student[i] == 'B') {
                        iCount_Grade_B = iCount_Grade_B + 1;
                        }
                        else if (chrGrade_Student[i] == 'C') {
                        iCount_Grade_C = iCount_Grade_C + 1;
                        }
                        else if (chrGrade_Student[i] == 'D') {
                        iCount_Grade_D = iCount_Grade_D + 1;
                        }
                        else if (chrGrade_Student[i] == 'F') {
                        iCount_Grade_F = iCount_Grade_F + 1;
                        }

                    }

                    System.out.println();
                    System.out.println("  학점   인원");
                    System.out.println("-------------");
                    System.out.println("  A   :   " + iCount_Grade_A);
                    System.out.println("  B   :   " + iCount_Grade_B);
                    System.out.println("  C   :   " + iCount_Grade_C);
                    System.out.println("  D   :   " + iCount_Grade_D);
                    System.out.println("  F   :   " + iCount_Grade_F);


                    // 최고점과 최저점을 구한다.
                    // 최고점 변수에 0을 두고 입력된 값을 배열의 순서대로 비교하며 찾는다.
                    // 최저점 변수에 100을 두고 입력된 값을 배열의 순서대로 비교하며 찾는다.
                    double dmaxScore = 0;
                    double dminScore = 100;
                    String strStudent_Name_MaxScore = "0";
                    String strStudent_Name_MinScore = "0";
                    char chrGrade_Student_Max = '0';
                    char chrGrade_Student_Min = '0';

                    for( int i=0; i<countForMoment; i++ ){

                        if (dmaxScore < dTotal_Score[i]){
                        dmaxScore = dTotal_Score[i];
                        strStudent_Name_MaxScore = strStudent_Name[i];
                        chrGrade_Student_Max = chrGrade_Student[i];
                      }

                      if (dminScore > dTotal_Score[i]){
                        dminScore = dTotal_Score[i];
                        strStudent_Name_MinScore = strStudent_Name[i];
                        chrGrade_Student_Min = chrGrade_Student[i];
                       }
                    }

                    System.out.println("    이름      평균    학점");
                    System.out.println("-------------------------");
                    System.out.print("최고  "+strStudent_Name_MaxScore+"      ");
                    System.out.printf(" %.1f",dmaxScore);
                    System.out.println("    "+chrGrade_Student_Max);
                    System.out.print("최저  "+strStudent_Name_MinScore+"       ");
                    System.out.printf("%.1f",dminScore);
                    System.out.println("    "+chrGrade_Student_Min);

                }
                /* 개별학생 성적 조회 */
                // 동명이인도 검색 되어야한다.
                else if (selectNum == 4) {
                    int countForCheck = itheNumberOfStudentsEnrolled;  // 성적조회 실패시 사용할 변수
                    String strStudent_NameCheck;
                    Scanner scanStudentCheckName = new Scanner(System.in);
                    System.out.print("성적 조회할 학생의 이름을 입력하세요");
                    strStudent_NameCheck = scanStudentCheckName.nextLine();

                    for(int i=0; i< itheNumberOfStudentsEnrolled; i++){
                        if( strStudent_NameCheck.equals(strStudent_Name[i]) ) {
                            System.out.println(strStudent_Name[i]+"학생의 성적 조회결과는 아래와 같습니다.");
                            System.out.println("----------------------------------------------");
                            System.out.println("학번   중간  기말  숙제  출석  점수  학점");
                            System.out.print(istudentIdentificatinNumber[i] +"      ");
                            System.out.print(iMidterm_Score[i] +"    ");
                            System.out.print(iFinal_Exams_Score[i] +"    ");
                            System.out.print(iHomework_Score[i] +"   ");
                            System.out.print(iAttendance_Score[i] +"    ");
                            System.out.printf("%.1f    ",dTotal_Score[i]);
                            System.out.println(chrGrade_Student[i]);
                            countForCheck = countForCheck - 1;
                        }
                    }
                    // 모든 이름배열과 비교 후 일치하는 이름이 없으면 countForCheck의 값이 변동이 없으므로, 다음 메세지를 출력
                    if(countForCheck == itheNumberOfStudentsEnrolled){
                        System.out.println(strStudent_NameCheck+"학생의 성적을 조회할 수 없습니다.");
                    }
                }
                /* 프로그램 종료 */
                else if (selectNum == 5) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                /* 예외상황 처리 보기 선택 이외를 선택했을 경우 */
                else{
                    System.out.println("입력 범위를 벗어 났거나, 1번을 다시 선택하셨습니다. 2~5번을 다시 선택해주세요");
                }

            }

        }
}

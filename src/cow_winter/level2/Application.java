package cow_winter.level2;
import java.util.Scanner;
public class Application {
	
	//기능1메소드-빈문자열 처리
	public int add(String input) {
		if (input.isEmpty()) {
			//inEmpty(): 빈 문자열인지 확인
            return 0; //빈문자열일떄 0을 반환
        }
	
	//기능1메소드-기본 구분자 분리
	 String[] Split = input.split("[,:]"); //문자열 배열 Split
     return Sum(Split); //Split배열을 Sum메소드에 전달
}
	//합계 메소드
	public int Sum(String[] number) {
		int sum=0;
		 for (String num : number) { //배열을 정수로 변환해 합산
	            sum += Integer.parseInt(num);  
	     //for(타입 변수명 : 배열): 배열을 순회하며 처리
	        }
	        return sum;  	
		}
	
	//기능2메소드-커스텀 구분자 분리
	public int Customsplit(String input) {
		int result=0;
		
		try {
		
			int lineIndex=input.indexOf("\n");
			if (lineIndex==-1) {
			//잘못된 입력 형식일 때
				throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
			
		}
		 String delimiter= input.substring(2,input.indexOf("\n")); 
		//substring(int startIndex,int endIndex):(포함,불포함)문자열 특정 부분 잘라냄
		//indexOf(String str):지정된 문자가 처음 등장하는 인덱스 반환 없으면 -1빈환
		 if (delimiter.isEmpty()) {
             throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
         }
		 
		 String number=input.substring(input.indexOf("\n")+1);
		 //"\n"뒤부터 있는 숫자와 문자들 끝까지 추출
		 if (number.isEmpty()) {
             throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
         }

		 String[] Split=number.split(delimiter);
		 //위에서 추출한 구분자로 숫자들 분리후 배열로 반환
		 
		 return Sum(Split);
		 
	} catch (IllegalArgumentException err) {
        //예외 메시지를 출력하고 -1 반환
        System.out.println(err.getMessage());
        return -1; 
    }
    
  
}
		

	//메인 메소드
	public static void main(String[] args) {
		Application app=new Application();
		Scanner sc=new Scanner(System.in);
		
	while(true) {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String input=sc.nextLine(); 
		 try {
             // 커스텀 구분자 처리
             if (input.startsWith("//")) {
                 int result = app.Customsplit(input); //Customsplit 메소드 호출
                 if (result == -1) {
                     break; 
                 }
                 System.out.println("결과 : " + result);
                 break; 
             }

             // 기본 구분자 처리
             int result = app.add(input);
             System.out.println("결과 : " + result);
             break; 
         } catch (IllegalArgumentException err) {
             //예외 발생시 메시지 출력 후 프로그램 종료
             System.out.println("잘못된 값을 입력했습니다.");
             break;
         }
     }
	}
}
		
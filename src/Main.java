import java.util.Random;
import java.util.Scanner;

class  Lotto{
    int[] set; //한세트에 저장될 로또 번호
    int buyNum; //구매한 로또 수

    public Lotto() {
        set = new int[6]; //로또 6개의 수가 들어갈 수 있는 배열 개수 선언
    }

    public void inputBuyNum(){ //몇장을 구입할건지 입력 받음
        Scanner scanner = new Scanner(System.in);
        System.out.print("구매횟수를 입력하세요 : ");
        buyNum = scanner.nextInt(); //구매한 로또의 개수를 buyNum이라는 변수에 담아두기
    }

    public void selectLotto(){
        boolean check; //중복된 수가 있는지 확인하는 변수
        Random random = new Random();
        set[0] = random.nextInt(45)+1; //일단 첫번째 수에 난수를 저장하고
        //인덱스는 0부터 시작하기 때문에 로또에는 0이 없으니 +1을 해준다

        for(int i=1; i<set.length; ){
            set[i] = random.nextInt(45)+1; //인덱스1번은 우리가 생각하는 2번이기 때문에 처음에 두번째 수를 저장하고
            check = false; //새로 들어온 값이 중복인지를 체크한다.
            for(int b=0; b<i; b++){ //비교는 첫번째인 0의 자리부터 시작
                if(set[i] == set[b]){ //저장된 번호와 새로 들어온 난수가 같은 번호라면
                    check = true; //중복이므로
                    break; // for문을 빠져나간다
                }
            }
            if(!check) i++; //중복이 아닐때만 i값을 ++시켜 다음 자리로 이동
        }
    }
    public void sort(){ //오름차순으로 로또 수 정렬
        for(int x=0; x<set.length; x++){ //기준값
            for (int y =x+1; y<set.length; y++){ //비교값
                if(set[x] > set[y]){ //배열 앞의 자리 수가 뒤에 자리수보다 크다면 바꿔야하므로
                    int temp = set[x]; //temp라는 변수에 x의 값을 임시로 담아 놓고
                    set[x] = set[y]; //x자리의 값은 더 작았던 y의 값으로 가져오고
                    set[y] = temp; //y의 값에 temp에 넣어두었던 x의 값을 가져온다 *작은수를 앞으로 위치 바꾸기
                }
            }
        }
    }
    public void outputResult(){ //랜덤으로 돌린 로또 번호 출력
        for (int i=0; i<set.length; i++)
            System.out.printf("%3d", set[i]); //3칸으로 맞춰서 출력해주세요 (출력수가 자릿수마다 땡겨져서 중구난방이 아니라 깔끔해짐)
        System.out.println(); //배열 하나 출력할때마다 줄넘김
    }
    public void doLotto(){
        inputBuyNum(); //입력개수를 물어보는 메소드 호출 후
        for(int i=0; i<buyNum; i++){ //내가 산 개수만큼 출력해주기
            selectLotto(); //로또 번호 뽑아오고
            sort(); //정렬해서
            outputResult(); //출력하기
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(); //로또 객체를 생성하여
        lotto.doLotto(); //실행합니다!
    }
}

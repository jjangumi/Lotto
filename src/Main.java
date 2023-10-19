import java.util.Random;
import java.util.Scanner;

class  Lotto{
    int[] set;
    int buyNum;

    public Lotto(){
        set = new int[6];
    }

    public void inputBuyNum(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("구매횟수를 입력하세요 : ");
        buyNum = scanner.nextInt();
    }

    public void selectLotto(){
        boolean check;
        Random random = new Random();
        set[0] = random.nextInt(45)+1;

        for(int i=1; i<6; ){
            set[i] = random.nextInt(45)+1;
            check = false;
            for(int b=0; b<i; b++){
                if(set[i] == set[b]){
                    check = true;
                    break;
                }
            }
            if(!check) i++;
        }
    }
    public void sort(){
        for(int x=0; x<5; x++){
            for (int y =x+1; y<6; y++){
                if(set[x] > set[y]){
                    int temp = set[x];
                    set[x] = set[y];
                    set[y] = temp;
                }
            }
        }
    }
    public void outputResult(){
        for (int i=0; i<6; i++){
            System.out.printf("%3d",set[i]);
        }
        System.out.println();
    }
    public void doLotto(){
        inputBuyNum();
        for(int i=0; i<buyNum; i++){
            selectLotto();
            sort();
            outputResult();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.doLotto();
    }
}

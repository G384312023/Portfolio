import java.util.Random;

public class Number{
    Random rand = new Random();
    char[] ans = new char[4];
    char[] num;
    int Hit = 0, Blow = 0;
    String memo = "", answer = "";
    String error = "\t\t\t\t\t\t\tエラー：無効な入力です。";
    String numE = "\n\t\t\t\t\t\t\t・数字以外の文字が含まれています。";
    String dig = "\n\t\t\t\t\t\t\t・入力が4桁ではありません。";
    String dupli = "\n\t\t\t\t\t\t\t・重複した文字が含まれています。";

    public void getAns(){
        answer = "";
        for(int i = 0; i < 4; i++){
            int tmp = rand.nextInt(10);
            int k = i;
            boolean same = false;

            for(int j = 0; j < k; j++){
                if(tmp == (ans[j] - '0')){
                    same = true;
                }
            }

            if(same){
                i--;
            }else{
                ans[i] = (char)(tmp + '0');
            }
        }

        for(int i = 0; i < 4; i++){
            answer = answer + ans[i];
        }  
    }

    public void getNum(String numStr){
        for(int i = 0; i < numStr.length(); i++){
            num[i] = numStr.charAt(i);
        }
    }

    public boolean Digerror(String error){
        if(error.length() != 4 && error.length() != 0) return true;
        else return false;
    }

    public boolean Numerror(String error){
        for(int i = 0; i < error.length(); i++){
            num[i] = error.charAt(i);
            if(num[i] < '0' || '9' < num[i]){
                return true;
            }
        }
        return false;
    }

    public boolean Duplierror(String error){
        for(int i = 1; i < error.length(); i++){
            num[i] = error.charAt(i);
            if(num[i - 1] == num[i]){
                return true;
            }
        }
        return false;
    }

    public boolean Noerror(String error){
        if(error.length() == 0) return true;
        else return false;
    }

    public int Hit(){
        for(int i = 0; i < 4; i++){
            if(num[i] == ans[i]){
                Hit++;
            }
        }

        return Hit;
    }

    public int Blow(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i != j){
                    if(ans[i] == num[j]){
                        Blow++;
                    }
                }
            }
        }

        return Blow;
    }

    public String Memory(String numStr){
        num = new char[numStr.length()];
        getNum(numStr);

        if(!(Digerror(numStr) || Numerror(numStr) || Duplierror(numStr) || Noerror(numStr))){
            memo = memo + "\t\t\t\t\t\t\t" + numStr + "\t|\tHit：" + Hit() + "\t|\tBlow：" + Blow() + "\n";
        }

        if(Digerror(numStr) && !(Numerror(numStr)) && !(Duplierror(numStr))) return error + dig;
        if(Numerror(numStr) && !(Digerror(numStr)) && !(Duplierror(numStr))) return error + numE;
        if(!(Digerror(numStr)) && !(Numerror(numStr)) && Duplierror(numStr)) return error + dupli;
        if(Digerror(numStr) && Numerror(numStr) && !(Duplierror(numStr))) return error + dig + numE;
        if(Digerror(numStr) && !(Numerror(numStr)) && Duplierror(numStr)) return error + dig + dupli;
        if(!(Digerror(numStr)) && Numerror(numStr) && Duplierror(numStr)) return error + numE + dupli;
        if(Digerror(numStr) && Numerror(numStr) && Duplierror(numStr)) return error + dig + numE + dupli;
        if(Noerror(numStr) && !(Digerror(numStr)) && !(Numerror(numStr)) && !(Duplierror(numStr))) return "\t\t\t\t\t\t\t・入力がありません。";
        if(Hit == 4) return memo + "\t\t\t\t\t\t\t正解！\n\t\t\t\t\t\t\t答えは「" + answer + "」でした。";
        else return memo;
    }

    public void Reset(){
        Hit = 0;
        Blow = 0;
    }

    public void Restart(){
        getAns();
        memo = "";
    }
}
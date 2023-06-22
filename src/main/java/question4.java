import java.util.ArrayList;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
public class question4 {
    private static String convert(String s, int numRows){
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()){
            rows.get(i).append(c);
            if(i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();

    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        String s1 = convert(s, numRows);
        System.out.println(s1);
    }
}

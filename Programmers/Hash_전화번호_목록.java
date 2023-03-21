import java.util.Arrays;

public class Hash_전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (isPrefix(phone_book[i], phone_book[i + 1])) {
                return false;
            }
        }

        return true;
    }

    private boolean isPrefix(String targetNum, String phoneNum) {
        // 비교할 숫자 길이가 더 긴 경우 접두어 불가능
        if (targetNum.length() > phoneNum.length())
            return false;

        // 접두어 체크
        for (int i = 0; i < targetNum.length(); i++) {
            char targetNumOne = targetNum.charAt(i);
            char phoneNumOne = phoneNum.charAt(i);

            if (targetNumOne != phoneNumOne)
                return false;
        }

        return true;
    }
}


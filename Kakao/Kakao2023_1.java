import java.util.*;

class Kakao2023_1 {
    private Map<Character, Integer> termsMap = new HashMap<>();
    private List<Integer> answer = new ArrayList<>();
    private StringTokenizer st;

    public int[] solution(String today, String[] terms, String[] privacies) {
        // set termsMap
        for (String term : terms) {
            st = new StringTokenizer(term);
            char type = st.nextToken().charAt(0);
            int monthSize = Integer.parseInt(st.nextToken());
            termsMap.put(type, monthSize);
        }

        // set answer
        for (int i = 0; i < privacies.length; i++) {
            String calculatePrivacy = calculateDay(privacies[i]);

            if (!isAvailable(today, calculatePrivacy)) {
                answer.add(i + 1);
            }
        }

        // 오름차순 정렬
        Collections.sort(answer);

        // list to array
        int[] newAnswer = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            newAnswer[i] = answer.get(i);
        }

        // return
        return newAnswer;
    }

    // 약관 종류에 따른 날짜 계산
    private String calculateDay(String privacy) {
        st = new StringTokenizer(privacy);
        String day = st.nextToken();
        char type = st.nextToken().charAt(0);

        // calculate
        st = new StringTokenizer(day, ".");
        int thisYear = Integer.parseInt(st.nextToken());
        int thisMonth = Integer.parseInt(st.nextToken());
        int thisDay = Integer.parseInt(st.nextToken());

        // day
        int newDay = (thisDay + (28 * termsMap.get(type))) % 28 - 1;
        newDay = (newDay <= 0) ? newDay + 28 : newDay;

        // month
        int newMonth = thisMonth + termsMap.get(type);
        newMonth = (thisDay == 1) ? newMonth - 1 : newMonth;

        // year
        int newYear = thisYear + (newMonth / 12);
        newMonth %= 12;

        return newYear + "." + newMonth + "." + newDay;
    }

    // 개인정보 유지 가능 여부 판단
    private boolean isAvailable(String today, String target) {
        st = new StringTokenizer(today, ".");
        int todayYear = Integer.parseInt(st.nextToken());
        int todayMonth = Integer.parseInt(st.nextToken());
        int todayDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(target, ".");
        int targetYear = Integer.parseInt(st.nextToken());
        int targetMonth = Integer.parseInt(st.nextToken());
        int targetDay = Integer.parseInt(st.nextToken());

        // year 검사
        if (targetYear < todayYear)
            return false;
        else if (targetYear > todayYear)
            return true;

        // year 같은 경우 month 검사
        if (targetMonth < todayMonth)
            return false;
        else if (targetMonth > todayMonth)
            return true;

        // year, month 같은 경우 day 검사
        if (targetDay < todayDay)
            return false;
        else if (targetDay > todayDay)
            return true;

        // today와 target 같은 경우
        return true;
    }
}


/*
날짜 계산
*/


/*
System.out.println();
*/

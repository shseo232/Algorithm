import java.util.*;

class Solution {
    static Map<String, Integer> money = new HashMap<>();
    static Map<String, String> graph = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int profitPerSale = 100;

        // enroll과 referral을 기반으로 graph와 money 초기화
        for (int i = 0; i < enroll.length; i++) {
            graph.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }

        // 판매 기록에 따라 수익 계산
        for (int i = 0; i < seller.length; i++) {
            distributeProfit(seller[i], amount[i] * profitPerSale);
        }

        // 결과를 answer 배열에 저장
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = money.get(enroll[i]);
        }

        return answer;
    }

    static void distributeProfit(String seller, int profit) {
        if (seller.equals("-")) {
            return;
        }

        // 자신의 수익
        int ownProfit = profit - profit / 10; // 90%
        // 추천인에게 전달할 수익
        int referralProfit = profit / 10; // 10%

        // 자신의 수익 추가
        money.put(seller, money.get(seller) + ownProfit);

        // 추천인에게 수익 배분
        if (referralProfit > 0) {
            distributeProfit(graph.get(seller), referralProfit);
        }
    }
}

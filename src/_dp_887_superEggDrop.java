import java.util.Arrays;

public class _dp_887_superEggDrop {
	
    public int superEggDrop(int K, int N) {

    	int[][] dp = new int[N+1][K+1];
    	
    	for(int i = 0; i <= N; i++) {
    		Arrays.fill(dp[i], Integer.MAX_VALUE);
    	}
    	// �� 0 �У�¥��Ϊ 0 ��ʱ�򣬲��ܼ����������٣������Բ��������� F ֵ����ȫΪ 0
    	// �� 1 �У�¥��Ϊ 1 ��ʱ��0 ��������ʱ���� 0 �Σ�1 ���Լ� 1 ����������ֻ��Ҫ�� 1 ��
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
        }
        // �� 0 �У���������Ϊ 0 ��ʱ�򣬲���¥��Ϊ���٣�Ҳ���Բ��������� F ֵ����ȫΪ 0
        // �� 1 �У���������Ϊ 1 ��ʱ������һ�ּ��������Ҫ�Գ� F ֵ�����ٴ����͵���¥��߶�
    	for(int i = 0; i <= N; i++) {
    		dp[i][0] = 0;
    		dp[i][1] = i;
    	}
    	
    	for(int i = 2; i <= N; i++) {
    		for(int j = 2; j <= K; j++) {
    			for(int k = 1; k <= i; k++) {
    				dp[i][j] = Math.min(dp[i][j], 
    						Math.max(dp[k-1][j-1], dp[i-k][j]) + 1);
    			}
    		}
    	}
    	return dp[N][K];
    }
    public int superEggDrop1(int K, int N) {

    	int[][] dp = new int[N+1][K+1];
    	
    	for(int i = 0; i <= N; i++) {
    		Arrays.fill(dp[i], Integer.MAX_VALUE);
    	}
    	
    	// �� 0 �У�¥��Ϊ 0 ��ʱ�򣬲��ܼ����������٣������Բ��������� F ֵ����ȫΪ 0
    	// �� 1 �У�¥��Ϊ 1 ��ʱ��0 ��������ʱ���� 0 �Σ�1 ���Լ� 1 ����������ֻ��Ҫ�� 1 ��
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
        }
        // �� 0 �У���������Ϊ 0 ��ʱ�򣬲���¥��Ϊ���٣�Ҳ���Բ��������� F ֵ����ȫΪ 0
        // �� 1 �У���������Ϊ 1 ��ʱ������һ�ּ��������Ҫ�Գ� F ֵ�����ٴ����͵���¥��߶�
    	for(int i = 0; i <= N; i++) {
    		dp[i][0] = 0;
    		dp[i][1] = i;
    	}
    
    	for(int i = 2; i <= N; i++) {
    		for(int j = 2; j <= K; j++) {
                // ������ [1, i] ��ȷ��һ������ֵ
                int left = 1;
                int right = i;
                while (left < right) {
                    // �� dp[k - 1][j - 1] <= dp[i - mid][j] �����ֵ k
                    int mid = left + (right - left + 1) / 2;
                    
                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // �ų���������˼�룩д�Զ��ּ��� 35 �⣬����ʲôʱ���ǽ�
                        // �ϸ���ڵ�ʱ��һ�����ǽ⣬��ʱ mid һ�����ǽ�
                        // ��һ������������ [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // �������һ������һ������ķ��棬�� [mid, right]
                        // ע�����ʱ��ȡ�м���Ҫ��ȡ����int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left ����±�������ŵ� k ֵ����������ת�Ʒ��� Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) ����
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
    		}
    	}
    	return dp[N][K];
    }
}

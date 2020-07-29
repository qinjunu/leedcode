import java.util.Arrays;

public class _dp_887_superEggDrop {
	
    public int superEggDrop(int K, int N) {

    	int[][] dp = new int[N+1][K+1];
    	
    	for(int i = 0; i <= N; i++) {
    		Arrays.fill(dp[i], Integer.MAX_VALUE);
    	}
    	// 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0
    	// 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
        }
        // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
        // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度
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
    	
    	// 第 0 行：楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0
    	// 第 1 行：楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
        }
        // 第 0 列：鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0
        // 第 1 列：鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度
    	for(int i = 0; i <= N; i++) {
    		dp[i][0] = 0;
    		dp[i][1] = i;
    	}
    
    	for(int i = 2; i <= N; i++) {
    		for(int j = 2; j <= K; j++) {
                // 在区间 [1, i] 里确定一个最优值
                int left = 1;
                int right = i;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;
                    
                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
    		}
    	}
    	return dp[N][K];
    }
}

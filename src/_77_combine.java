import java.util.ArrayList;
import java.util.List;

public class _77_combine {

	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

    	List<Integer> track = new ArrayList<>();
    	// �� 1 ��ʼ�� ���ﲢ���Ǵ����±꣬��������
    	backtrack(n, k, 1, track);
    	return ans;
    }
    public void backtrack(int n, int k, int start, List<Integer> track) {
    	
    	if(track.size() == k) {
    		ans.add(new ArrayList<>(track));
    		return;
    	}
    	
    	// �� 1 ��ʼ
    	for(int i = start; i <= n; i++) {
    		track.add(i);
    		backtrack(n, k, i + 1, track);
    		track.remove(track.size() - 1);
    	}
    	
    }
}

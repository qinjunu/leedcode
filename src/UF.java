
public class UF {

	// ��ͨ��������
	private int count;
	// �洢һ����
	private int[] parent;
	// ��¼��������(��СһЩ�����ӵ���һЩ��������)
	private int[] size;
	
	public UF(int n) {
		this.count = n;
		// ���ÿ����ֻ��һ���ڵ�
		// ������ʼ��Ϊ 1
		parent = new int[n];
		size = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	// Ѱ�Ҹ��ڵ�
	private int find(int x) {
		while(parent[x] != x) {
			// ·��ѹ��(���ڵ��Ϊ���ڵ�)
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}
	
	// �ϲ�
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP == rootQ) {
			return;
		}
		
		// С���ӵ���������
		if(size[rootP] > size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		
		count--;
	}
	
	// �����Ƿ���ͨ
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
	}
	
	public int count() {
		return count;
	}

}

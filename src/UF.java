
public class UF {

	// 连通分量个数
	private int count;
	// 存储一个树
	private int[] parent;
	// 记录树的重量(将小一些的树接到大一些的树下面)
	private int[] size;
	
	public UF(int n) {
		this.count = n;
		// 最初每棵树只有一个节点
		// 重量初始化为 1
		parent = new int[n];
		size = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	
	// 寻找父节点
	private int find(int x) {
		while(parent[x] != x) {
			// 路径压缩(父节点改为根节点)
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}
	
	// 合并
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP == rootQ) {
			return;
		}
		
		// 小树接到大树下面
		if(size[rootP] > size[rootQ]) {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}else {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}
		
		count--;
	}
	
	// 二者是否连通
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
	}
	
	public int count() {
		return count;
	}

}

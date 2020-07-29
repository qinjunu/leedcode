
public class _floodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

    	int oldColor = image[sr][sc];
    	fill(image, sr, sc, oldColor, newColor);

    	return image;
    }
    public void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
    	if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
    		return;
    	}
    	
    	if(image[sr][sc] != oldColor || image[sr][sc] == -1) {
    		return;
    	}
    	
    	System.out.println(sr + " " + sc);
    	image[sr][sc] = -1;
    	
    	fill(image, sr - 1, sc, oldColor, newColor);
    	fill(image, sr + 1, sc, oldColor, newColor);
    	fill(image, sr, sc - 1, oldColor, newColor);
    	fill(image, sr, sc + 1, oldColor, newColor);
    	
    	image[sr][sc] = newColor;
    }
    public static void main(String[] args) {
    	_floodFill test = new _floodFill();
    	int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
    	test.floodFill(image, 1, 1, 2);
	}
}

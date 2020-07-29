
public class _990_equationsPossible {

    public boolean equationsPossible(String[] equations) {

    	UF uf = new UF(26);
    	
    	for(String s : equations) {
    		if(s.charAt(1) == '=') {
    			uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
    		}
    	}
    	for(String s : equations) {
    		if(s.charAt(1) == '!') {
    			if(uf.connected(s.charAt(0) - 'a', s.charAt(3) - 'a')) {
    				return false;
    			}
    		}
    	}
    	
    	
    	return true;
    }    
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		String str = "     +0a22qq22";
		str = str.trim();
		System.out.println(str);
		String regex = "[-|+]?\\d+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		m.lookingAt();
		System.out.println(m.group());
		System.out.println(Integer.parseInt("+100"));
	}

}

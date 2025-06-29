package basics.paractice;

public class Test {
	public static void main(String[] args) {
		
		String a = "azam";
		char[] ch = a.toCharArray();
		System.out.println(ch);
		StringBuilder sb = new StringBuilder(a);
		for(int i=0;i<ch.length;i++) {
			if(ch[i] == 'a') {
				sb.append('z');
			}
		}
		System.out.println(sb);
	}

}

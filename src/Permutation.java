public class Permutation
{
		public static void main(String[] args)
		{
			String a= "abc";
			Find(a,0,"");

		}
		static void Find(String s,int n,String newString){
			if(n==s.length()){
				System.out.println(newString);
				return;
			}
			char ch= s.charAt(n);
			for (int i = 0; i <=newString.length() ; i++)
			{
				String left = newString.substring(0,i);
				String right =newString.substring(i);

				Find(s,n+1,left+ch+right);
			}
		}

	}



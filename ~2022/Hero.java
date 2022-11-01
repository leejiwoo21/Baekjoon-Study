import java.util.*;

public class Hero {
	static Scanner in = new Scanner(System.in);
	
	static int N  = in.nextInt();
	static long heroAtk = in.nextInt();
	
	static long fullHp = 1;
	static long heroHp = fullHp;
	static long monsterAtk = 0;
	static long monsterHp = 0;
	static long potionAtk = 0;
	static long potionHp = 0;
	
	public static void main(String[] args) {
		
		int room = 0;
		for(int i =0; i<N; i++)
		{
			room = in.nextInt();
			if(room == 1)
			{
				fight();
			}
			else
			{
				heal();
			}
		}
		System.out.println(fullHp);
		
	}
	
	public static void fight()
	{
		monsterAtk = in.nextLong();
		monsterHp = in.nextLong();
		if((heroHp/monsterAtk)>(monsterHp/heroAtk))
		{
			heroHp -= (monsterHp/heroAtk)*monsterAtk;
		}
		else
		{
			fullHp += (heroHp/monsterAtk)*monsterAtk + 1 - heroHp ;
			heroHp = 1 ;
		}
	}
	
	public static void heal()
	{
		potionAtk = in.nextInt();
		potionHp = in.nextInt();
		heroAtk += potionAtk;
		if(fullHp < (heroHp + potionHp))
		{
			heroHp = fullHp;
		}
		else
		{
			heroHp += potionHp;
		}
	}
}

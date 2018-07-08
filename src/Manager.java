
public class Manager {
	
	public int[][] num=new int [22][22];
	private static Manager manager=new Manager();
	public static Manager getManager()
	{
		return manager;
	}
	
	 public int check1(int x,int y,int goal)
	  {
		  
		  boolean res1 = true;
		  boolean res2 = true;
		  boolean res3 = true;
		  boolean res4 = true;
		  for(int i=0;i<5;i++)
		  {
			  if(y+i<20)
			  res1&=(num[x][y+i]==goal);
			  else
			  res1=false;
			  if(x+i<20)
			  res2&=(num[x+i][y]==goal);
			  else
			  res2=false;
			  if(x+i<20&&y+i<20)
			  res3&=(num[x+i][y+i]==goal);
			  else
			  res3=false;
			  if(x-i>=0&&y+i<20)
			  res4&=(num[x-i][y+i]==goal);
			  else
			  res4=false;
		  }
		  
		  if(res1||res2||res3||res4)
		  return goal;
		  return 0;
	  }
	 
	 public int check(int goal)
	   {
		   int res= 0;
		   for(int i=0;i<20;i++)
		   {
			 for(int j=0;j<20;j++)   
			 {
				 if(num[i][j]==goal) 
				 {
				 res=check1(i,j,goal);
				 }
				 if(res!=0)
	             break;
			 } 
			 if(res!=0)
	             break;
		   }
		   return res;
	   }
	
}

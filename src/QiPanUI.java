import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
public class QiPanUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//开局黑子先行
	Boolean black=true;
	int x;//行
	int y;//列
	int winflag=0;
	BufferedImage image = null;
	
	   public QiPanUI()
	   {
		  this.setBounds(100, 100, 900, 900);
		  this.setTitle("黑棋先手");
		  this.setResizable(false);
		  this.addMouseListener
		  (
				new MouseListener() {
				    @Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
						if(winflag==0) 
						{
						   x = e.getX();
						   y = e.getY(); 
						   System.out.println(""+x+"  "+y);
						   if(x>50&&x<850&&y>50&&y<850)
						   {
							  x=(x-50)/40;
						      y=(y-50)/40;
							  if(Manager.getManager().num[x][y]==0)
							  {
								 if(black) 
								 {
								  Manager.getManager().num[x][y]+=1; 
								  winflag=Manager.getManager().check(1);  //黑棋标1
								 }
								 else
								 {
								 Manager.getManager().num[x][y]+=2;
								 winflag=Manager.getManager().check(2);
								 }
								 repaint();
								 if(winflag==0)  //换人
								 {
									 black=!black;
									 if(black)
										  setTitle("轮到黑棋");
									 else
										  setTitle("轮到黄棋");
								 }
								 else 
								 {
									 if(winflag==1)
									 setTitle("黑子获胜");
									 else
									 setTitle("黄子获胜");
								 }
							  }	
						   }
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
					}
				});
	  }
		
	  public void paint(Graphics g) 
	  {
			g.drawImage(image,0,0,this);
			for (int i = 0; i < 20; i++)
			{
				g.drawLine(70, 70 + 40 * i, 830, 70 + 40 * i);
				g.drawLine(70 + 40 * i, 70, 70 + 40 * i, 830);
			}
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<20;j++)
				{
					if(Manager.getManager().num[i][j]==1)
					{
						g.setColor(Color.BLACK);
						g.fillOval(60+i*40, 60+j*40 , 20, 20);
					}
					else if(Manager.getManager().num[i][j]==2)
					{
						g.setColor(Color.YELLOW);
						g.fillOval(60+i*40, 60+j*40 , 20, 20);
					}
				}
			}
	  }
}

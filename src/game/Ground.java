package game;

import javax.swing.*;
import java.awt.*;

public class Ground {

	Image image;
	
	int x,y;//λ��
	
	int width,height;
	
	//�����ʼ��
	public Ground() throws Exception
	{
		image =new ImageIcon("../source/ground.png").getImage();
		width=image.getWidth(null);
		height=image.getHeight(null);
		x=0;
		y=500;
	}
	
	//����
	public void step()
	{
		x-=4;
		if(x<=-109)
		{
			x=0;
		}
	}
	
	
}

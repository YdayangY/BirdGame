package game;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class Bird {

	Image image;
	int x,y;
	int width,height;
	int size;
	//�������ٶ�
	double g;
	//λ�Ƽ��ʱ��
	double t;
	//����ٶ�
	double v0;
	//��ǰ�����ٶ�
	double speed;
	//����ʱ��t���λ��
	double s;
	//С�����ǣ����ȣ�
	double alpha;
	
	//һ��ͼƬ��¼С�񶯻�֡
	Image[] images;
	//֡���±�
	int index;
	
	public Bird() throws Exception
	{
		image=new ImageIcon("../source/0.png").getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		x=132;
		y=280;
		size=40;
		//λ�Ʋ���
		g=4;
		v0=20;
		t=0.25;
		speed=v0;
		s=0;
		//С��ƫת�Ƕ�
		alpha=0;
		
		//��ʼ������֡����
		images=new Image[8];
		
		for(int i=0;i<8;i++)
		{
			images[i]=new ImageIcon("../source/"+i+".png").getImage();
		}
		index=0;
		
	}
	
	//���ж������仯һ֡��
	public void fly()
	{
		index++;
		image=images[(index/12)%8];
	}
	
	//�ƶ�һ��
	public void step()
	{
		double v0=speed;
		//��������λ��
		s=v0*t+g*t*t/2;
		//�����������
		y=y-(int)s;
		//�����´��ƶ��ٶ�
		double v=v0-g*t;
		speed =v;
		//������ǣ������к�����
		alpha=Math.atan(s/8);
		
	}
	
	//���Ϸ���
	public void flappy()
	{
		//�����ٶ�
		speed=v0;
	}
	
	//���С���Ƿ���ײ������
	public boolean hit(Ground ground)
	{
		boolean hit =y+size/2>ground.y;
		if(hit)
		{
			y=ground.y-size/2;
			alpha=Math.PI/2;
		}
		return hit;
	}
	
	//���С���Ƿ�ײ������
	public boolean hit(Column column)
	{
		//����Ƿ������ӷ�Χ��
		if(x>column.x-column.width/2-size/2&&x<column.x+column.width/2+size/2)
		{
			if(y>column.y-column.gap/2+size/2&&y<column.y+column.gap/2-size/2) return false;
			return true;
		}
		return false;
	}
}

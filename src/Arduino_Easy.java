import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Arduino_Easy extends JFrame{
	Container c;
	static AEControl ae;
	public Arduino_Easy(){
		//��ԊO���̃R���e�i�̒�`
		setTitle("�V���[�e�B���O�Q�[��");
		setSize(700,460);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);

		//Arduino_Easy���R���g���[������N���X�̒ǉ�
		ae = new AEControl();
		ae.setBounds(0,0,660,400);
		ae.setBackground(Color.red);
		c.add(ae);
	}

	public static void main(String[] args){
		JFrame f = new Arduino_Easy();
		f.setVisible(true);
	}
}



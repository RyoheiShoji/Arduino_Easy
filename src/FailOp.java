import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class FailOp extends JButton implements ActionListener{

	Process p;
	File newfile,savefile,newFold;
	String url = "C://Users/ryoh/Documents/Arduino_Easy/";
	JButton[] jbArray;
	JTextArea jt;
	String[] nameArray = {"�V�K�쐬","�J��","�ۑ�","��������"};
	JLabel popw,mainL;
	String pname;
	File file;
	ArrayList<String> evplace ;
	//��ƃG���A�̃N���X�錾 �Ăяo�����ꏊ���玝���Ă���
	JLabel FailOp(/*��Ƃ̈���*/){
		//�{�^���̐錾
		for(int i = 0;i < nameArray.length;i++){
			jbArray[i] = new JButton();
			jbArray[i].setBounds(i * 50, 20, 40,30);
		}

		//�V�K�쐬���̃E�B���h�E�쐬
		popw = new JLabel();
		popw.setText("���O����͂��Ă�������");

		//savedata/save.txt�̒��g�̑ޔ�p�z��
		evplace = new ArrayList<String>();

		//�V�K�쐬�E�B���h�E�ɖ��O������
		jt = new JTextArea();
		popw.add(jt);

		//�V�K�쐬�E�B���h�E�ɒ���t���郉�x��
		mainL = new JLabel();

		//�t�@�C������{�^���̒ǉ�
		for(JButton jb :jbArray){
			mainL.add(jb);
		}

		//�����̃G���A�N���X

		//main�N���X�ɕԂ��{�^���̓��������x��
		return mainL;

	}
	public void create(String s){
		//���O�����߂�
		JOptionPane.showMessageDialog(jbArray[0],popw);
		pname = jt.getText();
		try{
            //�t�@�C���̓ǂݍ��ݓ�
			file = new File(url + "savedata/save.txt");
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //save.txt�̑ޔ�
            String about = br.readLine();
            while(about != null){
            	evplace.add(about);
    			about = br.readLine();
    		}

            //�J�E���g�̍X�V
            evplace.add(0,String.valueOf(Integer.valueOf(evplace.get(0)) + 1));

            //���̊m�F ������ꍇNewPloject + �J�E���g�ɕύX
            if(evplace.contains(pname)){
            	pname = "NewProject" + evplace.get(0);
        		mainL.setText("�������O�̕�������܂��B\n" + pname + "�ŐV�K�쐬���܂��B");
        		repaint();
        	}
            evplace.add(pname);
            //�ǂݍ��񂾃t�@�C�����疼�O�̔�肪�Ȃ���
            /*String count = br.readLine();
            for(int i = 0;i < Integer.parseInt(count) ;i++){
            	String about = br.readLine();
            	if(pname.equals(about)){
            		pname = "newProject" + count;
            		mainL.setText("�������O�̕�������܂��B\n" +pname + "�ŐV�K�쐬���܂��B");
            		repaint();
            		break;
            	}
            }*/
            dataEvacuation(pw);
            //�I������
            br.close();
            pw.close();
            fr.close();

        } catch (IOException ex) {
            //��O����������
            ex.printStackTrace();
        }
		//�t�H���_�ƃt�@�C����V�K�쐬����
	    try{
	    	newFold = new File(url + pname);
	    	newFold.mkdir();

	    	savefile = new File(url + pname +"/code.txt");
	    	savefile.createNewFile();

	    }catch(IOException e){
	      System.out.println("�t�@�C���̐V�K�쐬�Ɏ��s���܂���");
	    }
	}
	public void open(){

	}
	public void save(){
		//��ƃG���A�Ȃ��̏����z�����������
	}

	public void dataEvacuation(PrintWriter pw){
		//�������Z�[�u�f�[�^����������
		for(String st:evplace){
			pw.println(st);
		}
	}
	public void conpile(){
	}
	public void writing(){
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}
}

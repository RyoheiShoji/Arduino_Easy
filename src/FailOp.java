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
	String[] nameArray = {"新規作成","開く","保存","書き込み"};
	JLabel popw,mainL;
	String pname;
	File file;
	ArrayList<String> evplace ;
	//作業エリアのクラス宣言 呼び出した場所から持ってくる
	JLabel FailOp(/*作業の引数*/){
		//ボタンの宣言
		for(int i = 0;i < nameArray.length;i++){
			jbArray[i] = new JButton();
			jbArray[i].setBounds(i * 50, 20, 40,30);
		}

		//新規作成時のウィンドウ作成
		popw = new JLabel();
		popw.setText("名前を入力してください");

		//savedata/save.txtの中身の退避用配列
		evplace = new ArrayList<String>();

		//新規作成ウィンドウに名前を書く
		jt = new JTextArea();
		popw.add(jt);

		//新規作成ウィンドウに張り付けるラベル
		mainL = new JLabel();

		//ファイル操作ボタンの追加
		for(JButton jb :jbArray){
			mainL.add(jb);
		}

		//引数のエリアクラス

		//mainクラスに返すボタンの入ったラベル
		return mainL;

	}
	public void create(String s){
		//名前を決める
		JOptionPane.showMessageDialog(jbArray[0],popw);
		pname = jt.getText();
		try{
            //ファイルの読み込み等
			file = new File(url + "savedata/save.txt");
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //save.txtの退避
            String about = br.readLine();
            while(about != null){
            	evplace.add(about);
    			about = br.readLine();
    		}

            //カウントの更新
            evplace.add(0,String.valueOf(Integer.valueOf(evplace.get(0)) + 1));

            //被りの確認 被った場合NewPloject + カウントに変更
            if(evplace.contains(pname)){
            	pname = "NewProject" + evplace.get(0);
        		mainL.setText("同じ名前の物があります。\n" + pname + "で新規作成します。");
        		repaint();
        	}
            evplace.add(pname);
            //読み込んだファイルから名前の被りがないか
            /*String count = br.readLine();
            for(int i = 0;i < Integer.parseInt(count) ;i++){
            	String about = br.readLine();
            	if(pname.equals(about)){
            		pname = "newProject" + count;
            		mainL.setText("同じ名前の物があります。\n" +pname + "で新規作成します。");
            		repaint();
            		break;
            	}
            }*/
            dataEvacuation(pw);
            //終了処理
            br.close();
            pw.close();
            fr.close();

        } catch (IOException ex) {
            //例外発生時処理
            ex.printStackTrace();
        }
		//フォルダとファイルを新規作成する
	    try{
	    	newFold = new File(url + pname);
	    	newFold.mkdir();

	    	savefile = new File(url + pname +"/code.txt");
	    	savefile.createNewFile();

	    }catch(IOException e){
	      System.out.println("ファイルの新規作成に失敗しました");
	    }
	}
	public void open(){

	}
	public void save(){
		//作業エリアないの処理配列を書き込み
	}

	public void dataEvacuation(PrintWriter pw){
		//避難させたセーブデータを書き込み
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
		// TODO 自動生成されたメソッド・スタブ

	}
}

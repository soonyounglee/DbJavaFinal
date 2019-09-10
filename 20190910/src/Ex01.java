import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex01 extends JFrame{
	
	private JTextField tf_id;
	private JTextField tf_pw;
	private JTextField tf_comment;
	private JTextField tf_before_id;
	private JTextField tf_delete_id;
	Ex01(){
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg"));
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(37, 49, 57, 15);
		getContentPane().add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(37, 74, 57, 15);
		getContentPane().add(lblPw);
		
		JLabel lblCommenta = new JLabel("COMMENTA");
		lblCommenta.setBounds(37, 99, 95, 15);
		getContentPane().add(lblCommenta);
		
		tf_id = new JTextField();
		tf_id.setBounds(129, 46, 116, 21);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);
		
		tf_pw = new JTextField();
		tf_pw.setColumns(10);
		tf_pw.setBounds(129, 71, 116, 21);
		getContentPane().add(tf_pw);
		
		tf_comment = new JTextField();
		tf_comment.setColumns(10);
		tf_comment.setBounds(129, 96, 116, 21);
		getContentPane().add(tf_comment);
		
		JButton btnSavebutton = new JButton("SAVE BUTTON");
		btnSavebutton.setBounds(80, 124, 165, 23);
		getContentPane().add(btnSavebutton);
		
		JLabel lblMemberJoin = new JLabel("MEMBER JOIN");
		lblMemberJoin.setBounds(80, 10, 125, 15);
		getContentPane().add(lblMemberJoin);
		
		JLabel lblBeforeid = new JLabel("Before_ID");
		lblBeforeid.setBounds(37, 157, 57, 15);
		getContentPane().add(lblBeforeid);
		
		tf_before_id = new JTextField();
		tf_before_id.setColumns(10);
		tf_before_id.setBounds(129, 157, 116, 21);
		getContentPane().add(tf_before_id);
		
		JButton btnUpdateButton = new JButton("UPDATE BUTTON");
		btnUpdateButton.setBounds(80, 193, 165, 23);
		getContentPane().add(btnUpdateButton);
		
		JLabel lblDeleteid = new JLabel("Delete_ID");
		lblDeleteid.setBounds(37, 226, 57, 15);
		getContentPane().add(lblDeleteid);
		
		tf_delete_id = new JTextField();
		tf_delete_id.setColumns(10);
		tf_delete_id.setBounds(129, 226, 116, 21);
		getContentPane().add(tf_delete_id);
		
		JButton btnDeleteButton = new JButton("DELETE BUTTON");
		btnDeleteButton.setBounds(80, 251, 165, 23);
		getContentPane().add(btnDeleteButton);
		
		btnSavebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input_id = tf_id.getText();
				String input_pw = tf_pw.getText();
				String input_comment = tf_comment.getText();
				/*
				 * Connection DB 연결객체
				 * PreparedStatement sql문 작성 객체
				 * ResultSet select문 반환데서 table 내용 가지고 있는 객체
				 * pstmt.executeUpdate();
				 * 
				 * select 값을 가져옴
				 * insert 값을 추가
				 * update 저장되어 잇는 값을 수정
				 * delete 저장된 값을 삭제
				 * drop table table 삭제
				 */
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					String user = "hr";
					String pw = "1234";
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url,user,pw);
					pstmt = conn.prepareStatement("insert into member " + 
							"(id,pw,commentA) " + 
							"values " + 
							"('"+input_id+"','"+input_pw+"',?)");
					pstmt.setString(1, input_comment);
					pstmt.executeUpdate();
					
					System.out.println("DB 연결성공 및 insert 성공");
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnUpdateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input_id = tf_id.getText();
				String input_pw = tf_pw.getText();
				String input_comment = tf_comment.getText();
				String input_before_id = tf_before_id.getText();

				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					String user = "hr";
					String pw = "1234";
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url,user,pw);
					pstmt = conn.prepareStatement("update member" + 
													"set id=? , PW=? , COMMENTA = ? " + 
													"where id=? ");
					pstmt.setString(1, input_id);
					pstmt.setString(2, input_pw);
					pstmt.setString(3, input_comment);
					pstmt.setString(4, input_before_id);
					pstmt.executeUpdate();
					
					System.out.println("DB 연결성공 및 update 성공");
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnDeleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String delete_id = tf_delete_id.getText();

				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					String user = "hr";
					String pw = "1234";
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url,user,pw);
					pstmt = conn.prepareStatement("delete from member where ID=? ");
					pstmt.setString(1, delete_id);
					pstmt.executeUpdate();
//					pstmt.setInt(1,10);
					int result = pstmt.executeUpdate();
					System.out.println(result);
					
					System.out.println("DB 연결성공 및 delete 성공");
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		setSize(301, 327);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Ex01();
	}
}









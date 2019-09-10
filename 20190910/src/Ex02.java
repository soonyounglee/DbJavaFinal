import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Ex02 extends JFrame {
	private JTextField txf_01;
	private JTextField txf_02;
	private JTextField txf_03;
	private JButton btnSaveButton;
	Ex02(){
		getContentPane().setLayout(null);
		
		JLabel lbl_Id = new JLabel("ID");
		lbl_Id.setBounds(58, 48, 85, 15);
		getContentPane().add(lbl_Id);
		
		JLabel lbl_Pw = new JLabel("PW");
		lbl_Pw.setBounds(58, 88, 85, 15);
		getContentPane().add(lbl_Pw);
		
		JLabel lbl_Comment = new JLabel("COMMENT");
		lbl_Comment.setBounds(58, 137, 85, 15);
		getContentPane().add(lbl_Comment);
		
		txf_01 = new JTextField();
		txf_01.setBounds(209, 45, 116, 21);
		getContentPane().add(txf_01);
		txf_01.setColumns(10);
		
		txf_02 = new JTextField();
		txf_02.setColumns(10);
		txf_02.setBounds(209, 85, 116, 21);
		getContentPane().add(txf_02);
		
		txf_03 = new JTextField();
		txf_03.setColumns(10);
		txf_03.setBounds(209, 134, 116, 21);
		getContentPane().add(txf_03);
		
		btnSaveButton = new JButton("Save Button");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input_id = txf_01.getText();
				String input_pw = txf_02.getText();
				String input_com = txf_03.getText();
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					String user = "hr";
					String pw = "1234";
					String url ="jdbc:oracle:thin:@localhost:1521:xe";
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url,user,pw);
					pstmt = conn.prepareStatement("insert into member"+
							"(id,pw,commentA)"+
							"values(?,?,?)");
					
					pstmt.setString(1, input_id);
					pstmt.setString(2, input_pw);
					pstmt.setString(3, input_com);
					pstmt.executeUpdate();
					
					System.out.println("¼º°ø");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					try {
						conn.close();
						
					}catch(SQLException e3) {
					e3.printStackTrace();
					}
				}
				
			}
		});
		btnSaveButton.setBounds(390, 106, 97, 23);
		getContentPane().add(btnSaveButton);
		
		setSize(640, 329);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex02();
	}
}

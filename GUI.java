
package attendance.system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener{
    
    private static JLabel user_label;
    private static JTextField userText;
    
    private static JLabel pwLabel;
    private static JPasswordField pwText;
    
    private static JButton login_button;
    
    private static JLabel success;
    public EmailChecker checker=new EmailChecker();
    ///////////////////
    public void _init_login()
    {
        //Create the frame
        JFrame f= new JFrame();
        f.setSize(500,180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     //Create the panel
        JPanel panel=new JPanel();
        f.add(panel);
        panel.setLayout(null);
        
        user_label = new JLabel("Email :");
        user_label.setBounds(10,20,80,25);
        panel.add(user_label);
        
        userText=new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);
        
        
        pwLabel = new JLabel("Password :");
        pwLabel.setBounds(10,50 ,80,25);
        panel.add(pwLabel);
        
        pwText=new JPasswordField();
        pwText.setBounds(100,50,165,25);
        panel.add(pwText);
        
        success=new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success); 
        
        
        login_button=new JButton("Login");
        login_button.setBounds(10,80,80,25);
        panel.add(login_button);
        f.setVisible(true);
        
    }
    public void _login_button()
    {
    login_button.addActionListener(this);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String email=userText.getText();
        String password=pwText.getText();
        if(checker.verify_email(email) && checker.verify_pass(password))
        {
            
        success.setText("Searching In DataBase !");
        
        }
        else
        {
        success.setText("Your information is invaled :( ");
        }
    }
    
    GUI()
    {
    _init_login();
    _login_button();
    }
    }
   
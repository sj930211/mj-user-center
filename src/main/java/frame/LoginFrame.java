package frame;

import model.UserEntity;
import org.apache.commons.lang3.StringUtils;
import service.LoginService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shenjian
 * @description 登录界面
 * @date 2019/11/30
 */
public class LoginFrame extends JFrame{

    /**
     * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
     */
    private static final long serialVersionUID = 1L;
    private static final String title = "重庆明净水处理设备有限公司";
    private JPanel contentPane;

    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JLabel accountLabel;
    private JLabel passwordLabel;
    private JLabel titleLabel;
    private JLabel viceTitleLabel;

    /**
     * 创建登录界面
     * @author shenjian
     * @date 2019/11/30
     * @param
     * @return
     */
    public LoginFrame(){
        // 设置窗口默认参数
        // 设置窗体是否可以调整大小，参数为布尔值
        setResizable(false);
        // 用户单击窗口的关闭按钮时程序执行的操作
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 设置窗口坐标
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // 窗口居中显示
        setLocationRelativeTo(contentPane);
        setContentPane(contentPane);
        setTitle(title);
        contentPane.setLayout(null);

        // 正文标题
        titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 25));
        titleLabel.setBounds(60, 50, 400, 40);

        contentPane.add(titleLabel);

        // 副标题
        viceTitleLabel = new JLabel("用户系统");
        viceTitleLabel.setForeground(Color.BLACK);
        viceTitleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        viceTitleLabel.setBounds(185, 100,100,35);
        contentPane.add(viceTitleLabel);

        // 账号label
        accountLabel = new JLabel("账号");
        accountLabel.setForeground(Color.BLACK);
        accountLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        accountLabel.setBounds(95, 160, 55, 20);
        contentPane.add(accountLabel);

        // 密码label
        passwordLabel = new JLabel("密码");
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        passwordLabel.setBounds(95, 200, 55, 18);
        contentPane.add(passwordLabel);

        // 账号输入框
        accountField = new JTextField();
        accountField.setFont(new Font("Dialog", Font.PLAIN, 15));
        accountField.setBounds(159, 160, 180, 22);
        contentPane.add(accountField);
        accountField.setColumns(10);

        // 密码输入框
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));
        passwordField.setBounds(159, 200, 180, 22);
        contentPane.add(passwordField);

        // 登录按钮
        loginButton = new JButton("登录");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 17));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLogin();
            }
        });
        loginButton.setBounds(170, 240, 95, 35);
        setLocationRelativeTo(loginButton);
        contentPane.add(loginButton);

    }

    public void checkLogin(){
        String account = accountField.getText();
        String password = new String(passwordField.getPassword());
        System.out.println("账号 -> " + account + "密码 -> " + password);
        if (StringUtils.isBlank(account)) {
            this.showError("请输入账号");
            return;
        }
        if (StringUtils.isBlank(password)) {
            this.showError("请输入密码");
            return;
        }
        LoginService loginService = new LoginService();
        Integer userId = loginService.checkUser(account, password);
        if (userId == null) {
            this.showError("用户名或密码错误");
            return;
        }
        UserEntity user = loginService.getUserById(userId);
        this.showError(user.getName() + "登录成功");

        CustomerQueryFrame.userId = user.getUserId();
        CustomerQueryFrame.name = user.getName();
        CustomerQueryFrame customerQueryFrame = new CustomerQueryFrame();
        customerQueryFrame.setVisible(true);
        CloseFrame();
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(this, message, "错误", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccess(String message){
        JOptionPane.showMessageDialog(this, message, "正确", JOptionPane.INFORMATION_MESSAGE);
    }


    public void CloseFrame() {
        super.dispose();
    }
}

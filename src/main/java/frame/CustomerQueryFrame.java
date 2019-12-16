package frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shenjian
 * @description 客户查询界面
 * @date 2019/12/4
 */
public class CustomerQueryFrame extends JFrame {

    /**
     * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
     */
    private static final long serialVersionUID = 1L;
    private static final String title = "重庆明净水处理设备有限公司-客户资料";
    private JPanel contentPane;
    private JScrollPane jScrollPane;
    private JMenuBar menuBar;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JButton queryButton;
    private JButton exportButton;
    private JButton addButton;
    private JButton delButton;
    private JTable table;

    public static Integer userId;
    public static String name;

    public static void main(String[] args) {
        try {
            CustomerQueryFrame frame = new CustomerQueryFrame();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CustomerQueryFrame(){
        // 设置窗口默认参数
        // 设置窗体是否可以调整大小，参数为布尔值
        setResizable(false);
        // 用户单击窗口的关闭按钮时程序执行的操作
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // 设置窗口坐标
        setBounds(100, 100, 1200, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // 窗口居中显示
        setLocationRelativeTo(contentPane);
        setContentPane(contentPane);
        setTitle(title);
        contentPane.setLayout(null);

        // 创建一个菜单栏
        menuBar = new JMenuBar();

        JMenu mainMenu = new JMenu("主界面");
        JMenu queryMenu = new JMenu("客户资料");
        JMenu aboutMenu = new JMenu("关于");
        // 设置选中状态
        queryMenu.setSelected(true);

        menuBar.add(mainMenu);
        menuBar.add(queryMenu);
        menuBar.add(aboutMenu);

        JMenuItem maxMenuItem = new JMenuItem("最大化");
        JMenuItem minMenuItem = new JMenuItem("最小化");
        JMenuItem exitMenuItem = new JMenuItem("退出");

        mainMenu.add(maxMenuItem);
        mainMenu.add(minMenuItem);
        // 添加一条分割线
        mainMenu.addSeparator();
        mainMenu.add(exitMenuItem);
        setJMenuBar(menuBar);

        // 姓名Label
        nameLabel = new JLabel("姓名");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        nameLabel.setBounds(100, 50,66,30);
        contentPane.add(nameLabel);

        // 姓名Field
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Dialog", Font.PLAIN, 15));
        nameTextField.setBounds(160, 50, 220, 30);
        contentPane.add(nameTextField);
        nameTextField.setColumns(10);

        // 手机号Label
        phoneLabel = new JLabel("手机");
        phoneLabel.setForeground(Color.BLACK);
        phoneLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        phoneLabel.setBounds(440, 50,66,30);
        contentPane.add(phoneLabel);

        // 手机号Field
        phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Dialog", Font.PLAIN, 15));
        phoneTextField.setBounds(510, 50, 220, 30);
        contentPane.add(phoneTextField);
        phoneTextField.setColumns(10);

        // 查询按钮
        queryButton = new JButton("查  询");
        queryButton.setFont(new Font("Dialog", Font.BOLD, 17));
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了查询按钮！");
            }
        });
        queryButton.setBounds(825, 48, 115, 33);
        setLocationRelativeTo(queryButton);
        contentPane.add(queryButton);

        // 导出按钮
        exportButton = new JButton("导  出");
        exportButton.setFont(new Font("Dialog", Font.BOLD, 17));
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了导出按钮！");
            }
        });
        exportButton.setBounds(975, 48, 115, 33);
        setLocationRelativeTo(exportButton);
        contentPane.add(exportButton);

        // 新增按钮
        addButton = new JButton("新增");
        addButton.setFont(new Font("Dialog", Font.BOLD, 13));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了新增按钮！");
            }
        });
        addButton.setBounds(80, 100, 80, 25);
        setLocationRelativeTo(addButton);
        contentPane.add(addButton);

        // 删除按钮
        delButton = new JButton("删除");
        delButton.setFont(new Font("Dialog", Font.BOLD, 13));
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了删除按钮！");
            }
        });
        delButton.setBounds(170, 100, 80, 25);
        setLocationRelativeTo(delButton);
        contentPane.add(delButton);

        Object[][] tableData =
                {
                        new Object[]{"李清照" , "1232131313" , "女", "女", "女", "女", "女", "女"},
                        new Object[]{"苏格拉底", 56 , "男", "女", "女", "女", "女", "女"},
                        new Object[]{"李白", 35 , "男", "女", "女", "女", "女", "女"}
                };
        //定义一维数据作为列标题
        String[] columnTitle = {"客户姓名" , "客户电话" , "租赁机型", "签约时间", "租赁年限", "缴费年限", "缴费日期", "安装地址"};
        // 表格
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(80, 140,1050,550);
        jScrollPane.setFont(new Font("Dialog", Font.BOLD, 15));
        table = new JTable(tableData, columnTitle);
        table.setBounds(80, 140,1050,550);
        table.setFont(new Font("Dialog", Font.BOLD, 13));
        setLocationRelativeTo(table);
        jScrollPane.setViewportView(table);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
    }
}

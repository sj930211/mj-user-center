package frame;

import database.DataBaseTools;
import jdk.nashorn.internal.runtime.logging.Logger;
import service.SignService;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

/**
 * @author shenjian
 * @description 主程序入口
 * @date 2019/11/30
 */
public class MainFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    SignService signService = new SignService();
                    signService.firstCome();
                    LoginFrame loginFrame = new LoginFrame();
                    // /设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了
                    loginFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

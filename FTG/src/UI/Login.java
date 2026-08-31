package UI;

import domain.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Login {
    ArrayList<User> userList = new ArrayList<>();
    public void start() {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("┌────────────────────────┐");
            System.out.println("     🎮 欢迎来到文字格斗游戏 🎮     ");
            System.out.println("└────────────────────────┘");
            System.out.println("请选择操作：1登录 2注册 3退出");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(userList);
                    break;
                case 2:
                    register(userList);
                    break;
                case 3:
                    System.out.println("退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效的选择");
            }
        }

    }

    ;

    public  void login(ArrayList<User> userList) {
        System.out.println("登录");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        if(isUserNameUnique(username, userList)){
            System.out.println("用户名不存在,请先注册再登录");
            return;
        }

        if(findUserIndex(username, userList) == -1) {
            System.out.println("用户名不存在,请先注册再登录");
            return;
        }
           int index = findUserIndex(username, userList);
           User user = userList.get(index);
           if( user.isState()) {
              System.out.println("账号已封禁，请联系管理员");
              return;
           }

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入密码");
            String password = sc.next();
            while (true){
                if(checkCaptcha()) break;
            }
            if(user.getPassword().equals(password)){
                System.out.println("登录成功！");
                break;
            }else {
                if(i == 2){
                    user.setState(true);
                    System.out.println("账号已封禁，请联系管理员");
                    return;
                }else {
                    System.out.println("密码错误，请重新登录,还剩下" + (2 - i) + "次机会");
                }

            }
        }





    }

    public  void register(ArrayList<User> userList) {
        System.out.println("注册");
        String username = setUserName(userList);
        System.out.println("请输入密码");
        String password1 = setPassword(userList);
        System.out.println("请再次输入密码");
        String password2 = setPassword(userList);
        while (true){
            if(password1.equals(password2)) break;
            System.out.println("两次输入的密码不一致，请重新输入");
            password1 = setPassword(userList);
            System.out.println("请再次输入密码");
            password2 = setPassword(userList);
        }

        if(checkCaptcha()){
            User user = new User(username, password1,false);
            userList.add(user);
            System.out.println("注册成功！");
            start();
        }
    }
    public String setUserName(ArrayList<User> userList) {
        //1.用户名唯一
        //2.长度必须在3~16位
//3.只能由字母、数字组成，不能是纯数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        boolean isTrue = false;
        
        while (!isTrue){

            if(username.length() < 3 || username.length() > 16){
                System.out.println("用户名长度必须在3~16位");
                isTrue = false;
                System.out.println("请输入用户名");
                username = sc.next();
            } else if (!username.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z0-9]+$")) {
                isTrue = false;
                System.out.println("由字母、数字组成，不能是纯数字");
                System.out.println("请输入用户名");
                username = sc.next();
            }else if(!isUserNameUnique(username, userList)){
                System.out.println("用户名已存在");
                System.out.println("请输入用户名");
                username = sc.next();
            }else {
                isTrue = true;
            }
        }
        return username;
    }
    public String setPassword(ArrayList<User> userList){
        Scanner sc = new Scanner(System.in);

        String password = sc.next();
        boolean isTrue = false;
        while (!isTrue){
            if(password.length() < 3 || password.length() > 8){
                System.out.println("密码长度必须在3~8位");
                isTrue = false;
                System.out.println("请输入密码");
                password = sc.next();
            } else if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z0-9]+$")) {
                isTrue = false;
                System.out.println("由字母、数字组成，不能是纯数字");
                System.out.println("请输入密码");
                password = sc.next();
            }else {
                isTrue = true;
            }
        }
        return password;
    }
    public Boolean isUserNameUnique(String username, ArrayList<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    };
    public int findUserIndex( String username,ArrayList<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            if ( userList.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
    public  Boolean checkCaptcha() {
        while (true){
            System.out.println("请输入验证码");
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

            Random random = new Random();
            StringBuilder code = new StringBuilder();

            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(chars.length());
                code.append(chars.charAt(index));
            }
            String captcha = code.toString();
            System.out.println("验证码为：" + captcha);
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if (input.equals(captcha)) {
                return true;
            } else {
                System.out.println("验证码错误，请重新输入");
            }
        }
    }
    
}

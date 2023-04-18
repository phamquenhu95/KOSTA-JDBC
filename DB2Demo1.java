package mySQLex;

import java.sql.*;

public class DB2Demo1 {
  public static void main(String[] args) {
    Connection conn = makeConnection();
//    Statement stmt = null;
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement("insert into Customer " +
          " values (?, ?, ?, ?)"); // xuong dong thi phai cach o ngoac sau ( 한 칸 띄어)
      ps.setInt(1, 8);
      ps.setString(2, "손홍민");
      ps.setString(3, "영국");
      ps.setString(4, "010-1234-5678");

      int i = ps.executeUpdate();
      if (i > 0) {
        System.out.println(i + "건 레코드 추가 성공되었습니다.");
      } else {
        System.out.println(i + "건 레코드 추가 실패되었습니다.");
      }
      } catch(SQLException e) {
        System.out.println(e.getMessage());

      }
    }

  public static Connection makeConnection() {

    String url = "jdbc:mysql://localhost:3306/madang?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    Connection conn = null;

    try {
      System.out.println("데이터베이스 연결중.........");
      conn = DriverManager.getConnection(url,"root", "1111");
      System.out.println("데이터베이스 연결 성공!");
    } catch (SQLException e) {
      System.out.println("데이터베이스 연결 실패!");
      System.out.println(e.getMessage());

    }
    return conn;
  }
}

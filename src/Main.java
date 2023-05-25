import java.sql.*;

public class Main {
    public static void main(String[] args) {

//       Connetion connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Study","root","");
//        connection.close();  //关闭连接， autocloseable接口会自动帮我们关闭

        //1. 通过DriverManager来获得数据库连接
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Study","root","13@Myself");
             //2. 创建一个用于执行SQL的Statement对象
             Statement statement = connection.createStatement()){   //注意前两步都放在try()中，因为在最后需要释放资源！
            //3. 执行SQL语句，并得到结果集

            /*
            DML语句：insert, delete, update
             */

            //插入语句
            //int i = statement.executeUpdate("insert into student values(034, 'Zhi', 'felmale')" );
            //System.out.println("it works : " + i + " row");

            //删除语句
            //statement.executeUpdate("delete from student where sid = 034");
            //System.out.println("delete works");

            //更新语句
            //statement.executeUpdate("update student set name_s = 'hhahah' where sid = 033");
            //System.out.println("update works");

            /*
            DQL语句：select
             */
//            ResultSet set = statement.executeQuery("select * from student");

            /*
            批量处理
             */
//            statement.addBatch("insert into student values(035, 'Connie', 'felmale')");
//            statement.addBatch("insert into student values(036, 'Mellisa', 'felmale')");
//
//            statement.executeBatch();

            //4. 查看结果
//            while (set.next()) //next()方法返回一个boolean值，如果有下一行，返回true，否则返回false
//            {
//                System.out.println(set.getString(1)); //列从1开始
//                System.out.println(set.getString(2));
//                System.out.println(set.getString(3));
//            }

            /*
            将查询结果映射为对象
             */
            ResultSet set = statement.executeQuery("select * from student");
            while(set.next()){
                Student student = new Student(set.getInt(1), set.getString(2), set.getString(3));
                student.say();

            }


        }catch (SQLException e){
            e.printStackTrace();
        }
//5. 释放资源，try-with-resource语法会自动帮助我们close
    }
}
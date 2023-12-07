 /***********************************************************************
 * Module:  UsersFactory.java
 * Author:  ASUS
 * Purpose: Defines the Class UsersFactory
 ***********************************************************************/

package org.user;

 import org.outer.DatabaseAccess;
 import java.sql.ResultSet;
 import java.sql.SQLException;

 /** @pdOid d06b0eaa-33e1-4b6e-828e-697b92f50088 */
public class UserFactory {
   /** @pdOid 8d3c7087-6c53-42c4-8957-f886c96b43c8 */
   private String defaultPassword = "123456";

   private String getDefaultPassword(int id) {
       return defaultPassword;
   }

   private UserManager manager;



   // 借助jdbc访问数据库得到的ResultSet自动创建用户,保存至UserManager中
   public void autoCreateUser(UserManager manager, DatabaseAccess dba) throws SQLException {
       // TODO: implement

       ResultSet resultSet = dba.queryUsers("student");
       while(resultSet.next()) {
           int studentID = resultSet.getInt("studentID");
           String studentName = resultSet.getString("studentName");
           int phoneNumber = resultSet.getInt("phoneNumber");
           String password = getDefaultPassword(studentID);

           Student student = new Student(studentName, password, phoneNumber, studentID);
           manager.addStudent(student);
       }

       resultSet = dba.queryUsers("teacher");
       while(resultSet.next()) {
           int teacherID = resultSet.getInt("teacherID");
           String teacherName = resultSet.getString("teacherName");
           int phoneNumber = resultSet.getInt("phoneNumber");
           String password = getDefaultPassword(teacherID);

           Teacher teacher = new Teacher(teacherName, password, phoneNumber, teacherID);
           manager.addTeacher(teacher);
       }

       Administrator admin = Administrator.getInstance("admin", getDefaultPassword(0));
       manager.setAdmin(admin);
   }

}
 /***********************************************************************
 * Module:  DatabaseAccess.java
 * Author:  ASUS
 * Purpose: Defines the Class DatabaseAccess
 ***********************************************************************/

package org.outer;
import org.course.Course;
import org.user.Student;
import org.user.User;
import org.user.UserFactory;
import org.user.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

/** @pdOid dda27522-658b-42c2-9f88-b0ec87a8a0d5 */
public class DatabaseAccess {
   /** @pdOid 80e898f3-c08c-4a86-a809-7e905d4e43ee */
   private String dbPassword;
   /** @pdOid d0fc432a-ded2-4d1b-a2a4-dcbf37c3a7f6 */
   private String dbUsername;
   /** @pdOid 49c446cd-1e52-4f06-a2ac-73873acede8a */
   private String jdbcUrl;

   public DatabaseAccess(String jdbcUrl, String dbUsername, String dbPassword) {
      this.jdbcUrl = jdbcUrl;
      this.dbUsername = dbUsername;
      this.dbPassword = dbPassword;
   }

   public ResultSet queryUsers(String userType) {
      // TODO: implement
      ResultSet resultSet = null;
      if(userType.equals("student")) {
         //查询Student表
      }
      if(userType.equals("teacher")) {
         //查询Teacher表
      }
      return resultSet;
   }
   
   /** @param courseID 
    * @param studentID
    * @pdOid e5a2c634-d844-41e1-a8a8-28eb881c6e81 */
   public void addEnrollment(int courseID, int studentID) {
      // TODO: implement
   }
   
   /** @param course
    * @pdOid 390f6629-8ced-4d74-b348-a6046ac783c8 */
   public void addCourse(Course course) {
      // TODO: implement
   }

}
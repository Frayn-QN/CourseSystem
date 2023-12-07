 /***********************************************************************
 * Module:  UsersManager.java
 * Author:  ASUS
 * Purpose: Defines the Class UsersManager
 ***********************************************************************/

package org.user;
import java.util.*;

/** @pdOid ed1a3530-a3b3-440e-a401-f9c49b9cc446 */
public class UserManager {
   /** @pdOid 2b50bac1-4bfd-422f-b2a2-a2e42f292310 */
   private List<Student> students;
   /** @pdOid 78379368-3b46-4721-92f6-281d1081bbad */
   private List<Teacher> teachers;
   /** @pdOid 9f9995f5-ae49-44bc-8c59-a4957528dd7e
       @pdRoleInfo migr=yes name=Administrator assc=association12 */
   private Administrator admin;
   
   /** @param student
    * @pdOid c6d189fb-6c66-42f7-b0ae-03baa8e762aa */
   public void addStudent(Student student) {
      // TODO: implement
      students.add(student);
   }
   
   /** @param teacher
    * @pdOid bb22755a-e4e9-44aa-a54e-fd4e8abe620d */
   public void addTeacher(Teacher teacher) {
      // TODO: implement
      teachers.add(teacher);
   }

   public void setAdmin(Administrator admin) {
      this.admin = admin;
   }

   /** @param studentID
    * @pdOid 340d7a29-719f-47a4-921a-694484baf344 */
   public Student getStudent(int studentID) {
      // TODO: implement
      for(Student student: students) {
         if(student.getStudentID() == studentID)
            return student;
      }
      return null;
   }
   
   /** @param teacherID
    * @pdOid 0fca57c0-e31d-44c9-b9c9-83fae534bbb7 */
   public Teacher getTeacher(int teacherID) {
      // TODO: implement
      for(Teacher teacher: teachers) {
         if(teacher.getTeacherID() == teacherID) {
            return teacher;
         }
      }
      return null;
   }
   
   /** @param username
    * @pdOid 42775b5f-a6b7-45e2-b138-25883621716a */
   public User getUser(String username) {
      // TODO: implement
      for(Student student: students) {
         if(student.getUsername().equals(username)) {
            return student;
         }
      }

      for(Teacher teacher: teachers) {
         if(teacher.getUsername().equals(username)) {
            return teacher;
         }
      }

      if(admin.getUsername().equals(username))
         return admin;

      return null;
   }

}
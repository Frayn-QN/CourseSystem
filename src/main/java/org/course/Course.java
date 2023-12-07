 /***********************************************************************
 * Module:  Course.java
 * Author:  ASUS
 * Purpose: Defines the Class Course
 ***********************************************************************/

package org.course;
import java.util.*;

import org.jetbrains.annotations.NotNull;
import org.outer.DatabaseAccess;
import org.user.Student;
import org.user.Teacher;

 /** @pdOid 6fd7c747-4ee2-4140-892e-400e5c94d58f */
public class Course extends CourseSubject {
   /** @pdOid a28c67c4-6ead-46d9-a763-50a3114ff23e */
   int courseID;
   /** @pdOid 109916ab-a0a9-428b-a49a-48b912991476 */
   private String courseName;
   /** @pdOid 043e5484-4126-47ae-a66e-838976739275 */
   private Teacher teacher;
   /** @pdOid 9881f1a8-dffc-4012-9429-1c1c702fe617 */
   private List<Student> enrolledStudents;
   /** @pdOid 02d082c3-16ee-40b8-b8f6-91c452669282 */
   private int capacity;
   /** @pdOid 634a7f6f-0f2a-40f2-9d53-6ee0eb95272f
       @pdRoleInfo migr=yes name=Timetable assc=association7 */
   private Timetable timetable;
   /** @pdOid 67813134-4df3-4a83-9bf6-2a5803fbc051 */

   Map<Student, Integer> firstRoundStudents;

   private String classroom;

   private static int currentCourseID = 0;
   public Course(String courseName,@NotNull Teacher teacher, int capacity, Timetable timetable) {
      this.courseID = currentCourseID;
      currentCourseID ++;
      this.courseName = courseName;
      this.teacher = teacher;
      this.capacity = capacity;
      this.timetable = timetable;
      registerObserver(teacher);
   }

   public boolean hasConflict(@NotNull Course course) {
      if(course.timetable.hasConflict(this.timetable)
              && this.classroom.equals(course.classroom))
         return true;
      return false;
   }

   public Timetable getTimetable() {
      return this.timetable;
   }

//   public int getCourseID() {
//      return this.courseID;
//   }

    public List<Student> getEnrolledStudents() {
      return  this.enrolledStudents;
    }
   
   /** @pdOid 5171e6da-81ab-4080-9f4b-ebcfcabd4d31 */
   public int getRemainNum() {
      // TODO: implement
      return this.capacity - this.enrolledStudents.size();
   }
   
   /** @pdOid 00b48070-79b9-4caf-8a9a-955a053f67a4 */
   public List<Student> viewEnrolledStudents() {
      // TODO: implement
      return this.enrolledStudents;
   }

   /** @param student
    * @pdOid ce736a8a-3a31-4f78-8fec-d6c76b8705ae */
   // 除一轮外添加学生
   public synchronized void addStudent(Student student) {
      // TODO: implement
      if(getRemainNum()> 0) {
         enrolledStudents.add(student);
         registerObserver(student);
         student.update(this);
      }
   }

   // 一轮选课时添加学生
   public void addStudent(Student student, int weight) {
      enrolledStudents.add(student);
      firstRoundStudents.put(student, weight);

      // 注册为观察者
      registerObserver(student);

      // 使用update接口方法单独通知
      student.update(this);
   }
   
   /** @param student
    * @pdOid 32560446-deff-421d-b09e-c859ad33a1ed */
   public void deleteStudent(@NotNull Student student) {
      // TODO: implement
      student.update(this);
      removeObserver(student);
      if(enrolledStudents.contains(student)) {
         enrolledStudents.remove(student);
      }
      if(firstRoundStudents.containsKey(student)) {
         firstRoundStudents.remove(student);
      }
   }
   
   /** @param dba
    * @pdOid bfba9e53-e747-4845-b11f-20532e1d8f4c */
   public void addEnrollment(DatabaseAccess dba) {
      // TODO: implement
      for(Student student: this.enrolledStudents) {
         dba.addEnrollment(this.courseID, student.getStudentID());
      }
   }

   @Override
   public void notifyObserver() {
      for(CourseObserver observer: super.getObservers()) {
         observer.update(this);
      }
   }
}
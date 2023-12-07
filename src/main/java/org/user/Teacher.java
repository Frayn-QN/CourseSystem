 /***********************************************************************
 * Module:  Teacher.java
 * Author:  ASUS
 * Purpose: Defines the Class Teacher
 ***********************************************************************/

package org.user;
import org.course.Course;
import org.course.CourseManager;
import org.course.CourseObserver;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/** @pdOid cc4f7fe3-73d3-488b-ab17-a0ff9bb17753 */
public class Teacher extends User implements CourseObserver {
   /** @pdOid f79c4b63-6336-4ae7-93f9-a21e7aab6ac2 */
   private String teacherName;
   /** @pdOid ac9ae6c8-c160-49c4-a9d2-fb90b665573e */
   private int teacherID;
   /** @pdOid 74e1c08b-0cb0-4c70-bcce-e52ca9d0e392 */
   private List<Course> coursesTaught = new ArrayList<>();

   public Teacher(String teacherName, String password, int phoneNO, int teacherID) {
      super(teacherName, password);
      setPhoneNumber(phoneNO);
      this.teacherID = teacherID;
      this.teacherName = teacherName;
   }

   public int getTeacherID() {
      return this.teacherID;
   }
   
   /** @param manager 
    * @param course
    * @pdOid 733074fb-311b-46f5-8e29-bb5081bedf08 */
   public void manageCourse(CourseManager manager, Course course) {
      // TODO: implement
      if(logStatus()){
         //postCourse(manager, course);
         //deleteCourse(manager, course);
         //未完成修改课程信息
      }
   }

   public void postCourse(@NotNull CourseManager manager, Course course) {
      if(logStatus()) {
         manager.postCourse(course);
      }
   }

   public void deleteCourse(@NotNull CourseManager manager, Course course) {
      if(logStatus()) {
         manager.deleteCourse(course);
      }
   }


   @Override
   public void update(Course course) {
      if(coursesTaught.contains(course)) {
         coursesTaught.remove(course);
      }
      else {
         coursesTaught.add(course);
      }
   }


}
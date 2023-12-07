 /***********************************************************************
 * Module:  Student.java
 * Author:  ASUS
 * Purpose: Defines the Class Student
 ***********************************************************************/

package org.user;
import org.course.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/** @pdOid bead8af4-e6b9-4ac6-a263-ad706f653a0f */
public class Student extends User implements CourseObserver {
   /** @pdOid 41d6d64d-6fe0-4178-96f0-653718604b79 */
   private String studentName;
   /** @pdOid be35f983-b3a1-4110-b63f-63af9bc44a70 */
   private int studentID;
   /** @pdOid f39e19e2-9bf1-43c3-8426-e6c85cd3fa07 */
   private List<Course> coursesEnrolled = new ArrayList<>();
   private Map<Course, Integer> coursesFirstRound = new HashMap<>();
   /** @pdOid d0536cfb-31e0-41f3-8a38-69aa6cb6d9b9 */
   private int weightsRemain;

   public Student(String studentName, String password, int phoneNumber, int studentID) {
      super(studentName, password);
      setPhoneNumber(phoneNumber);
      this.studentID = studentID;
      this.studentName = studentName;
   }

   public int getStudentID() {
      return this.studentID;
   }

   /** @param course 
    * @param weight
    * @pdOid 5cffa347-faff-4acd-8019-8a9452bf3c8b */
   public void selectCourse(Course course, int weight) {
      // TODO: implement
      if(logStatus()) {
         // 判断课程时间是否冲突
         boolean canSelect = !(coursesEnrolled.contains(course) || coursesFirstRound.containsKey(course));
         for(Course course1: coursesEnrolled) {
            if(course.getTimetable().hasConflict(course1.getTimetable())) {
               canSelect = false;
               break;
            }
         }
         canSelect = canSelect && (weightsRemain - weight) >= 0;

         if(canSelect) {
            this.weightsRemain -= weight;
            course.addStudent(this, weight);
            while(!coursesEnrolled.contains(course));
            coursesFirstRound.put(course, weight);
         }
      }
   }
   
   /** @param course
    * @pdOid c3d47476-0c78-4ccd-adc6-8ce05dc53496 */
   public void selectCourse(Course course) {
      // TODO: implement
      if(logStatus()) {
         boolean canSelect = !coursesEnrolled.contains(course);
         for(Course course1: coursesEnrolled) {
            if(course.getTimetable().hasConflict(course1.getTimetable())) {
               canSelect = false;
               break;
            }
         }

         if(canSelect) {
            course.addStudent(this);
         }
      }
   }
   
   /** @param course
    * @pdOid 320afa7c-2f1b-46cb-938f-4553123922de */
   // 被动退课
   public void dropCourse(Course course) {
      // TODO: implement
      if(coursesFirstRound.containsKey(course)) {
         this.weightsRemain += coursesFirstRound.get(course);
         coursesFirstRound.remove(course);
      }
      if(coursesEnrolled.contains(course)) {
         coursesEnrolled.remove(course);
      }
   }

   // 主动退课
   public void quitCourse(@NotNull Course course) {
      if(logStatus()) {
         if(coursesEnrolled.contains(course)) {
            course.deleteStudent(this);
         }
      }
   }
   
   /** @param manager
    * @pdOid 7c1ac170-4ef1-44db-82b1-9fcd147132f1 */
   public List<Course> viewCoursesAvailable(CourseManager manager) {
      // TODO: implement
      if(logStatus()) {
         return manager.getCoursesAvailable();
      }
      return null;
   }
   
   /** @pdOid e0d317a2-ee00-471b-958c-6be876d362ba */
   // Course[第i周][星期j][第k节课]
   public Course[][][] generateCourseTable() {
      // TODO: implement
      if(logStatus()) {
         Course[][][] courseTable = new Course[20][10][7];
         for(Course course: coursesEnrolled) {
            Timetable timetable = course.getTimetable();
            for(Day day: timetable.classTimes.keySet()) {
               List<Integer> classes = timetable.classTimes.get(day);
               for(int class_: classes) {
                  for(int i= timetable.startWeek; i<= timetable.endWeek; i++) {
                     courseTable[i -1][day.getDayNumber() -1][class_ -1] = course;
                  }
               }
            }
         }

         return courseTable;
      }

      return null;
   }

   @Override
   public void update(Course course) {
      if(coursesEnrolled.contains(course)) {
         dropCourse(course);
      }
      else {
         coursesEnrolled.add(course);
      }
   }
}
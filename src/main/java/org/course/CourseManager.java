 /***********************************************************************
 * Module:  CourseManager.java
 * Author:  ASUS
 * Purpose: Defines the Class CourseManager
 ***********************************************************************/

package org.course;
import org.jetbrains.annotations.NotNull;
import org.outer.DatabaseAccess;
import org.user.Student;

import java.util.*;

/** @pdOid 048c335a-e107-42c2-a26c-5cadf5be0b50 */
public class CourseManager {
   /** @pdOid 2c0008a9-4a2c-494f-b43f-6a89f805f6f4 */
   private List<Course> coursesCreated = new ArrayList<>();
   /** @pdOid c42ff610-46d3-42e6-a03b-216a5c84dfa7 */
   private List<Course> coursesAvailable = new ArrayList<>();

   private int minStudent = 0;

   public void setMinimumStudent(int minStudent) {
      this.minStudent = minStudent;
   }
   
   /** @param course
    * @pdOid f41454e5-3b09-4aa3-a998-5ea601997715 */
   public void reviewCourse(Course course) {
      // TODO: implement
      if(coursesCreated.contains(course)) {
         for(Course courseAvailable: coursesAvailable) {
            if(!courseAvailable.hasConflict(course)) {
               coursesCreated.remove(course);
               coursesAvailable.add(course);
               course.notifyObserver();
            }
         }
      }

   }
   
   /** @param course
    * @pdOid 2ffb26e1-cc81-40da-b18a-b77f1a1f1519 */
   public void postCourse(Course course) {
      // TODO: implement
      coursesCreated.add(course);
   }
   
   /** @param course
    * @pdOid 6ffa0e84-b190-4730-9c11-3876e1ed2c9c */
   // 从系统中删除课程
   public void deleteCourse(Course course) {
      // TODO: implement
      coursesCreated.remove(course);
      coursesAvailable.remove(course);

      course.notifyObserver();
   }
   
   /** @pdOid 6a400a17-f4b4-478e-bbba-5c0a3c72bd27 */
   // 一轮选课后：
   //    重新排课
   //    达到上限的课程直接记录到数据库并移出列表
   public void dealFirstRound(DatabaseAccess dba) {
      // TODO: implement
      for(Course course: coursesAvailable) {
         if(course.getRemainNum() < 0) {
            List<Map.Entry<Student, Integer>> entryList = new ArrayList<>(course.firstRoundStudents.entrySet());
            //打乱顺序以保证随机性
            Collections.shuffle(entryList);
            //按从小到大排序
            entryList.sort(Comparator.comparing(Map.Entry::getValue));

            int needToDrop = -course.getRemainNum();
            for(int i= 0; i< needToDrop; i++) {
               //应调用Course类的deleteStudent方法来同时处理两个类的选课信息
               course.deleteStudent(entryList.get(i).getKey());
            }
         }
         if(course.getRemainNum() == 0) {
            course.addEnrollment(dba);
            addCourseToDB(course,dba);
            coursesAvailable.remove(course);
         }

         course.firstRoundStudents.clear();
      }
   }

   // 二轮抢课后：
   //    删除人数不足的课程
   //    记录选课信息到数据库
   public void dealSecondRound(DatabaseAccess dba) {
      for(Course course: coursesAvailable) {
         if(course.getEnrolledStudents().size() < minStudent) {
            deleteCourse(course);
            continue;
         }
         course.addEnrollment(dba);
         addCourseToDB(course, dba);
      }
      coursesAvailable.clear();
   }
   
   /** @pdOid 69160e09-7bd4-4da0-93ec-814634697cd5 */
   public List<Course> getCoursesAvailable() {
      // TODO: implement
      return coursesAvailable;
   }
   
   /** @param courseID
    * @pdOid 7e5c868e-648b-4eeb-9719-5c8efc2aa74a */
   public Course getCourse(int courseID) {
      // TODO: implement
      for(Course course: coursesAvailable) {
         if(course.courseID == courseID)
            return course;
      }
      return null;
   }
   
   /** @param course 
    * @param dba
    * @pdOid d1489f0a-f393-4f2e-8c92-7a60b863e2c0 */
   public void addCourseToDB(Course course, @NotNull DatabaseAccess dba) {
      // TODO: implement
      dba.addCourse(course);
   }

}
 /***********************************************************************
 * Module:  Administrator.java
 * Author:  ASUS
 * Purpose: Defines the Class Administrator
 ***********************************************************************/

package org.user;
import org.announce.*;
import org.course.Course;
import org.course.CourseManager;

import java.util.*;

/** @pdOid 1e58f6ed-d00b-4ec9-819a-ada86b5047d8 */
public class Administrator extends User {
   /** @pdOid 53b08684-07f4-47a6-961d-59560d3f0162 */
   private int adminID;
   /** @pdOid b9d0e105-9f32-4e08-9ce0-1b28f85212ac */
   private String adminName;
   /** @pdOid 9ae5c287-3092-4039-ace0-efe3d6545f17 */
   /** @pdRoleInfo migr=no name=Administrator assc=association9 type=Aggregation */
   private static Administrator instance;

   private Administrator(String username, String password) {
      super(username, password);
      this.adminID = 0;
      this.adminName = username;
   }
   
   /** @param manager 
    * @param user
    * @pdOid 0f20d85f-6a98-48ae-8b57-fa5d1f3ed76e */
   public void manageUsers(UserManager manager, User user) {
      // TODO: implement
   }
   
   /** @param manager 
    * @param announcement
    * @pdOid 453673ae-4bfc-4b6e-98b9-8f28a06c3f86 */
   public void manageAnnouncement(AnnouncementManager manager, Announcement announcement) {
      // TODO: implement
      if(logStatus()) {
         manager.postAnnouncement(announcement);
      }
   }

   /** @param manager 
    * @param course
    * @pdOid 81ca8660-fb2a-4d84-ae55-f3dc4defc6f6 */
   public void manageCourses(CourseManager manager, Course course) {
      // TODO: implement
   }
   
   /** @param student 
    * @param course
    * @pdOid 5e7742d5-d828-4225-8fde-78cc2ad7d15e */
   public void helpSelectCourse(Student student, Course course) {
      // TODO: implement
      if(logStatus()) {
         course.addStudent(student);
      }
   }
   
   /** @pdOid c811d021-f216-40e6-a0e1-483bb88d2769 */
   public static Administrator getInstance(String username, String password) {
      // TODO: implement
      if(instance == null) {
         instance = new Administrator(username, password);
      }
      return instance;
   }

}
/***********************************************************************
 * Module:  Announcement.java
 * Author:  ASUS
 * Purpose: Defines the Class Announcement
 ***********************************************************************/

package org.announce;
import java.util.*;
import org.user.Administrator;

/** @pdOid 52ce6318-6be1-47f1-926d-528f49092939 */
public class Announcement {
   /** @pdOid 8cdca86b-e139-4759-bf2f-44cc9fb5856d */
   private int announcementID;
   /** @pdOid e7191cac-c8ec-4d34-b636-c27f7a34c328 */
   private String content;
   /** @pdOid 967ddac1-ebdc-4c6f-8d86-e1b35c55a165 */
   private Administrator postBy;
   /** @pdOid 07a928c7-04c9-4884-a0ef-5e5335cf10f0 */
   private Date postDate;

   private static int currentAnnouncement = 0;
   public Announcement(String content, Administrator admin) {
      this.announcementID = currentAnnouncement;
      currentAnnouncement++;
      this.content = content;
      this.postBy = admin;
      this.postDate = new Date();
   }

   
   /** @pdOid 71046db4-20f0-4df5-bd25-2f1ad99b02eb */
   public String getContent() {
      // TODO: implement
      return this.content;
   }

}
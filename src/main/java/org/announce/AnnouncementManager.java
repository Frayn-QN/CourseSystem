/***********************************************************************
 * Module:  AnnouncementManager.java
 * Author:  ASUS
 * Purpose: Defines the Class AnnouncementManager
 ***********************************************************************/

package org.announce;
import java.util.*;

/** @pdOid 65e3ce5c-2456-4a42-9bc1-8404df90321d */
public class AnnouncementManager {
   /** @pdOid a08cc8e7-9456-4dee-bed7-9c9a3d4f1d00 */
   private List<Announcement> announcements = new ArrayList<>();

   /** @param announcement
    * @pdOid 0b18ec8f-5536-463f-bf26-519133cded00 */
   public void postAnnouncement(Announcement announcement) {
      // TODO: implement
      this.announcements.add(announcement);
   }
   
   /** @pdOid 98c001ff-300c-402a-8f45-2e2c29536e22 */
   public List<Announcement> viewAnnouncements() {
      // TODO: implement
      return this.announcements;
   }
   
   /** @param announcement
    * @pdOid 7909f082-bc70-4447-8a21-6e84bccdc921 */
   public void deleteAnnouncement(Announcement announcement) {
      // TODO: implement
      this.announcements.remove(announcement);
   }

}
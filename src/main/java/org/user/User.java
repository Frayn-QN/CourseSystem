 /***********************************************************************
 * Module:  User.java
 * Author:  ASUS
 * Purpose: Defines the Class User
 ***********************************************************************/

package org.user;
import org.announce.*;

import java.util.*;

/** @pdOid 3136a901-598c-448e-8d05-1c7008039c96 */
public class User {
   /** @pdOid 64441cd5-ce9e-46f9-ac99-d78ea5470a8a */
   private String username;
   /** @pdOid 3865a641-d572-4d38-97ec-8f11f07f0a1b */
   private String password;
   /** @pdOid 2cd50a87-1f34-4aa8-af09-d777809a4b3b */
   private int userID;
   /** @pdOid c0c57e21-b0bb-4a77-982a-492f70fc323c */
   private int phoneNumber;
   /** @pdOid 95ac5359-abc4-45a5-9869-c3fb3ae175ab */
   private boolean isLoggedIn;

   public boolean logStatus() {
      return isLoggedIn;
   }

   private static int currentUserID = 0;

   public String getUsername() {
      return this.username;
   }

   public User(String username, String password) {
      this.username = username;
      this.password = password;
      this.userID = currentUserID;
      currentUserID ++;
      this.isLoggedIn = false;
   }

   public void setPhoneNumber(int phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public void setUsername(String username) {
      this.username = username;
   }
   
   /** @param enteredPasswd
    * @pdOid 87dbbfa6-f14f-43b2-8c52-1291d8f29408 */
   public boolean login(String enteredPasswd) {
      // TODO: implement
      if(enteredPasswd == this.password) {
         isLoggedIn = true;
      }
      return isLoggedIn;
   }
   
   /** @pdOid f7ea0eb9-7ee3-459d-aca1-5ac2ae9210c5 */
   public void logout() {
      // TODO: implement
      if(isLoggedIn) {
         isLoggedIn = false;
      }
   }
   
   /** @param newPasswd
    * @pdOid 9a189bc2-a6bd-4f2a-9b19-ab5d13d887bf */
   public void changePasswd(String newPasswd) {
      // TODO: implement
      if(isLoggedIn) {
         this.password = newPasswd;
      }
   }
   
   /** @param manager
    * @pdOid 3d800251-46b5-44dc-be6a-ad48fe384983 */
   public List<Announcement> viewAnnouncement(AnnouncementManager manager) {
      // TODO: implement
      if(isLoggedIn) {
         return manager.viewAnnouncements();
      }
      return null;
   }

}
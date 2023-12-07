 /***********************************************************************
 * Module:  Authentication.java
 * Author:  ASUS
 * Purpose: Defines the Class Authentication
 ***********************************************************************/

package org.outer;
import org.user.User;
import org.user.UserManager;

import java.util.*;

// 可在此加入与其他系统关联的用户认证
/** @pdOid fa292e2b-f803-4d26-8cf9-de12e151331a */
public class Authentication {
   /** @pdOid 228ec880-af66-4ed6-8864-ecdd03150006 */
   private UserManager userManager;

   public void setUserManager(UserManager manager) {
      this.userManager = manager;
   }

   /** @param username
    * @param password
    * @pdOid 70aa7645-a78a-41d1-bef7-75c32d15f264 */
   public User login(String username, String password) {
      // TODO: implement
      User user = userManager.getUser(username);
      if(user.login(password))
         return user;
      return null;
   }

   public User login(int id, String password) {
      User user;
      user = userManager.getStudent(id);
      if(user != null && user.login(password))
         return user;
      user = userManager.getTeacher(id);
      if(user != null && user.login(password))
         return user;

      return null;
   }

}
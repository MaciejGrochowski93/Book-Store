package maciej.grochowski.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

        @Autowired
        private UserService userService;

        @RequestMapping("/user")
        public List<User> getAllUsers(){
            return userService.getAllUsers();
        }

        @RequestMapping("/user/{id}")
        public User getSingleUser(@PathVariable int id){
            return userService.getSingleUser(id);
        }

        @RequestMapping(method = RequestMethod.POST, value = "/user")
        public void addUser(@RequestBody User user){
            userService.addUser(user);
        }

        @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
        public void updateUser(@RequestBody User user, @PathVariable int id){
            userService.updateUser(user, id);
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
        public void deleteUser(@PathVariable int id){
            userService.deleteUser(id);
        }
}

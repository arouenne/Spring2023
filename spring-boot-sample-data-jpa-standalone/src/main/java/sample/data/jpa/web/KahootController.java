package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Kahoot;
import sample.data.jpa.domain.User;
import sample.data.jpa.dto.KahootUserUpdateDto;
import sample.data.jpa.service.KahootDao;
import sample.data.jpa.service.UserDao;

import java.util.List;

@Controller
@RequestMapping("/kahoot")
public class KahootController {

    /**
     * GET /create  --> Create a new kahoot and save it in the database.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(int code) {
        String kahootId = "";
        try {
            Kahoot kahoot = new Kahoot(code);
            kahootDao.save(kahoot);
            kahootId = String.valueOf(kahoot.getId());
        } catch (Exception ex) {
            return "Error creating the kahoot: " + ex.toString();
        }
        return "Kahoot succesfully created with id = " + kahootId;
    }

    /**
     * POST /create  --> Create a new kahoot and save it in the database.
     */
    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestBody Kahoot kahoot) {
        String kahootId = "";
        try {
            kahootDao.save(kahoot);
            kahootId = String.valueOf(kahoot.getId());
        } catch (Exception ex) {
            return "Error creating the kahoot: " + ex.toString();
        }
        return "Kahoot successfully created with id = " + kahootId;
    }

    /**
     * GET /delete  --> Delete the kahoot having the passed id.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Kahoot kahoot = new Kahoot(id);
            kahootDao.delete(kahoot);
        } catch (Exception ex) {
            return "Error deleting the kahoot:" + ex.toString();
        }
        return "Kahoot succesfully deleted!";
    }

    /**
     * GET / --> Return all kahoots in database.
     */
    @RequestMapping("/kahoots")
    @ResponseBody
    public List<Kahoot> getAll() {
        return kahootDao.findAll();
    }

    @PostMapping("/add_user")
    @ResponseBody
    public String addUser(@RequestBody KahootUserUpdateDto kahootUserUpdateDto) {
        try {
            User incomingUser = kahootUserUpdateDto.getUser();
            User user = userDao.findByEmail(incomingUser.getEmail());
            if (user == null) {
                user = userDao.save(new User(incomingUser.getEmail(), incomingUser.getName()));
            }

            Kahoot kahoot = kahootDao.findById(kahootUserUpdateDto.getId())
                    .orElseThrow(() -> new RuntimeException("Kahoot not found with ID: " + kahootUserUpdateDto.getId()));

            List<User> users = kahoot.getUsers();
            users.add(user);
            kahoot.setUsers(users);

            kahootDao.save(kahoot);

            return "Added user in kahoot = " + kahoot.getId();
        } catch (Exception ex) {
            return "Error adding the user in kahoot: " + ex.toString();
        }
    }

    @Autowired
    private KahootDao kahootDao;

    @Autowired
    private UserDao userDao;
}
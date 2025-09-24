package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Kahoot;
import sample.data.jpa.service.KahootDao;
import sample.data.jpa.service.QuestionDao;

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
     * GET / --> Return all users in database.
     */
    @RequestMapping("/kahoots")
    @ResponseBody
    public List<Kahoot> getAll() {
        return kahootDao.findAll();
    }

    @Autowired
    private KahootDao kahootDao;

    @Autowired
    private QuestionDao question;
}
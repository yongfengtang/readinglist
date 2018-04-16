package readinglist.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import readinglist.entity.Book;
import readinglist.service.ReadingListService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class ReadingListController {

    @Autowired
    private ReadingListService readingListService;

    @RequestMapping(value = "/readersBooks/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList =
                readingListService.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        System.out.println("访问网页1");
        return "/readingList";
    }


    @RequestMapping(value = "/addToReadingList/{reader}", method = RequestMethod.GET)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        System.out.println("访问网页2");
        readingListService.addToReadingList(reader, book);
        return "redirect:/book/readersBooks/{reader}";
    }

}

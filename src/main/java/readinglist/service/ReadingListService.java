package readinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import readinglist.entity.Book;
import readinglist.reposity.ReadingListRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    public List<Book> findByReader(String reader){
        List<Book> books = readingListRepository.findByReader(reader);
        return books;
    }

    public void addToReadingList(String reader, Book book){
        book.setReader(reader);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        Long Id = Long.parseLong(sdf.format(date));
        book.setId(Id);
        book.setAuthor("刘慈欣");
        book.setIsbn("123456");
        book.setDescription("科幻小说");
        book.setTitle("三体");
        readingListRepository.save(book);
    }
}

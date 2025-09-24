package kr.bluenyang.practice.sec02.controller;

import kr.bluenyang.practice.sec02.model.BookDTO;
import kr.bluenyang.practice.sec02.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @RequestMapping("/")
    public String bookIndex() {
        return "sec02/index";
    }

    @RequestMapping("/book/listAllBook")
    public String listAllBook(Model model) {
        List<BookDTO> bookList = service.listAllBooks();
        model.addAttribute("bookList", bookList);

        return "sec02/book/bookListView";
    }

    @RequestMapping("/book/detailBook/{bookNo}")
    public String bookDetailView(@PathVariable String bookNo, Model model) {
        BookDTO book = service.findBookByNo(bookNo);
        model.addAttribute("book", book);

        return "sec02/book/bookDetailView";
    }
}

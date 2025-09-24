package kr.bluenyang.practice.book.controller;

import kr.bluenyang.practice.book.model.BookDTO;
import kr.bluenyang.practice.book.service.BookService;
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

    @RequestMapping("/listAllBook")
    public String listAllBook(Model model) {
        List<BookDTO> bookList = service.listAllBooks();
        model.addAttribute("bookList", bookList);

        return "book/bookListView";
    }

    @RequestMapping("/detailBook/{bookNo}")
    public String bookDetailView(@PathVariable String bookNo, Model model) {
        BookDTO book = service.findBookByNo(bookNo);
        model.addAttribute("book", book);

        return "book/bookDetailView";
    }
}

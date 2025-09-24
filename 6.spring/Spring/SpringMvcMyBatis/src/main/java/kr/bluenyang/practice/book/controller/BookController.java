package kr.bluenyang.practice.book.controller;

import kr.bluenyang.practice.book.model.BookDTO;
import kr.bluenyang.practice.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/updateBookForm/{bookNo}")
    public String updateBookForm(@PathVariable String bookNo, Model model) {
        BookDTO book = service.findBookByNo(bookNo);
        model.addAttribute("book", book);

        return "book/bookUpdateForm";
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookDTO bookDTO, RedirectAttributes ra) {
        boolean res = service.updateBook(bookDTO);

        if (!res) {
            ra.addFlashAttribute("msg", "도서 정보 수정에 실패했습니다.");
        }

        return "redirect:/book/listAllBook";
    }

    @RequestMapping("/insertBookForm")
    public String insertBookForm() {
        return "book/bookInsertForm";
    }

    @RequestMapping("/insertBook")
    public String insertBook(BookDTO bookDTO, RedirectAttributes ra) {
        boolean res = service.insertBook(bookDTO);
        if (!res) {
            ra.addFlashAttribute("msg", "도서 정보 등록에 실패했습니다.");
        }
        return "redirect:/book/listAllBook";
    }

    @RequestMapping("/deleteBook/{bookNo}")
    public String deleteBook(@PathVariable String bookNo, RedirectAttributes ra) {
        boolean res = service.deleteBook(bookNo);

        if (!res) {
            ra.addFlashAttribute("msg", "도서 정보 삭제에 실패했습니다.");
        }

        return "redirect:/book/listAllBook";
    }
}

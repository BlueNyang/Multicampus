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
    // 서비스 Inject
    private final BookService service;

    // 전체 도서 목록 조회
    @RequestMapping("/listAllBook")
    public String listAllBook(Model model) {
        // Service를 통해 DB에서 도서 목록 조회
        List<BookDTO> bookList = service.listAllBooks();
        // 조회된 도서 목록을 Model에 저장
        model.addAttribute("bookList", bookList);

        // 도서 목록 뷰로 포워딩
        return "book/bookListView";
    }

    // 도서 상세 조회
    @RequestMapping("/detailBook/{bookNo}")
    public String bookDetailView(@PathVariable String bookNo, Model model) {
        // 도서 번호에 해당하는 도서 정보 조회
        BookDTO book = service.findBookByNo(bookNo);
        // 조회된 도서 정보를 Model에 저장
        model.addAttribute("book", book);

        // 도서 상세 뷰로 포워딩
        return "book/bookDetailView";
    }

    // 도서 정보 수정 폼
    @RequestMapping("/updateBookForm/{bookNo}")
    public String updateBookForm(@PathVariable String bookNo, Model model) {
        // 도서 번호에 해당하는 도서 정보 조회
        BookDTO book = service.findBookByNo(bookNo);
        model.addAttribute("book", book);

        // 도서 정보 수정 폼 뷰로 포워딩
        return "book/bookUpdateForm";
    }

    // 도서 정보 수정 처리
    @RequestMapping("/updateBook")
    public String updateBook(BookDTO bookDTO, RedirectAttributes ra) {
        // 도서 정보 수정
        boolean res = service.updateBook(bookDTO);

        // 수정 실패 시 메시지 전달
        if (!res) {
            ra.addFlashAttribute("msg", "도서 정보 수정에 실패했습니다.");
        }

        // 전체 도서 목록으로 리다이렉트
        return "redirect:/book/listAllBook";
    }

    // 도서 정보 등록 폼
    @RequestMapping("/insertBookForm")
    public String insertBookForm() {
        // 도서 정보 등록 폼 뷰로 포워딩
        return "book/bookInsertForm";
    }

    // 도서 정보 등록 처리
    @RequestMapping("/insertBook")
    public String insertBook(BookDTO bookDTO, RedirectAttributes ra) {
        // 도서 정보 등록
        boolean res = service.insertBook(bookDTO);

        // 등록 실패 시 메시지 전달
        if (!res) {
            ra.addFlashAttribute("msg", "도서 정보 등록에 실패했습니다.");
        }

        // 전체 도서 목록으로 리다이렉트
        return "redirect:/book/listAllBook";
    }

    // 도서 정보 삭제 처리
    @RequestMapping("/deleteBook/{bookNo}")
    public String deleteBook(@PathVariable String bookNo, RedirectAttributes ra) {
        // 도서 정보 삭제
        boolean res = service.deleteBook(bookNo);

        // 삭제 실패 시 메시지 전달
        if (!res) {
            ra.addFlashAttribute("msg", "도서 정보 삭제에 실패했습니다.");
        }

        // 전체 도서 목록으로 리다이렉트
        return "redirect:/book/listAllBook";
    }
}

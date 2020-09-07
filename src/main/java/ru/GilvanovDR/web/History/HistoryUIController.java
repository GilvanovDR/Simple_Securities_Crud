package ru.GilvanovDR.web.History;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.GilvanovDR.model.History;
import ru.GilvanovDR.util.exception.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Objects;

@Controller
@RequestMapping("/history")
public class HistoryUIController extends AbstractHistoryController {

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/history";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("history", super.get(getId(request)));
        return "historyForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("history", new History(null, LocalDate.now(), 0, null, null));
        return "historyForm";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request, Model model) {
        History history = new History(
                null,
                LocalDate.parse(request.getParameter("tradeDate")),
                Integer.parseInt(request.getParameter("numTrades")),
                "".equals(request.getParameter("open")) ? null : Double.parseDouble(request.getParameter("open")),
                "".equals(request.getParameter("close")) ? null : Double.parseDouble(request.getParameter("close")));
        try {
            if (request.getParameter("id").isEmpty()) {
                super.create(history, getSecId(request));
            } else {
                history.setId(getId(request));
                super.update(history, getSecId(request));
            }
        } catch (NotFoundException e) {
            model.addAttribute("history", history);
            model.addAttribute("error", e.getMessage());
            model.addAttribute("stingSecId", getSecId(request));
            return "historyForm";
        }
        return "redirect:/history";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

    private String getSecId(HttpServletRequest request) {
        return Objects.requireNonNull(request.getParameter("secId"));
    }

    @GetMapping("/sortBy")
    public String getSortedBy(@RequestParam String field, Model model) {
        model.addAttribute("history", super.getSortedBy(field));
        return "history";
    }

    @GetMapping("/filterBy")
    public String getFilteredBy(@Nullable @RequestParam String emitentTitle, @RequestParam String tradeDate, Model model) {
        model.addAttribute("history", super.getFilteredBy(emitentTitle, "".equals(tradeDate) ? null : LocalDate.parse(tradeDate)));
        return "history";
    }
}
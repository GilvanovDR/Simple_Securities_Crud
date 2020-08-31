package ru.GilvanovDR.web.Security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.GilvanovDR.model.Security;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/security")
public class SecurityUIController extends AbstractSecurityController {

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/security";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("security", super.get(getId(request)));
        return "securityForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("security", new Security("secId", "regNumber", "name", "emitentTitle"));
        return "securityForm";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        Security security = new Security(
                request.getParameter("secId"),
                request.getParameter("regNumber"),
                request.getParameter("name"),
                request.getParameter("emitentTitle"));

        if (request.getParameter("id").isEmpty()) {
            super.create(security);
        } else {
            security.setId(getId(request));
            super.update(security);
        }
        return "redirect:/security";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
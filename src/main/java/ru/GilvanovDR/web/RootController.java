package ru.GilvanovDR.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.GilvanovDR.service.HistoryService;
import ru.GilvanovDR.service.SecuritiesService;

@Controller
public class RootController {
    @Autowired
    private SecuritiesService securitiesService;

    @Autowired
    private HistoryService historyService;


    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/history")
    public String getHistory(Model model) {
        model.addAttribute("history", historyService.getAll());
        return "history";
    }

    @GetMapping("/security")
    public String getSecurities(Model model) {
        model.addAttribute("security", securitiesService.getAll());
        return "security";
    }
}

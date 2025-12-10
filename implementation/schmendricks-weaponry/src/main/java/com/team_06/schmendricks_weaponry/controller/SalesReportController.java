package com.team_06.schmendricks_weaponry.controller;

import com.team_06.schmendricks_weaponry.service.SalesOrderService;
import com.team_06.schmendricks_weaponry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// Assuming your User class is in this package:
// import com.team_06.schmendricks_weaponry.model.User;
// or similar...

@Controller
@RequestMapping("/admin")
public class SalesReportController {

    @Autowired
    private SalesOrderService salesService;

    @Autowired
    private UserService userService;

    @GetMapping("/sales-report")
    public String showSalesReport(Model model) {
        model.addAttribute("salesOrders", salesService.loadSalesOrders());
        model.addAttribute("currentUser", userService.getCurrentUser());

        return "salesReport";
    }

}

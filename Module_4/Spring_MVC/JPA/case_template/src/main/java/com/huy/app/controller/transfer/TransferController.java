package com.huy.app.controller.transfer;

import com.huy.app.model.Transfer;
import com.huy.app.model.TransferDTO;
import com.huy.app.service.customer.ICustomerService;
import com.huy.app.service.transfer.ITransferDTOService;
import com.huy.app.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ITransferService transferService;
    @Autowired
    ITransferDTOService transferDTOService;

    @GetMapping()
    public ModelAndView showAllTransfers(){
        ModelAndView modelAndView = new ModelAndView("pages/transfer/list");
        List<TransferDTO> allTransfers = transferDTOService.findAll();
        modelAndView.addObject("transfers", allTransfers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showTransferPage() {
        ModelAndView modelAndView = new ModelAndView("/pages/transfer/create");
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("transfer", new Transfer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute Transfer transfer) {

        ModelAndView modelAndView = new ModelAndView("pages/transfer/create");
        transferService.save(transfer);

        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("transfer", new Transfer());
        return modelAndView;
    }
}

package com.byrne.cfts.controller;

import com.byrne.cfts.domain.Commodity;
import com.byrne.cfts.domain.Contract;
import com.byrne.cfts.domain.Exchange;
import com.byrne.cfts.handler.CommodityHandler;
import com.byrne.cfts.handler.ContractHandler;
import com.byrne.cfts.handler.ExchangeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(value ="/")
public class WebController {
    @Autowired
    private CommodityHandler commodityHandler;
    @Autowired
    private ExchangeHandler exchangeHandler;

    @Autowired
    private ContractHandler contractHandler;

    @GetMapping()
    public Mono<String> index(final Model model) {
        final Flux<Exchange> exchanges = exchangeHandler.findAllExchange();
        model.addAttribute("exchanges", exchanges);

        final Flux<Commodity> commodities = commodityHandler.findAllCommodity();
        model.addAttribute("commodities", commodities);

        final Flux<Contract> contracts = contractHandler.findAllContract();
        model.addAttribute("contracts", contracts);


        String path = "index";
        return Mono.create(monoSink -> monoSink.success(path));
    }

    private static final String CITY_LIST_PATH_NAME = "commodityList";

    @GetMapping("/commodity")
    public String listPage(final Model model) {
        final Flux<Commodity> commodityFluxList = commodityHandler.findAllCommodity();
        model.addAttribute("commodityList", commodityFluxList);
        return CITY_LIST_PATH_NAME;
    }
}

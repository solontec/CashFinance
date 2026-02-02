package com.cashfinance.cashfinancesf.controller;

import com.cashfinance.cashfinancesf.service.ActionService;

public class ActionController {
    public static void main(String[] args) {

        ActionService service = new ActionService();
        String resposta = service.seePrice("PETR4");

        System.out.println(resposta);
    }
}

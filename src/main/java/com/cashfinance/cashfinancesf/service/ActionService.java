package com.cashfinance.cashfinancesf.service;

import com.cashfinance.cashfinancesf.api.BrapiClient;

public class ActionService {
    private final BrapiClient brapiClient;

    public ActionService() {
        this.brapiClient = new BrapiClient();
    }

    public String seePrice(String ticker) {
        // futuramente tu pode tratar cache, validação, etc
        return brapiClient.searchAction(ticker);
    }
}

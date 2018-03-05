package com.example.demo.service;

import ca.uhn.hl7v2.hoh.raw.server.HohRawServlet;

public class MessageReceiver extends HohRawServlet {

    public MessageReceiver() {
        setMessageHandler(new MessageHandler());
    }
}

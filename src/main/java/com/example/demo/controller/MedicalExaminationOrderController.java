package com.example.demo.controller;



import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ORM_O01;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalExaminationOrderController {

    private final String ORM_MSG_TYPE = "ORM_O01";

    @PostMapping("/postmsg")
    public ResponseEntity<String> createMsg(@RequestBody String msg) throws Exception{
        HapiContext hCtx = new DefaultHapiContext();
        hCtx.setValidationRuleBuilder(new NoValidationBuilder());
        Parser parser = hCtx.getGenericParser();
        Message hapiMsg = parser.parse(msg);
        Message responseMsg;
        Terser terser = new Terser(hapiMsg);
        String msgType = terser.get("/MSH-9") + "_" + terser.get("/MSH-9-2");


        if (msgType.equals(ORM_MSG_TYPE)){
            ORM_O01 ormMsg = new ORM_O01();
            ormMsg.initQuickstart("ORM", "R01", "P");
            Terser terserOrm = new Terser(ormMsg);
            terserOrm.set("/MSH-3", terser.get("/MSH-3"));
            terserOrm.set("/MSH-4", terser.get("/MSH-4"));
            //terserOrm.set("/MSH-3", terser.get("/MSH-3"));
            return new ResponseEntity<String>(ormMsg.encode(), HttpStatus.OK);
        }

            return null;

    }
}

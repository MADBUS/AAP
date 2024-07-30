package com.test.api.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.KakaoOption;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Slf4j
@RestController
public class KakaoMessageController {
	@PostMapping("/kakao/send")
    public void SendMessage(){
        HashMap<String, String> variables = new HashMap<>();
        variables.put("#{고객명}", "아담");
        variables.put("#{상품명}", "테스트 상품");
        variables.put("#{입찰가}", "입찰가격");
        variables.put("#{수수료}", "수수료");
        variables.put("#{결제금액}", "결제금액");
        variables.put("#{결제가능시간}", "결제가능시간");
        kakaoMessage("", variables, "");
    }
    public void kakaoMessage(String templateId, HashMap<String, String> variables, String sendTo){
       final DefaultMessageService messageService = NurigoApp.INSTANCE.initialize("NCSGZXZLKLWSHU08", "GGEZ6IIHKXSUSAMD1BQBRFNL1VZ9UP48", "https://api.coolsms.co.kr");
        KakaoOption kakaoOption = new KakaoOption();
        kakaoOption.setPfId("");
        kakaoOption.setTemplateId(templateId);
        kakaoOption.setVariables(variables);

        Message message = new Message();
        message.setFrom("");
        message.setTo(sendTo);
        message.setKakaoOptions(kakaoOption);

        SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));
    }
}

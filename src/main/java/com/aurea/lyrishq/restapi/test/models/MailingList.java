package com.aurea.lyrishq.restapi.test.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MailingList {
    private String mailingListName;
    private String fromName;
    private String fromEmail;
}

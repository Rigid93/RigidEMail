package com.rigid.email.model;

import lombok.Data;

import java.util.List;

@Data
public class EmailWitchAttachments extends Email {
    List<Attachment> attachmentList;
}

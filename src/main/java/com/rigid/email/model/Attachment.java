package com.rigid.email.model;

import lombok.Data;

import java.io.File;

@Data
public class Attachment {
    File attachmentData;
    String attachmentName;
}

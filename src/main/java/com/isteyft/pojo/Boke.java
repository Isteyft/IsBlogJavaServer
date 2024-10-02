package com.isteyft.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Boke {
    private String bokeId;
    private String username;
    private String title;
    private String imgurl;
    private String txt;
    private Date loadTime;
    private Date uploadTime;
    private String top;
}

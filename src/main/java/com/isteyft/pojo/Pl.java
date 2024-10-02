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
public class Pl {
    private String plid;
    private String bokeId;
    private String username;
    private String txt;
    private Date uploadTime;
}

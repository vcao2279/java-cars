package com.vucao.cars;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarLog implements Serializable
{
    private final String text;
    private final String formattedDate;

    public CarLog(@JsonProperty String text)
    {
        this.text = text;
        Date date = new Date();
        String strDateFormat="yyyy-MM-dd hh:mm:ssa";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        formattedDate = dateFormat.format(date);
    }
}
